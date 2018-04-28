package com.graduation.model;

import java.util.Date;

public class Repository {
    private Long id;

    private String name;

    private String fullName;

    private String defaultBranch;

    private Date createdAt;

    private Date updatedAt;

    private Date pushedAt;

    private Integer size;

    private Integer starCount;

    private Integer watchersCount;

    private Integer forksCount;

    private String language;

    private String developerlogin;

    private Date updated;

    private String description;

    public Repository(Long id, String name, String fullName, String defaultBranch, Date createdAt, Date updatedAt, Date pushedAt, Integer size, Integer starCount, Integer watchersCount, Integer forksCount, String language, String developerlogin, Date updated, String description) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.defaultBranch = defaultBranch;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
        this.size = size;
        this.starCount = starCount;
        this.watchersCount = watchersCount;
        this.forksCount = forksCount;
        this.language = language;
        this.developerlogin = developerlogin;
        this.updated = updated;
        this.description = description;
    }

    public Repository() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch == null ? null : defaultBranch.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(Date pushedAt) {
        this.pushedAt = pushedAt;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    public Integer getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(Integer watchersCount) {
        this.watchersCount = watchersCount;
    }

    public Integer getForksCount() {
        return forksCount;
    }

    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getDeveloperlogin() {
        return developerlogin;
    }

    public void setDeveloperlogin(String developerlogin) {
        this.developerlogin = developerlogin == null ? null : developerlogin.trim();
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}