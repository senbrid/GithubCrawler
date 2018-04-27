package com.ccsu.crawler.model;

import java.util.Date;

public class Seed {
    private Integer id;

    private String seedlogin;

    private Integer state;

    private Date updated;

    public Seed(Integer id, String seedlogin, Integer state, Date updated) {
        this.id = id;
        this.seedlogin = seedlogin;
        this.state = state;
        this.updated = updated;
    }

    public Seed() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeedlogin() {
        return seedlogin;
    }

    public void setSeedlogin(String seedlogin) {
        this.seedlogin = seedlogin == null ? null : seedlogin.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}