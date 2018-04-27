package com.ccsu.crawler.service;

import com.ccsu.crawler.model.Developer;

import java.util.List;

public interface DeveloperService {
    /**
     * 添加开发者数据
     *
     * @param developerList
     * @author Joke
     * Date 2018年3月21日15:36:35
     */
    int addDeveloperByListPO(List<Developer> developerList);
    /**
     * 批量更新数据
     *
     * @param developerList
     * @author Joke
     * Date 2018年3月22日16:06:39
     */
    int updateDeveloperByListPO(List<Developer> developerList);
    /**
     * 按主键更新数据
     *
     * @param developer
     * @author Joke
     * Date 2018年4月9日09:28:07
     */
    int updateDeveloperById(Developer developer);
    /**
     * 根据开发者ID查询开发者
     *
     * @param id
     * @author Joke
     * Date 2018年4月3日12:00:37
     */
    Developer getDeveloperById(Long id);
}
