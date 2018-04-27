package com.graduation.model;

import java.util.Date;

public class Fork {
    private Integer id;

    private Long repositoryid;

    private String forklogin;

    private Date updated;

    public Fork(Integer id, Long repositoryid, String forklogin, Date updated) {
        this.id = id;
        this.repositoryid = repositoryid;
        this.forklogin = forklogin;
        this.updated = updated;
    }

    public Fork() {
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

    public String getForklogin() {
        return forklogin;
    }

    public void setForklogin(String forklogin) {
        this.forklogin = forklogin == null ? null : forklogin.trim();
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}