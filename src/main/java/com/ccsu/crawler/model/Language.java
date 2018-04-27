package com.ccsu.crawler.model;

import java.util.Date;

public class Language {
    private Integer id;

    private Long repositoryid;

    private String language;

    private Integer size;

    private Date updated;

    public Language(Integer id, Long repositoryid, String language, Integer size, Date updated) {
        this.id = id;
        this.repositoryid = repositoryid;
        this.language = language;
        this.size = size;
        this.updated = updated;
    }

    public Language() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRepositoryid() {
        return repositoryid;
    }

    public void setRepositoryid(Long repositoryid) {
        this.repositoryid = repositoryid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}