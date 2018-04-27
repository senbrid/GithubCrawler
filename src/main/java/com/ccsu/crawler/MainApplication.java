package com.ccsu.crawler;

import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.dao.DeveloperDao;
import com.ccsu.crawler.dao.FollowDao;
import com.ccsu.crawler.dao.SeedDao;
import com.ccsu.crawler.model.Developer;
import com.ccsu.crawler.model.Follow;
import com.ccsu.crawler.model.Seed;
import com.ccsu.crawler.util.JSONParse;
import com.ccsu.crawler.util.URLBuilder;
import com.ccsu.crawler.util.URLRequest;

import java.util.List;

public class MainApplication {

    public static void main(String args[]){

        SeedDao seedDao = new SeedDao();
        FollowDao followDao = new FollowDao();
        DeveloperDao developerDao = new DeveloperDao();

        Long begin = System.currentTimeMillis();
        System.out.println("开始");

        String login = "TKaxv-7S";
        //获取该用户的数据
        String firstUrl = URLBuilder.urlDeveBuilder(login);
        String firstResult = URLRequest.sendGet(firstUrl);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(firstResult);
        List<Developer> firstDeveloperList = JSONParse.listJSONObjectToListDeveloper(firstJsonObjects);
        for (Developer developer : firstDeveloperList) {
            Developer developer1 = developerDao.select(developer.getId());
            if (developer1 != null) {
                System.out.println("developer表该条数据已存在");
            } else {
                int i = developerDao.insert(developer);
                if (i == 1) {
                    System.out.println("developer表成功插入一条数据");
                }
            }
        }
        //获取用户数据结束
        follow(login,"followers");
        follow(login,"following");
//        //获取用户关注和被关注
//        firstUrl = URLBuilder.urlFollowBuilder(login,"followers");
//        firstResult = URLRequest.sendGet(firstUrl);
//        firstJsonObjects = JSONParse.stringToJson(firstResult);
//        firstDeveloperList = JSONParse.listJSONObjectToListDeveloper(firstJsonObjects);
//        for (Developer developer : firstDeveloperList) {
//
//            Seed seed = new Seed();
//            seed.setSeedlogin(developer.getLogin());
//            seed.setState(1);
//
//            Follow follow = new Follow();
//            follow.setFollowers(login);
//            follow.setFollowing(developer.getLogin());
//
//            int count =  seedDao.insert(seed);
//            if (count == 1) {
//                System.out.println("seed表成功插入一条数据");
//            }
//            count =  followDao.insert(follow);
//            if (count == 1) {
//                System.out.println("follow表成功插入一条数据");
//            }
//            Developer developer1 = developerDao.select(developer.getId());
//            if (developer1 != null) {
//                System.out.println("developer表该条数据已存在");
//            } else {
//                int i = developerDao.insert(developer);
//                if (i == 1) {
//                    System.out.println("developer表成功插入一条数据");
//                }
//            }
//        }
//        //结束获取关注
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
        Long end = System.currentTimeMillis();
        System.out.println("结束，共耗时：" + (end - begin) + "毫秒。");
    }

    public static void follow(String login,String followType){
        //获取用户关注和被关注
        SeedDao seedDao = new SeedDao();
        DeveloperDao developerDao = new DeveloperDao();
        FollowDao followDao = new FollowDao();
        String firstUrl = URLBuilder.urlFollowBuilder(login,followType);
        String firstResult = URLRequest.sendGet(firstUrl);
        List<JSONObject> firstJsonObjects = JSONParse.stringToJson(firstResult);
        List<Developer> firstDeveloperList = JSONParse.listJSONObjectToListDeveloper(firstJsonObjects);
        for (Developer developer : firstDeveloperList) {

            Seed seed = new Seed();
            seed.setSeedlogin(developer.getLogin());
            seed.setState(1);

            Follow follow = new Follow();
            follow.setFollowers(login);
            follow.setFollowing(developer.getLogin());

            int count =  seedDao.insert(seed);
            if (count == 1) {
                System.out.println("seed表成功插入一条数据");
            }
            count =  followDao.insert(follow);
            if (count == 1) {
                System.out.println("follow表成功插入一条数据");
            }
            Developer developer1 = developerDao.select(developer.getId());
            if (developer1 != null) {
                System.out.println("developer表该条数据已存在");
            } else {
                int i = developerDao.insert(developer);
                if (i == 1) {
                    System.out.println("developer表成功插入一条数据");
                }
            }
        }
        //结束获取关注
    }
}
