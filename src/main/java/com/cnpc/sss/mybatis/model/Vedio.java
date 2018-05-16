package com.cnpc.sss.mybatis.model;

import java.util.Date;

public class Vedio {
    private String id;

    private String uploadpeople;

    private String name;

    private Date uploadtime;

    private String path;

    private String format;

    private String mins;

    private Integer size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUploadpeople() {
        return uploadpeople;
    }

    public void setUploadpeople(String uploadpeople) {
        this.uploadpeople = uploadpeople == null ? null : uploadpeople.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public String getMins() {
        return mins;
    }

    public void setMins(String mins) {
        this.mins = mins == null ? null : mins.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}