//import com.alibaba.fastjson.JSONObject;
//import com.ccsu.crawler.model.Developer;
//import com.ccsu.crawler.model.Repository;
//import com.ccsu.crawler.util.JSONParse;
//import com.ccsu.crawler.util.URLBuilder;
//import com.ccsu.crawler.util.URLRequest;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//@Component
//public class ATask {
//
//    @Autowired
//    private RepositoryService repositoryService;
//    @Autowired
//    private DeveloperService developerService;
//
//    private Logger logger = Logger.getLogger(ATask.class);
//
//    @Scheduled(fixedRate = 1000 * 60 * 60)//@Scheduled 可以作为一个触发源添加到一个方法中
//    //以一个固定延迟时间10分钟调用一次执行
//    // 这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，5s后再次执行
//    public void demo1() {
//        logger.info(" #获取数据# 开始");
//        long begin = System.currentTimeMillis();
//        //执行你需要操作的定时任务
//        String[] language = new String[]{"java","c","python","javascript"};
//        for (int i = 0; i < language.length; i++) {
//            try {
//                String param = "language:"+language[i]+"&sort=stars&per_page=100";
//                String url = URLBuilder.urlSearchRepoBuilder(param);
//                //获取网页返回的字符串
//                String str = URLRequest.sendGet(url);
//                //字符串转json
//                List<JSONObject> list = JSONParse.stringToJson(str);
//                //把JSON数据封装到实体类List
//                List<Repository> repositoryList = JSONParse.listJSONObjectToListRepositorySearch(list);
//                //去掉与数据库数据重复的数据
//                List<Repository> repositories = new ArrayList<>();
//                for (Repository repository : repositoryList) {
//                    //3天没更新的项目不添加到数据库
//                    if(repository.getUpdatedAt().getTime() > (begin-1000*60*60*24*3)) {
//                        Repository repository1 = repositoryService.getDataById(repository.getId());
//                        if (repository1 == null) {
//                            repositories.add(repository);
//                        }
//                    }
//                }
//                if (!repositories.isEmpty()) {
//                    //批量添加数据
//                    int count = repositoryService.addRepositoryByListPO(repositories);
//                    logger.info(" #获取数据# 成功添加" + count + "条 "+language[i]+" 项目数据。");
//                    StringBuilder result = new StringBuilder();
//                    for (Repository repository : repositories) {
//                        Developer developer = developerService.getDeveloperById(repository.getDeveloperid());
//                        if (developer == null) {
//                            result.append(URLRequest.sendGet(URLBuilder.urlDeveBuilder(repository.getFullName().split("/")[0])));
//                        }
//                    }
//                    if(!result.toString().isEmpty()){
//                        //字符串转json
//                        List<JSONObject> jsonObjectList = JSONParse.stringToJson(result.toString());
//                        //把JSON数据封装到实体类List
//                        List<Developer> developerList = JSONParse.listJSONObjectToListDeveloper(jsonObjectList);
//                        int countInsert = developerService.addDeveloperByListPO(removeDupliById(developerList));
//                        logger.info(" #获取数据# 成功添加" + countInsert + "条开发者数据。");
//                    }else {
//                        logger.info(" #获取数据# 没有获取到 "+language[i]+"项目 的开发者新数据。");
//                    }
//                } else {
//                    logger.info(" #获取数据# 没有获取到 "+language[i]+"项目 新数据。");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        long end = System.currentTimeMillis();
//        logger.info(" #获取数据# 结束，共耗时：[" + (end - begin) + "]毫秒");
//    }
//
//    @Scheduled(fixedRate = 1000 * 60 * 60)//@Scheduled 可以作为一个触发源添加到一个方法中
//    //以一个固定延迟时间1小时调用一次执行
//    // 这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，5s后再次执行
//    public void demo2() {
//        logger.info(" #更新developer数据# 开始");
//        long begin = System.currentTimeMillis();
//        //执行你需要操作的定时任务
//        try {
//            DeveloperExample developerExample = new DeveloperExample();
//            DeveloperExample.Criteria criteria = developerExample.createCriteria();
//            Date date = new Date(new Date().getTime() - 1000 * 60 * 60 * 24);
//            criteria.andUpdatedLessThan(date);
//            List<Developer> developerList = developerService.getDeveloperByExample(developerExample);
//            if (!developerList.isEmpty()) {
//                StringBuilder result = new StringBuilder();
//                for (Developer developer : developerList) {
//                    result.append(URLRequest.sendGet(URLBuilder.urlDeveBuilder(developer.getLogin())));
//                }
//                //字符串转json
//                List<JSONObject> jsonObjectList = JSONParse.stringToJson(result.toString());
//                //把JSON数据封装到实体类List
//                List<Developer> developers = JSONParse.listJSONObjectToListDeveloper(jsonObjectList);
//                int count = 0;
//                for(Developer developer : developers){
//                    count += developerService.updateDeveloperById(developer);
//                }
//                logger.info(" #更新developer数据# 更新 "+count+" 条developer数据");
//            }else{
//                logger.info(" #更新developer数据# 没有developer数据需要更新");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        logger.info(" #更新developer数据# 结束，共耗时：[" + (end - begin) + "]毫秒");
//    }
//
//    @Scheduled(fixedRate = 1000 * 60 * 60)//@Scheduled 可以作为一个触发源添加到一个方法中
//    //以一个固定延迟时间10分钟调用一次执行
//    // 这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，5s后再次执行
//    public void demo3() {
//        logger.info(" #更新repository数据# 开始");
//        long begin = System.currentTimeMillis();
//        //执行你需要操作的定时任务
//        try {
//            RepositoryExample repositoryExample = new RepositoryExample();
//            RepositoryExample.Criteria criteria = repositoryExample.createCriteria();
//            Date date = new Date(new Date().getTime() - 1000 * 60 * 60 * 24);
//            criteria.andUpdatedLessThan(date);
//            List<Repository> repositoryList = repositoryService.queryRepositoryByExample(repositoryExample);
//            if (!repositoryList.isEmpty()) {
//                StringBuilder result = new StringBuilder();
//                for (Repository repository : repositoryList) {
//                    result.append(URLRequest.sendGet(URLBuilder.urlRepoBuilder(repository.getFullName())));
//                }
//                //字符串转json
//                List<JSONObject> jsonObjectList = JSONParse.stringToJson(result.toString());
//                //把JSON数据封装到实体类List
//                List<Repository> repositories = JSONParse.listJSONObjectToListRepository(jsonObjectList);
//                int count = 0;
//                for(Repository repository : repositories){
//                    count += repositoryService.updateRepositoryById(repository);
//                }
//                logger.info(" #更新repository数据# 更新 "+count+" 条repository数据");
//            }else{
//                logger.info(" #更新repository数据# 没有repository数据需要更新");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        logger.info(" #更新repository数据# 结束，共耗时：[" + (end - begin) + "]毫秒");
//    }
//
////    @Scheduled(cron = "0 34 13 * * ?") //如果你需要在特定的时间执行，就需要用到cron 了
////    //这里是在每天的13点30分执行一次
////    public void demo3(){
////        logger.info("定时任务demo3开始.");
////        long begin = System.currentTimeMillis();
////        //执行你需要操作的定时任务
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        long end = System.currentTimeMillis();
////        logger.info("定时任务demo3结束，共耗时：[" + (end-begin)+ "]毫秒");
////    }
//
//    /**
//     * 根据id属性的值去掉对象列表里重复的对象
//     *
//     * @param developers
//     * @return
//     */
//    public static List<Developer> removeDupliById(List<Developer> developers) {
//        Set<Developer> personSet = new TreeSet<>((o1, o2) -> o1.getId().compareTo(o2.getId()));
//        personSet.addAll(developers);
//
//        return new ArrayList<>(personSet);
//    }
//}
