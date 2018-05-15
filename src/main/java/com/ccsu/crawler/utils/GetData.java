package com.ccsu.crawler.utils;

import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.model.*;
import org.apache.log4j.Logger;

import java.util.List;

public class GetData {

    private static Logger logger = Logger.getLogger(GetData.class);

    /**
     *  获取开发者信息
     * @param login
     */
    public static List<Developer> getDeveloperData(String login){
        String url = URLBuilder.urlDeveBuilder(login);
        String data = URLRequest.sendGet(url);
        List<JSONObject> jsonObjects_Developer = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListDeveloper(jsonObjects_Developer);
    }

    /**
     *  获取用户项目仓库详细信息
     * @param fullName
     */
    public static List<Repository> getRepositoryData(String fullName){
        String url = URLBuilder.urlRepoBuilder(fullName);
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListRepository(firstJsonObjects);
    }

    /**
     *  获取用户所有项目仓库信息
     * @param login
     */
    public static List<Repository> getAllRepositoryData(String login){
        String url = URLBuilder.urlDeveAllReposBuilder(login);
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListRepository(firstJsonObjects);
    }

    /**
     *  获取项目分支信息
     * @param repository
     */
    public static List<Branch> getBranchData(Repository repository) {
        String url = URLBuilder.urlRepoPoBuilder(repository.getFullName(), "branches");
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListBranch(firstJsonObjects);
    }

    /**
     *  获取项目贡献值
     * @param repository
     */
    public static List<Contributor> getContributorData(Repository repository) {
        String url = URLBuilder.urlRepoPoBuilder(repository.getFullName(), "contributors");
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListContributor(firstJsonObjects);
    }

    /**
     *  获取项目使用的多种语言
     * @param repository
     */
    public static List<Language> getLanguageData(Repository repository) {
        String url = URLBuilder.urlRepoPoBuilder(repository.getFullName(), "languages");
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListLanguage(firstJsonObjects);
    }

    /**
     *  获取项目的star信息
     * @param repository
     */
    public static List<Star> getStarData(Repository repository) {
        String url = URLBuilder.urlRepoPoBuilder(repository.getFullName(), "stargazers");
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListStar(firstJsonObjects);
    }

    /**
     *  获取项目的fork信息
     * @param repository
     */
    public static List<Fork> getForkData(Repository repository) {
        String url = URLBuilder.urlRepoPoBuilder(repository.getFullName(), "forks");
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListFork(firstJsonObjects);
    }

    /**
     *  获取用户之间关注的关系
     * @param login
     * @param followType
     */
    public static List<Developer> getfollowData(String login, String followType) {
        String url = URLBuilder.urlFollowBuilder(login, followType);
        String data = URLRequest.sendGet(url);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(data);
        return JSONParse.listJSONObjectToListDeveloper(firstJsonObjects);
    }

}
