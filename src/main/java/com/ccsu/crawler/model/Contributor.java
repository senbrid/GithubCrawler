package com.ccsu.crawler.model;

import java.util.Date;

public class Contributor {
    private Integer id;

    private Long repositoryid;

    private String contributor;

    private Integer contributions;

    private Date updated;

    public Contributor(Integer id, Long repositoryid, String contributor, Integer contributions, Date updated) {
        this.id = id;
        this.repositoryid = repositoryid;
        this.contributor = contributor;
        this.contributions = contributions;
        this.updated = updated;
    }

    public Contributor() {
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

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor == null ? null : contributor.trim();
    }

    public Integer getContributions() {
        return contributions;
    }

    public void setContributions(Integer contributions) {
        this.contributions = contributions;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}