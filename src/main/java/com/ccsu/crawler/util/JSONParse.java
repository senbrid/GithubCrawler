package com.ccsu.crawler.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.model.Developer;
import com.ccsu.crawler.model.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JSONParse {
    /**
     * 字符串转换成JSON数组
     *
     * @param string
     * @return List<JSONObject>
     */
    public static List<JSONObject> stringToJson(String string) {
        if (string.substring(0, 1).equals("{")) {
            string = "[" + string + "]";
        }
        JSONArray jsonArray = JSONArray.parseArray(string);
        List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArray.size(); i++) {
            if (jsonArray.getJSONObject(i).getString("owner") != null) {
                JSONObject object = JSONObject.parseObject(jsonArray.getJSONObject(i).getString("owner"));
                jsonArray.getJSONObject(i).put("ownerId", object.getString("id"));
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
    public static Date UTCStringtODate(String UTCStr){
        String format;
        Date date = null;
        if(UTCStr.length() == 20){
            format = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        }else {
            format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(UTCStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
        return calendar.getTime();
    }

    /**
     * JSON list转换成develop list
     *
     * @param jsonObjectList
     * @return List<Developer>
     */
    public static List<Developer> listJSONObjectToListDeveloper(List<JSONObject> jsonObjectList) {
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
            developer.setCreatedAt(UTCStringtODate(jsonObjectList.get(i).getString("created_at")));
            developer.setUpdatedAt(UTCStringtODate(jsonObjectList.get(i).getString("updated_at")));
            developer.setUpdated(new Date());
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
        List<Repository> repositoryList = new ArrayList<Repository>();
        for (int i = 0; i < jsonObjectList.size(); i++) {
            Repository repository = new Repository();
            repository.setId(jsonObjectList.get(i).getLong("id"));
            repository.setName(jsonObjectList.get(i).getString("name"));
            repository.setFullName(jsonObjectList.get(i).getString("full_name"));
            repository.setDescription(jsonObjectList.get(i).getString("description"));
            repository.setCreatedAt(UTCStringtODate(jsonObjectList.get(i).getString("created_at")));
            repository.setUpdatedAt(UTCStringtODate(jsonObjectList.get(i).getString("updated_at")));
            repository.setPushedAt(UTCStringtODate(jsonObjectList.get(i).getString("pushed_at")));
            repository.setSize(jsonObjectList.get(i).getInteger("size"));
            repository.setStarCount(jsonObjectList.get(i).getInteger("stargazers_count"));
            repository.setWatchersCount(jsonObjectList.get(i).getInteger("watchers_count"));
            repository.setForksCount(jsonObjectList.get(i).getInteger("forks_count"));
            repository.setLanguage(jsonObjectList.get(i).getString("language"));
            repository.setDeveloperid(jsonObjectList.get(i).getLong("ownerId"));
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
        List<Repository> repositoryList = new ArrayList<Repository>();
        for (int j = 0; j < list.size(); j++) {
            List<JSONObject> jsonObjectList = stringToJson(list.get(j).getString("items"));
            repositoryList = listJSONObjectToListRepository(jsonObjectList);
        }
        return repositoryList;
    }

}
