package com.ccsu.crawler;

import com.ccsu.crawler.model.*;
import com.ccsu.crawler.utils.DBUtil;
import com.ccsu.crawler.utils.GetData;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {

    private static Logger logger = Logger.getLogger(MainApplication.class);

    public static void main(String args[]) throws Exception {
        while (true) {
            start();
            logger.info("====================Line====================");
        }
    }

    private static void start() throws Exception {
        String login = getSeed();
        if (login.isEmpty()) {
            try {
                logger.info("种子为空,请添加种子后重试,5分钟后继续执行代码");
                Thread.sleep(1000 * 60 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            //开始爬取数据
            crawling(login);
        }
    }

    /**
     *  爬取数据逻辑
     * @param login
     */
    private static void crawling(String login) throws Exception {

        List<Developer> developerList = GetData.getDeveloperData(login);
        //判断该用户名是否存在，不存在就返回
        if(developerList == null || developerList.isEmpty()){
            return;
        }
        List<Repository> repositoryList = GetData.getAllRepositoryData(login);
        //判断该开发者是否存在开源项目仓库
        if(repositoryList == null || repositoryList.isEmpty()){
            return;
        }
        int count = 0;
        for(Repository repository : repositoryList){
            List<Repository> repositoryData = GetData.getRepositoryData(repository.getFullName());
            if(repositoryData == null || repositoryData.isEmpty()){
                continue;
            }
            if(validate(repositoryData.get(0))){
                Map<String,Object> map = repositoryConvertToMap(repositoryData.get(0));
                count += DBUtil.insert("tb_repository", map);
                List<Branch> branchList = GetData.getBranchData(repositoryData.get(0));
                for(Branch branch : branchList){
                    Map<String,Object> branchMap = new HashMap<>();
                    branchMap.put("repositoryId",repositoryData.get(0).getId());
                    branchMap.put("branchName",branch.getBranchname());
                    DBUtil.insert("tb_branch", branchMap);
                }
                List<Contributor> contributorList = GetData.getContributorData(repositoryData.get(0));
                for(Contributor contributor : contributorList){
                    Map<String,Object> contributorMap = new HashMap<>();
                    contributorMap.put("repositoryId",repositoryData.get(0).getId());
                    contributorMap.put("contributor",contributor.getContributor());
                    contributorMap.put("contributions",contributor.getContributions());
                    DBUtil.insert("tb_contributor", contributorMap);
                }
                List<Fork> forkList = GetData.getForkData(repositoryData.get(0));
                for(Fork fork : forkList){
                    addSeed(fork.getForklogin());
                    Map<String,Object> forkMap = new HashMap<>();
                    forkMap.put("repositoryId",repositoryData.get(0).getId());
                    forkMap.put("forkLogin",fork.getForklogin());
                    DBUtil.insert("tb_fork", forkMap);
                }
                List<Language> languageList = GetData.getLanguageData(repositoryData.get(0));
                for(Language language : languageList){
                    Map<String,Object> languageMap = new HashMap<>();
                    languageMap.put("repositoryId",repositoryData.get(0).getId());
                    languageMap.put("language",language.getLanguage());
                    languageMap.put("size",language.getSize());
                    DBUtil.insert("tb_language", languageMap);
                }
                List<Star> starList = GetData.getStarData(repositoryData.get(0));
                for(Star star : starList){
                    addSeed(star.getStarlogin());
                    Map<String,Object> starMap = new HashMap<>();
                    starMap.put("repositoryId",repositoryData.get(0).getId());
                    starMap.put("starLogin",star.getStarlogin());
                    DBUtil.insert("tb_star", starMap);
                }
            }
        }
        if(count > 0){
            Map<String,Object> map = developerConvertToMap(developerList.get(0));
            DBUtil.insert("tb_developer",map);
            List<Developer> followersList = GetData.getfollowData(login, "followers");
            for(Developer developer : followersList){
                addSeed(developer.getLogin());
                Map<String,Object> mapFollowers = new HashMap<>();
                mapFollowers.put("followers",developer.getLogin());
                mapFollowers.put("following",login);
                DBUtil.insert("tb_follow",mapFollowers);
            }
            List<Developer> followingList = GetData.getfollowData(login, "following");
            for(Developer developer : followingList){
                addSeed(developer.getLogin());
                Map<String,Object> mapFollowing = new HashMap<>();
                mapFollowing.put("followers",login);
                mapFollowing.put("following",developer.getLogin());
                DBUtil.insert("tb_follow",mapFollowing);
            }
        }
    }

    /**
     * 把当前获取的username存到seed表
     * @param login
     */
    public static void addSeed(String login) throws SQLException {
        Map<String,Object> mapSeed = new HashMap<>();
        mapSeed.put("seedLogin",login);
        mapSeed.put("state",1);
        DBUtil.insert("tb_seed",mapSeed);
    }

    /**
     * 从数据库seed表获取种子username
     * @return String
     */
    private static String getSeed() throws SQLException {
        String sql = "select * from tb_seed where state = 1 limit 0,1";
        List<Map<String, Object>> mapList = DBUtil.query(sql);
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("state",0);
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("id",mapList.get(0).get("id"));
        DBUtil.update("tb_seed",valueMap,whereMap);
        return (String)mapList.get(0).get("seedLogin");
    }

    /**
     *  项目的筛选条件
     * @param repository
     */
    private static boolean validate(Repository repository){
        if(repository.getPushedAt().getTime() > (System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7)){
            if(repository.getStarCount() > 2000){
                return true;
            }
        }
        return false;
    }

    private static Map<String, Object> convertToMap(Object obj)
            throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            boolean accessFlag = fields[i].isAccessible();
            fields[i].setAccessible(true);

            Object o = fields[i].get(obj);
            if (o != null)
                map.put(varName, o.toString());

            fields[i].setAccessible(accessFlag);
        }

        return map;
    }

    private static Map<String, Object> repositoryConvertToMap(Repository repository){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("developerLogin",repository.getDeveloperLogin());
        map.put("default_branch",repository.getDefaultBranch());
        map.put("full_name",repository.getFullName());
        map.put("description",repository.getDescription());
        map.put("language",repository.getLanguage());
        map.put("pushed_at",repository.getPushedAt());
        map.put("forks_count",repository.getForksCount());
        map.put("created_at",repository.getCreatedAt());
        map.put("star_count",repository.getStarCount());
        map.put("watchers_count",repository.getWatchersCount());
        map.put("size",repository.getSize());
        map.put("name",repository.getName());
        map.put("id",repository.getId());
        map.put("updated",repository.getUpdated());
        map.put("updated_at",repository.getUpdatedAt());
        return map;
    }

    private static Map<String, Object> developerConvertToMap(Developer developer){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("avatar_url",developer.getAvatarUrl());
        map.put("login",developer.getLogin());
        map.put("company",developer.getCompany());
        map.put("location",developer.getLocation());
        map.put("blog",developer.getBlog());
        map.put("email",developer.getEmail());
        map.put("bio",developer.getBio());
        map.put("created_at",developer.getCreatedAt());
        map.put("type",developer.getType());
        map.put("followers",developer.getFollowers());
        map.put("following",developer.getFollowing());
        map.put("name",developer.getName());
        map.put("id",developer.getId());
        map.put("updated",developer.getUpdated());
        map.put("updated_at",developer.getUpdatedAt());
        map.put("public_repos",developer.getPublicRepos());
        return map;
    }

}
