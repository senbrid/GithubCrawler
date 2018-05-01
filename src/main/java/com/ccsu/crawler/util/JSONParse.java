package com.ccsu.crawler.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.dao.DeveloperDao;
import com.ccsu.crawler.model.*;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JSONParse {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(JSONParse.class);

    /**
     * 字符串转换成JSON数组
     *
     * @param string
     * @return List<JSONObject>
     */
    public static List<JSONObject> stringToJson(String string) {
        if (string == null || string.isEmpty() || string.equals("[]")) {
            return null;
        }
        if (string.substring(0, 1).equals("{")) {
            string = "[" + string + "]";
        }
        JSONArray jsonArray = JSONArray.parseArray(string);
        List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArray.size(); i++) {
            if (jsonArray.getJSONObject(i).getString("owner") != null) {
                JSONObject object = JSONObject.parseObject(jsonArray.getJSONObject(i).getString("owner"));
                jsonArray.getJSONObject(i).put("ownerId", object.getString("login"));
            }
            jsonObjectList.add(jsonArray.getJSONObject(i));
        }
        return jsonObjectList;
    }

    /**
     * 字符串转换成日期
     *
     * @param UTCStr
     * @return date
     */
    public static Date UTCStringtODate(String UTCStr) {
        if (UTCStr == null || UTCStr.isEmpty()) {
            return null;
        }
        String format;
        Date date = null;
        if (UTCStr.length() == 20) {
            format = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        } else {
            format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(UTCStr);
        } catch (ParseException e) {
            //e.printStackTrace();
            logger.info(e + "");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
        return calendar.getTime();
    }

    /**
     * JSON list转换成fork list
     *
     * @param jsonObjectList
     * @return List<Fork>
     */
    public static List<Fork> listJSONObjectToListFork(List<JSONObject> jsonObjectList) {
        if (jsonObjectList == null || jsonObjectList.isEmpty()) {
            return null;
        }
        List<Fork> forkList = new ArrayList<Fork>();
        for (int i = 0; i < jsonObjectList.size(); i++) {
            Fork fork = new Fork();
            fork.setForklogin(jsonObjectList.get(i).getString("ownerId"));
            forkList.add(fork);
        }
        return forkList;
    }

    /**
     * JSON list转换成fork list
     *
     * @param jsonObjectList
     * @return List<Star>
     */
    public static List<Star> listJSONObjectToListStar(List<JSONObject> jsonObjectList) {
        if (jsonObjectList == null || jsonObjectList.isEmpty()) {
            return null;
        }
        List<Star> starList = new ArrayList<Star>();
        for (int i = 0; i < jsonObjectList.size(); i++) {
            Star star = new Star();
            star.setStarlogin(jsonObjectList.get(i).getString("login"));
            starList.add(star);
        }
        return starList;
    }

    /**
     * JSON list转换成fork list
     *
     * @param jsonObjectList
     * @return List<ContributorDao>
     */
    public static List<Contributor> listJSONObjectToListContributor(List<JSONObject> jsonObjectList) {
        if (jsonObjectList == null || jsonObjectList.isEmpty()) {
            return null;
        }
        List<Contributor> contributors = new ArrayList<Contributor>();
        for (int i = 0; i < jsonObjectList.size(); i++) {
            Contributor contributor = new Contributor();
            contributor.setContributor(jsonObjectList.get(i).getString("login"));
            contributor.setContributions(jsonObjectList.get(i).getInteger("contributions"));
            contributors.add(contributor);
        }
        return contributors;
    }

    /**
     * JSON list转换成fork list
     *
     * @param jsonObjectList
     * @return List<Language>
     */
    public static List<Language> listJSONObjectToListLanguage(List<JSONObject> jsonObjectList) {
        if (jsonObjectList == null || jsonObjectList.isEmpty()) {
            return null;
        }
        List<Language> languages = new ArrayList<Language>();
        for (Map.Entry<String, Object> entry : jsonObjectList.get(0).entrySet()) {
            //System.out.println(entry.getKey() + ":" + entry.getValue());
            Language language = new Language();
            language.setLanguage(entry.getKey());
            language.setSize((int) entry.getValue());
            languages.add(language);
        }
        return languages;
    }

    /**
     * JSON list转换成branch list
     *
     * @param jsonObjectList
     * @return List<Branch>
     */
    public static List<Branch> listJSONObjectToListBranch(List<JSONObject> jsonObjectList) {
        if (jsonObjectList == null || jsonObjectList.isEmpty()) {
            return null;
        }
        List<Branch> branchList = new ArrayList<Branch>();
        for (int i = 0; i < jsonObjectList.size(); i++) {
            Branch branch = new Branch();
            branch.setBranchname(jsonObjectList.get(i).getString("name"));
            branchList.add(branch);
        }
        return branchList;
    }

    /**
     * JSON list转换成develop list
     *
     * @param jsonObjectList
     * @return List<Developer>
     */
    public static List<Developer> listJSONObjectToListDeveloper(List<JSONObject> jsonObjectList) {
        if (jsonObjectList == null || jsonObjectList.isEmpty()) {
            return null;
        }
        List<Developer> developerList = new ArrayList<Developer>();
        for (int i = 0; i < jsonObjectList.size(); i++) {
            Developer developer = new Developer();
            developer.setLogin(jsonObjectList.get(i).getString("login"));
            developer.setId(jsonObjectList.get(i).getLong("id"));
            developer.setName(jsonObjectList.get(i).getString("name"));
            developer.setAvatarUrl(jsonObjectList.get(i).getString("avatar_url"));
            developer.setCompany(jsonObjectList.get(i).getString("company"));
            developer.setBlog(jsonObjectList.get(i).getString("blog"));
            developer.setEmail(jsonObjectList.get(i).getString("email"));
            developer.setBio(jsonObjectList.get(i).getString("bio"));
            developer.setPublicRepos(jsonObjectList.get(i).getInteger("public_repos"));
            developer.setFollowers(jsonObjectList.get(i).getInteger("followers"));
            developer.setFollowing(jsonObjectList.get(i).getInteger("following"));
            developer.setType(jsonObjectList.get(i).getString("type"));
            developer.setLocation(jsonObjectList.get(i).getString("location"));
            developer.setCreatedAt(UTCStringtODate(jsonObjectList.get(i).getString("created_at")));
            developer.setUpdatedAt(UTCStringtODate(jsonObjectList.get(i).getString("updated_at")));
            developerList.add(developer);
        }
        return developerList;
    }

    /**
     * JSON list 转换成 Developer list Search
     *
     * @param list
     * @return List<Developer>
     */
    public static List<Developer> listJSONObjectToListDeveloperSearch(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Developer> developerList = new ArrayList<Developer>();
        for (int j = 0; j < list.size(); j++) {
            List<JSONObject> jsonObjectList = stringToJson(list.get(j).getString("items"));
            developerList = listJSONObjectToListDeveloper(jsonObjectList);
        }
        return developerList;
    }

    /**
     * JSON list 转换成 Repository list
     *
     * @param jsonObjectList
     * @return List<Developer>
     */
    public static List<Repository> listJSONObjectToListRepository(List<JSONObject> jsonObjectList) {
        if (jsonObjectList == null || jsonObjectList.isEmpty()) {
            return null;
        }
        List<Repository> repositoryList = new ArrayList<Repository>();
        for (int i = 0; i < jsonObjectList.size(); i++) {
            Repository repository = new Repository();
            repository.setId(jsonObjectList.get(i).getLong("id"));
            repository.setName(jsonObjectList.get(i).getString("name"));
            repository.setFullName(jsonObjectList.get(i).getString("full_name"));
            repository.setDescription(jsonObjectList.get(i).getString("description"));
            repository.setDefaultBranch(jsonObjectList.get(i).getString("default_branch"));
            repository.setCreatedAt(UTCStringtODate(jsonObjectList.get(i).getString("created_at")));
            repository.setUpdatedAt(UTCStringtODate(jsonObjectList.get(i).getString("updated_at")));
            repository.setPushedAt(UTCStringtODate(jsonObjectList.get(i).getString("pushed_at")));
            repository.setSize(jsonObjectList.get(i).getInteger("size"));
            repository.setStarCount(jsonObjectList.get(i).getInteger("stargazers_count"));
            repository.setWatchersCount(jsonObjectList.get(i).getInteger("watchers_count"));
            repository.setForksCount(jsonObjectList.get(i).getInteger("forks_count"));
            repository.setLanguage(jsonObjectList.get(i).getString("language"));
            repository.setDeveloperLogin(jsonObjectList.get(i).getString("ownerId"));
            repository.setUpdated(new Date());
            repositoryList.add(repository);
        }
        return repositoryList;
    }

    /**
     * JSON list 转换成 Repository list Search
     *
     * @param list
     * @return List<Repository>
     */
    public static List<Repository> listJSONObjectToListRepositorySearch(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Repository> repositoryList = new ArrayList<Repository>();
        for (int j = 0; j < list.size(); j++) {
            List<JSONObject> jsonObjectList = stringToJson(list.get(j).getString("items"));
            repositoryList = listJSONObjectToListRepository(jsonObjectList);
        }
        return repositoryList;
    }

}
