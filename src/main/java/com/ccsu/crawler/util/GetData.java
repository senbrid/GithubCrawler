package com.ccsu.crawler.util;

import com.alibaba.fastjson.JSONObject;
import com.ccsu.crawler.model.Developer;
import com.ccsu.crawler.model.Repository;
import com.ccsu.crawler.service.DeveloperService;
import com.ccsu.crawler.service.RepositoryService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GetData {

    private Logger logger = Logger.getLogger(GetData.class);
    private RepositoryService repositoryService;
    private DeveloperService developerService;

    public void demo1() {
        logger.info(" #获取数据# 开始");
        long begin = System.currentTimeMillis();
        //执行你需要操作的定时任务
        String[] language = new String[]{"java","c","python","javascript"};
        for (int i = 0; i < language.length; i++) {
            try {
                String param = "language:"+language[i]+"&sort=stars&per_page=100";
                String url = URLBuilder.urlSearchRepoBuilder(param);
                //获取网页返回的字符串
                String str = URLRequest.sendGet(url);
                //字符串转json
                List<JSONObject> list = JSONParse.stringToJson(str);
                //把JSON数据封装到实体类List
                List<Repository> repositoryList = JSONParse.listJSONObjectToListRepositorySearch(list);
                //去掉与数据库数据重复的数据
                List<Repository> repositories = new ArrayList<Repository>();
                for (Repository repository : repositoryList) {
                    //3天没更新的项目不添加到数据库
                    if(repository.getUpdatedAt().getTime() > (begin-1000*60*60*24*3)) {
                        Repository repository1 = repositoryService.getDataById(repository.getId());
                        if (repository1 == null) {
                            repositories.add(repository);
                        }
                    }
                }
                if (!repositories.isEmpty()) {
                    //批量添加数据
                    int count = repositoryService.addRepositoryByListPO(repositories);
                    logger.info(" #获取数据# 成功添加" + count + "条 "+language[i]+" 项目数据。");
                    StringBuilder result = new StringBuilder();
                    for (Repository repository : repositories) {
                        Developer developer = developerService.getDeveloperById(repository.getDeveloperid());
                        if (developer == null) {
                            result.append(URLRequest.sendGet(URLBuilder.urlDeveBuilder(repository.getFullName().split("/")[0])));
                        }
                    }
                    if(!result.toString().isEmpty()){
                        //字符串转json
                        List<JSONObject> jsonObjectList = JSONParse.stringToJson(result.toString());
                        //把JSON数据封装到实体类List
                        List<Developer> developerList = JSONParse.listJSONObjectToListDeveloper(jsonObjectList);
                        int countInsert = developerService.addDeveloperByListPO(removeDupliById(developerList));
                        logger.info(" #获取数据# 成功添加" + countInsert + "条开发者数据。");
                    }else {
                        logger.info(" #获取数据# 没有获取到 "+language[i]+"项目 的开发者新数据。");
                    }
                } else {
                    logger.info(" #获取数据# 没有获取到 "+language[i]+"项目 新数据。");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        logger.info(" #获取数据# 结束，共耗时：[" + (end - begin) + "]毫秒");
    }

    /**
     * 根据id属性的值去掉对象列表里重复的对象
     *
     * @param developers
     * @return
     */
    public static List<Developer> removeDupliById(List<Developer> developers) {
        Set<Developer> personSet = new TreeSet<>((o1, o2) -> o1.getId().compareTo(o2.getId()));
        personSet.addAll(developers);

        return new ArrayList<>(personSet);
    }

}
