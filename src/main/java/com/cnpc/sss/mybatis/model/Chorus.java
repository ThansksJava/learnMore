package com.cnpc.sss.mybatis.model;

public class Chorus {
    private String id;

    private String chrousname;

    private Integer membernum;

    private Integer voicepartnum;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChrousname() {
        return chrousname;
    }

    public void setChrousname(String chrousname) {
        this.chrousname = chrousname == null ? null : chrousname.trim();
    }

    public Integer getMembernum() {
        return membernum;
    }

    public void setMembernum(Integer membernum) {
        this.membernum = membernum;
    }

    public Integer getVoicepartnum() {
        return voicepartnum;
    }

    public void setVoicepartnum(Integer voicepartnum) {
        this.voicepartnum = voicepartnum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}