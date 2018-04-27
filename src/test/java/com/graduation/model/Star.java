package com.graduation.model;

import java.util.Date;

public class Star {
    private Integer id;

    private Long repositoryid;

    private String starlogin;

    private Date updated;

    public Star(Integer id, Long repositoryid, String starlogin, Date updated) {
        this.id = id;
        this.repositoryid = repositoryid;
        this.starlogin = starlogin;
        this.updated = updated;
    }

    public Star() {
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

    public String getStarlogin() {
        return starlogin;
    }

    public void setStarlogin(String starlogin) {
        this.starlogin = starlogin == null ? null : starlogin.trim();
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}