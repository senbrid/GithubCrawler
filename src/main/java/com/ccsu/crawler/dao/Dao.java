package com.ccsu.crawler.dao;

import java.util.Map;

public interface Dao<T> {

    int insert(T entity);

    T select(Map map);

    int update(Map map);
}
