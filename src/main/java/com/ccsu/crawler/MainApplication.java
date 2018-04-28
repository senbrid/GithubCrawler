package com.ccsu.crawler;

import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.dao.*;
import com.ccsu.crawler.model.*;
import com.ccsu.crawler.util.JSONParse;
import com.ccsu.crawler.util.URLBuilder;
import com.ccsu.crawler.util.URLRequest;

import java.util.List;

public class MainApplication {

    public static void main(String args[]) {
        while (true) {
            Seed seed = getSeed();
            if (seed == null) {
                System.out.println("种子为空，请添加种子后重试");
                break;
            }
            addRepository(seed.getSeedlogin());
        }
    }

    public static void addRepository(String login){
        //获取用户的仓库
        int count = 0;
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlDeveAllReposBuilder(login)));
        List<Repository> repositoryList = JSONParse.listJSONObjectToListRepository(firstJsonObjects);
        if(repositoryList != null && !repositoryList.isEmpty()){
            RepositoryDao repositoryDao = new RepositoryDao();
            for (Repository repository : repositoryList) {
                if(repository.getPushedAt() == null){
                    continue;
                }
                //判断该仓库是否符合要求，不符合就跳过
                if (validate(repository)) {
                    //判断表中是否已存在该数据，存在就跳过
                    if (repositoryDao.select(repository.getId()) == null) {
                        count += 1;
                        repositoryDao.insert(repository);
                        addBranch(repository);
                        addLanguage(repository);
                        addFork(repository);
                        addStar(repository);
                        addContributor(repository);
                    }
                }
            }
            repositoryDao.closed();
            //获取用户的仓库结束
            if (count > 0) {
                addDeveloper(login);
                follow(login, "followers");
                follow(login, "following");
            }
        }
    }
    //项目的筛选条件
    public static boolean validate(Repository repository){
        if(repository.getPushedAt().getTime() > (System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 3)){
            if(repository.getStarCount() > 2000){
                return true;
            }
        }
        return false;
    }

    public static void addBranch(Repository repository) {
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "branches")));
        List<Branch> branchList = JSONParse.listJSONObjectToListBranch(firstJsonObjects);
        if(branchList != null && !branchList.isEmpty()){
            BranchDao branchDao = new BranchDao();
            for (Branch branch : branchList) {
                branch.setRepositoryid(repository.getId());
                branchDao.insert(branch);
            }
            //关闭数据库连接
            branchDao.closed();
        }
    }

    public static void addContributor(Repository repository) {
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "contributors")));
        List<Contributor> contributors = JSONParse.listJSONObjectToListContributor(firstJsonObjects);
        if(contributors != null && !contributors.isEmpty() ) {
            ContributorDao contributorDao = new ContributorDao();
            for (Contributor contributor : contributors) {
                contributor.setRepositoryid(repository.getId());
                contributorDao.insert(contributor);
                addSeed(contributor.getContributor());
            }
            //关闭数据库连接
            contributorDao.closed();
        }
    }

    public static void addLanguage(Repository repository) {
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "languages")));
        List<Language> languageList = JSONParse.listJSONObjectToListLanguage(firstJsonObjects);
        if(languageList != null && !languageList.isEmpty()){
            LanguageDao languageDao = new LanguageDao();
            for (Language language : languageList) {
                language.setRepositoryid(repository.getId());
                languageDao.insert(language);
            }
            //关闭数据库连接
            languageDao.closed();
        }
    }

    public static void addStar(Repository repository) {
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "stargazers")));
        List<Star> starList = JSONParse.listJSONObjectToListStar(firstJsonObjects);
        if(starList != null && !starList.isEmpty() ){
            StarDao starDao = new StarDao();
            for (Star star : starList) {
                star.setRepositoryid(repository.getId());
                starDao.insert(star);
                addSeed(star.getStarlogin());
            }
            //关闭数据库连接
            starDao.closed();
        }
    }

    public static void addFork(Repository repository) {
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "forks")));
        List<Fork> forkList = JSONParse.listJSONObjectToListFork(firstJsonObjects);
        if(forkList != null && !forkList.isEmpty()){
            ForkDao forkDao = new ForkDao();
            for (Fork fork : forkList) {
                fork.setRepositoryid(repository.getId());
                forkDao.insert(fork);
                addSeed(fork.getForklogin());
            }
            //关闭数据库连接
            forkDao.closed();
        }
    }

    public static void addDeveloper(String login){
        List<JSONObject> jsonObjects_Developer = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlDeveBuilder(login)));
        List<Developer> developerList = JSONParse.listJSONObjectToListDeveloper(jsonObjects_Developer);
        if(developerList != null && !developerList.isEmpty()){
            DeveloperDao developerDao = new DeveloperDao();
            for (Developer developer : developerList) {
                if (developerDao.select(developer.getId()) == null) {
                    developerDao.insert(developer);
                }
            }
            developerDao.closed();
        }
    }

    public static void follow(String login, String followType) {
        String firstUrl = URLBuilder.urlFollowBuilder(login, followType);
        String firstResult = URLRequest.sendGet(firstUrl);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(firstResult);
        List<Developer> firstDeveloperList = JSONParse.listJSONObjectToListDeveloper(firstJsonObjects);
        if(firstDeveloperList != null && !firstDeveloperList.isEmpty()){
            FollowDao followDao = new FollowDao();
            for (Developer developer : firstDeveloperList) {
                String followers;
                String following;
                //添加种子
                addSeed(developer.getLogin());
                if (followType.equals("followers")) {
                    followers = developer.getLogin();
                    following = login;
                } else {
                    followers = login;
                    following = developer.getLogin();
                }
                if (followDao.selectDuplicate(followers, following) == 0) {
                    Follow follow = new Follow();
                    follow.setFollowers(followers);
                    follow.setFollowing(following);
                    followDao.insert(follow);
                }
            }
            //关闭数据库连接
            followDao.closed();
        }
    }

    public static void addSeed(String login) {
        SeedDao seedDao = new SeedDao();
        //检查seed表中是否有该条记录，没有则添加
        if (seedDao.selectByLogin(login) == null) {
            Seed seed = new Seed();
            seed.setSeedlogin(login);
            seed.setState(1);
            seedDao.insert(seed);
        }
        //关闭数据库连接
        seedDao.closed();
    }

    public static Seed getSeed() {
        SeedDao seedDao = new SeedDao();
        Seed seed = seedDao.select();
        if (seed == null) {
            seedDao.closed();
            return null;
        }
        seedDao.update(seed.getId());
        seedDao.closed();
        return seed;
    }

}
