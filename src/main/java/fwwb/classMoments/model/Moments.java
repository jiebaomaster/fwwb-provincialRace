package fwwb.classMoments.model;

import java.sql.Timestamp;
import java.util.Date;

public class Moments {
    private Integer id;

    private Timestamp createTime;

    private Integer poster_id;

    private Integer classId;

    private String content;

    private Boolean isTop;

    private Timestamp topDeadline;

    public Moments() {
    }

    public Moments(Timestamp createTime, Integer poster_id, Integer classId, String content, Boolean isTop, Timestamp topDeadline) {
        this.createTime = createTime;
        this.poster_id = poster_id;
        this.classId = classId;
        this.content = content;
        this.isTop = isTop;
        this.topDeadline = topDeadline;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Timestamp getTopDeadline() {
        return topDeadline;
    }

    public void setTopDeadline(Timestamp topDeadline) {
        this.topDeadline = topDeadline;
    }

    public Boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(Boolean top) {
        isTop = top;
    }

    public Integer getPosterId() {
        return poster_id;
    }

    public void setPosterId(Integer poster_id) {
        this.poster_id = poster_id;
    }
}