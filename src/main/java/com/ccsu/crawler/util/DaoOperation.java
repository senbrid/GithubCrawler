package com.ccsu.crawler.util;

import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.dao.*;
import com.ccsu.crawler.model.*;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DaoOperation {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DaoOperation.class);

    /**
     *  添加项目信息
     * @param login
     */
    public static void addRepository(String login){
        logger.info("----------add repository login: " + login);
        //获取用户的仓库
        int count = 0;
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlDeveAllReposBuilder(login)));
        List<Repository> repositoryList = JSONParse.listJSONObjectToListRepository(firstJsonObjects);
        if(repositoryList != null && !repositoryList.isEmpty()){
            for (Repository repository : repositoryList) {
                if(repository.getPushedAt() == null){
                    continue;
                }
                //判断该仓库是否符合要求，不符合就跳过
                if (validate(repository)) {
                    //判断表中是否已存在该数据，存在就跳过
                    if (RepositoryDao.select(repository.getId()) == null) {
                        count += 1;
                        RepositoryDao.insert(repository);
                        addBranch(repository);
                        addLanguage(repository);
                        addFork(repository);
                        addStar(repository);
                        addContributor(repository);
                    }
                }
            }
            //获取用户的仓库结束
            if (count > 0) {
                addDeveloper(login);
                follow(login, "followers");
                follow(login, "following");
            }
        }
        logger.info("----------end add repository");
    }

    /**
     *  项目的筛选条件
     * @param repository
     */
    public static boolean validate(Repository repository){
        if(repository.getPushedAt().getTime() > (System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7)){
            if(repository.getStarCount() > 2000){
                return true;
            }
        }
        return false;
    }

    /**
     *  项目分支信息
     * @param repository
     */
    public static void addBranch(Repository repository) {
        logger.info("----------add branch fullName: " + repository.getFullName());
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "branches")));
        List<Branch> branchList = JSONParse.listJSONObjectToListBranch(firstJsonObjects);
        if(branchList != null && !branchList.isEmpty()){
            for (Branch branch : branchList) {
                branch.setRepositoryid(repository.getId());
                BranchDao.insert(branch);
            }
        }
        logger.info("----------end add branch");
    }

    /**
     *  项目贡献值
     * @param repository
     */
    public static void addContributor(Repository repository) {
        logger.info("----------add contributor fullName: " + repository.getFullName());
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "contributors")));
        List<Contributor> contributors = JSONParse.listJSONObjectToListContributor(firstJsonObjects);
        if(contributors != null && !contributors.isEmpty() ) {
            for (Contributor contributor : contributors) {
                contributor.setRepositoryid(repository.getId());
                ContributorDao.insert(contributor);
                addSeed(contributor.getContributor());
            }
        }
        logger.info("----------end add contributor");
    }

    /**
     *  项目使用的多种语言
     * @param repository
     */
    public static void addLanguage(Repository repository) {
        logger.info("----------add language fullName: " + repository.getFullName());
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "languages")));
        List<Language> languageList = JSONParse.listJSONObjectToListLanguage(firstJsonObjects);
        if(languageList != null && !languageList.isEmpty()){
            for (Language language : languageList) {
                language.setRepositoryid(repository.getId());
                LanguageDao.insert(language);
            }
        }
        logger.info("----------end add language");
    }

    /**
     *  存储项目的star信息
     * @param repository
     */
    public static void addStar(Repository repository) {
        logger.info("----------add star fullName: " + repository.getFullName());
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "stargazers")));
        List<Star> starList = JSONParse.listJSONObjectToListStar(firstJsonObjects);
        if(starList != null && !starList.isEmpty() ){
            for (Star star : starList) {
                star.setRepositoryid(repository.getId());
                StarDao.insert(star);
                addSeed(star.getStarlogin());
            }
        }
        logger.info("----------end add star");
    }

    /**
     * 存储项目的fork信息
     * @param repository
     */
    public static void addFork(Repository repository) {
        logger.info("----------add fork fullName: " + repository.getFullName());
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlRepoPoBuilder(repository.getFullName(), "forks")));
        List<Fork> forkList = JSONParse.listJSONObjectToListFork(firstJsonObjects);
        if(forkList != null && !forkList.isEmpty()){
            for (Fork fork : forkList) {
                fork.setRepositoryid(repository.getId());
                ForkDao.insert(fork);
                addSeed(fork.getForklogin());
            }
        }
        logger.info("----------end add fork");
    }

    /**
     * 添加开发者信息
     * @param login
     */
    public static void addDeveloper(String login){
        logger.info("----------add developer login: " + login);
        List<JSONObject> jsonObjects_Developer = JSONParse.stringToJson(URLRequest.sendGet(URLBuilder.urlDeveBuilder(login)));
        List<Developer> developerList = JSONParse.listJSONObjectToListDeveloper(jsonObjects_Developer);
        if(developerList != null && !developerList.isEmpty()){
            for (Developer developer : developerList) {
                if (DeveloperDao.select(developer.getId()) == null) {
                    DeveloperDao.insert(developer);
                }
            }
        }
        logger.info("----------end add developer");
    }

    /**
     * 添加用户之间关注的关系
     * @param login
     * @param followType
     */
    public static void follow(String login, String followType) {
        logger.info("----------add follow login: " + login);
        String firstUrl = URLBuilder.urlFollowBuilder(login, followType);
        String firstResult = URLRequest.sendGet(firstUrl);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(firstResult);
        List<Developer> firstDeveloperList = JSONParse.listJSONObjectToListDeveloper(firstJsonObjects);
        if(firstDeveloperList != null && !firstDeveloperList.isEmpty()){
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
                if (FollowDao.selectDuplicate(followers, following) == 0) {
                    Follow follow = new Follow();
                    follow.setFollowers(followers);
                    follow.setFollowing(following);
                    FollowDao.insert(follow);
                }
            }
        }
        logger.info("----------end add follow");
    }

    /**
     * 把当前获取的username存到seed表
     * @param login
     */
    public static void addSeed(String login) {
        logger.info("----------add seed login: " + login);
        //检查seed表中是否有该条记录，没有则添加
//        if (seedDao.selectByLogin(login) == null) {
        Seed seed = new Seed();
        seed.setSeedlogin(login);
        seed.setState(1);
        SeedDao.insert(seed);
//        }
        logger.info("----------end add seed");
    }

    /**
     * 从数据库seed表获取username
     * @return
     */
    public static Seed getSeed() {
        Seed seed = SeedDao.select();
        SeedDao.update(seed.getId());
        logger.info("----------get seed login: " + seed.getSeedlogin());
        return seed;
    }
}
