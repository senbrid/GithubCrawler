package com.ccsu.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.dao.DeveloperDao;
import com.ccsu.crawler.dao.FollowDao;
import com.ccsu.crawler.dao.RepositoryDao;
import com.ccsu.crawler.dao.SeedDao;
import com.ccsu.crawler.model.*;
import com.ccsu.crawler.util.JSONParse;
import com.ccsu.crawler.util.URLBuilder;
import com.ccsu.crawler.util.URLRequest;

import java.util.List;

public class MainApplication {

    public static void main(String args[]){

        SeedDao seedDao = new SeedDao();
        FollowDao followDao = new FollowDao();
        DeveloperDao developerDao = new DeveloperDao();
        RepositoryDao repositoryDao = new RepositoryDao();

        Long begin = System.currentTimeMillis();
        System.out.println("开始");

        while (true) {
            String login;
            Seed seed = seedDao.select();
            if (seed == null) {
                System.out.println("种子为空，请添加种子后重试");
                break;
            }else {
                login = seed.getSeedlogin();
                seedDao.update(seed.getId());
                int count = 0;
                //获取用户的仓库
                List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlDeveAllReposBuilder(login)));
                List<Repository> repositoryList = JSONParse.listJSONObjectToListRepository(firstJsonObjects);
                for (Repository repository : repositoryList) {
                    //判断该仓库是否符合要求，不符合就跳过
                    if (repository.getPushedAt().getTime() > (begin - 1000 * 60 * 60 * 24 * 3)) {
                        count += 1;
                        //判断表中是否已存在该数据，存在就跳过
                        if (repositoryDao.select(repository.getId()) == null) {
                            repositoryDao.insert(repository);
                            //查该仓库的其他数据
                            firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "branches")));
                            List<Branch> branchList = JSONParse.listJSONObjectToListBranch(firstJsonObjects);
                            for (Branch branch : branchList) {
                                System.out.println("待完善插入branch数据：" + JSON.toJSONString(branch));
                            }
                            firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "languages")));
                            List<Language> languageList = JSONParse.listJSONObjectToListLanguage(firstJsonObjects);
                            for (Language language : languageList) {
                                System.out.println("待完善插入language数据：" + JSON.toJSONString(language));
                            }
                            firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "forks")));
                            List<Fork> forkList = JSONParse.listJSONObjectToListFork(firstJsonObjects);
                            for (Fork fork : forkList) {
                                addSeed(fork.getForklogin());
                                System.out.println("待完善插入fork数据：" + JSON.toJSONString(fork));
                            }
                            firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "stargazers")));
                            List<Star> starList = JSONParse.listJSONObjectToListStar(firstJsonObjects);
                            for (Star star : starList) {
                                addSeed(star.getStarlogin());
                                System.out.println("待完善插入star数据：" + JSON.toJSONString(star));
                            }
                            firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "contributors")));
                            List<Contributor> contributors = JSONParse.listJSONObjectToListContributor(firstJsonObjects);
                            for (Contributor contributor : contributors) {
                                addSeed(contributor.getContributor());
                                System.out.println("待完善插入contributors数据：" + JSON.toJSONString(contributor));
                            }
                        }
                    }
                }
                //获取用户的仓库结束
                if (count > 0) {
                    //获取该用户的数据
                    List<JSONObject> jsonObjects_Developer = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlDeveBuilder(login)));
                    List<Developer> DeveloperList = JSONParse.listJSONObjectToListDeveloper(jsonObjects_Developer);
                    for (Developer developer : DeveloperList) {
                        Developer developer1 = developerDao.select(developer.getId());
                        if (developer1 == null) {
                            developerDao.insert(developer);
                        }
                    }
                    //获取用户数据结束
                    //添加关注信息
                    follow(login, "followers");
                    follow(login, "following");
                    //添加关注信息结束
                }
            }
        }
        /*
        //循环保证程序一直运行
        while (true) {
            Seed seed = seedDao.select();
            if (seed == null) {
                System.out.println("种子为空，请添加种子后重试");
            }else {
                int count = seedDao.update(seed.getId());
                System.out.println("seed update:" + count);
                login = seed.getSeedlogin();
                String url = URLBuilder.urlDeveBuilder(login);
                String result = URLRequest.sendGet(url);
                List<JSONObject> jsonObjects = JSONParse.stringToJson(result);
                List<Developer> developerList = JSONParse.listJSONObjectToListDeveloper(jsonObjects);

                for (Developer developer : developerList) {
                    Developer developer1 = developerDao.select(developer.getId());
                    if (developer1 != null) {
                        System.out.println("该条数据已存在");
                    } else {
                        int i = developerDao.insert(developer);
                        if (i == 1) {
                            System.out.println("成功插入一条数据");
                        }
                    }
                }
            }
        }
        //结束循环
        */
//        Long end = System.currentTimeMillis();
//        System.out.println("结束，共耗时：" + (end - begin) + "毫秒。");
    }

    public static void follow(String login,String followType){
        //获取用户关注和被关注
        SeedDao seedDao = new SeedDao();
        DeveloperDao developerDao = new DeveloperDao();
        FollowDao followDao = new FollowDao();

        String followers;
        String following;

        String firstUrl = URLBuilder.urlFollowBuilder(login,followType);
        String firstResult = URLRequest.sendGet(firstUrl);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(firstResult);
        List<Developer> firstDeveloperList = JSONParse.listJSONObjectToListDeveloper(firstJsonObjects);
        for (Developer developer : firstDeveloperList) {
            //添加种子
            addSeed(developer.getLogin());
            if(followType.equals("followers")){
                followers = developer.getLogin();
                following = login;
            }else{
                followers = login;
                following = developer.getLogin();
            }
            if(followDao.selectDuplicate(followers,following) == 0){
                Follow follow = new Follow();
                follow.setFollowers(followers);
                follow.setFollowing(following);
                followDao.insert(follow);
            }
        }
        //结束获取关注
    }

    public static void addSeed(String login){
        SeedDao seedDao = new SeedDao();
        //检查seed表中是否有该条记录，没有则添加
        if(seedDao.selectByLogin(login) == null){
            Seed seed = new Seed();
            seed.setSeedlogin(login);
            seed.setState(1);
            seedDao.insert(seed);
        }
    }

}
