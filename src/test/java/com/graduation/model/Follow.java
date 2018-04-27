package com.graduation.model;

import java.util.Date;

public class Follow {
    private Integer id;

    private String followers;

    private String following;

    private Date updated;

    public Follow(Integer id, String followers, String following, Date updated) {
        this.id = id;
        this.followers = followers;
        this.following = following;
        this.updated = updated;
    }

    public Follow() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers == null ? null : followers.trim();
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following == null ? null : following.trim();
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}