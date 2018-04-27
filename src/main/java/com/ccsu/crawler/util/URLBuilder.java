package com.ccsu.crawler.util;

public class URLBuilder {

    private final static String USRS_PREFIX = "https://api.github.com/users/";
    private final static String REPO_PREFIX = "https://api.github.com/repos/";
    /**
     * 通过 用户名 构建用户URL
     *
     * @param login nama user.
     * @return String类型的URL地址
     */
    public static String urlDeveBuilder(String login) {
        return USRS_PREFIX + login;
    }

    /**
     * 通过 用户名 和 followType 构建follow URL
     *
     * @param login nama user.
     * @return String类型的URL地址
     */
    public static String urlFollowBuilder(String login , String followType) {
        return USRS_PREFIX + login + "/" + followType;
    }

    /**
     * 通过 项目全名 构建URL
     *
     * @param name
     * @return String类型的URL地址
     */
    public static String urlRepoBuilder(String name) {
        return REPO_PREFIX + name;
    }

    /**
     * 通过 搜索开发者 构建URL
     *
     * @param params
     * @return String类型的URL地址
     */
    public static String urlSearchDeveBuilder(String params) {

        return "https://api.github.com/search/users?q=" + params;
    }

    /**
     * 通过 搜索项目 构建URL
     *
     * @param params
     * @return String类型的URL地址
     */
    public static String urlSearchRepoBuilder(String params) {

        return "https://api.github.com/search/repositories?q=" + params;
    }
}
