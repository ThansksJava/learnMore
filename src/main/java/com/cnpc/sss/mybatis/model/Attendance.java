package com.cnpc.sss.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {
    private String id;

    private String rehearseId;

    private String attendancepeople;

    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRehearseId() {
        return rehearseId;
    }

    public void setRehearseId(String rehearseId) {
        this.rehearseId = rehearseId == null ? null : rehearseId.trim();
    }

    public String getAttendancepeople() {
        return attendancepeople;
    }

    public void setAttendancepeople(String attendancepeople) {
        this.attendancepeople = attendancepeople == null ? null : attendancepeople.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}