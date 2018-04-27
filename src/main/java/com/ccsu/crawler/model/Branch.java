package com.ccsu.crawler.model;

import java.util.Date;

public class Branch {
    private Integer id;

    private Long repositoryid;

    private String branchname;

    private Date updated;

    public Branch(Integer id, Long repositoryid, String branchname, Date updated) {
        this.id = id;
        this.repositoryid = repositoryid;
        this.branchname = branchname;
        this.updated = updated;
    }

    public Branch() {
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

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname == null ? null : branchname.trim();
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}