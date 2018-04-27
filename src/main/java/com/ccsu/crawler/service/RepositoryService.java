package com.ccsu.crawler.service;

import com.ccsu.crawler.model.Repository;

import java.util.List;

public interface RepositoryService {
    /**
     * 批量添加仓库数据
     *
     * @param repositoryList
     * @author Joke
     * Date 2018年3月21日15:36:35
     */
    int addRepositoryByListPO(List<Repository> repositoryList);
    /**
     * 添加仓库数据
     *
     * @param repository
     * @author Joke
     * Date 2018年3月21日15:36:35
     */
    int addRepositoryByPO(Repository repository);
    /**
     * 修改仓库数据
     *
     * @param repository
     * @author Joke
     * Date 2018年4月9日10:12:43
     */
    int updateRepositoryById(Repository repository);
    /**
     * 按主键查询
     * @return
     */
    Repository getDataById(Long id);
}

