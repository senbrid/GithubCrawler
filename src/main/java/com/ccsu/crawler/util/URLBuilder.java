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
        return USRS_PREFIX + login + "/" + followType + "?per_page=100";
    }

    /**
     * 通过 用户名 构建 用户所有仓库 URL
     *
     * @param login nama user.
     * @return String类型的URL地址
     */
    public static String urlDeveAllReposBuilder(String login) {
        return USRS_PREFIX + login + "/repos?sort=pushed&per_page=100";
    }

    /**
     * 通过 项目全名 构建 详细信息的 URL
     *
     * @param fullName
     * @return String类型的URL地址
     */
    public static String urlRepoPoBuilder(String fullName,String type) {
        return REPO_PREFIX + fullName + "/" + type + "?per_page=100";
    }

    /**
     * 通过 项目全名 构建 仓库 URL
     *
     * @param fullName
     * @return String类型的URL地址
     */
    public static String urlRepoBuilder(String fullName) {
        return REPO_PREFIX + fullName;
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
