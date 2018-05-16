package com.cnpc.sss.mybatis.model;

import java.util.Date;

public class Music {
    private String id;

    private String uploadpeople;

    private Date time;

    private String path;

    private String copyright;

    private String voicepart;

    private String rhythm;

    private String lyrics;

    private String writemusic;

    private String jianpu;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getVoicepart() {
        return voicepart;
    }

    public void setVoicepart(String voicepart) {
        this.voicepart = voicepart == null ? null : voicepart.trim();
    }

    public String getRhythm() {
        return rhythm;
    }

    public void setRhythm(String rhythm) {
        this.rhythm = rhythm == null ? null : rhythm.trim();
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics == null ? null : lyrics.trim();
    }

    public String getWritemusic() {
        return writemusic;
    }

    public void setWritemusic(String writemusic) {
        this.writemusic = writemusic == null ? null : writemusic.trim();
    }

    public String getJianpu() {
        return jianpu;
    }

    public void setJianpu(String jianpu) {
        this.jianpu = jianpu == null ? null : jianpu.trim();
    }
}