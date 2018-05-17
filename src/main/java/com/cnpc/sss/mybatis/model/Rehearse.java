package com.cnpc.sss.mybatis.model;

import java.util.Date;

/**
 * 排练
 */
public class Rehearse {
    private String id;

    private String chorusId;

    private String location;

    private Date time;

    private String director;

    private String pianist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChorusId() {
        return chorusId;
    }

    public void setChorusId(String chorusId) {
        this.chorusId = chorusId == null ? null : chorusId.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getPianist() {
        return pianist;
    }

    public void setPianist(String pianist) {
        this.pianist = pianist == null ? null : pianist.trim();
    }
}