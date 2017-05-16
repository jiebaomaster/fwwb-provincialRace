package fwwb.classMoments.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class MomentsModel {
    private Integer id;

    private Timestamp createTime;

    private int poster_id;

    private Users users;

    private Integer classId;

    private String content;

    private Boolean isTop;

    private Timestamp topDeadline;

    private List<Source> sources;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public int getPoster_id() {
        return poster_id;
    }

    public void setPoster_id(int poster_id) {
        this.poster_id = poster_id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getTopDeadline() {
        return topDeadline;
    }

    public void setTopDeadline(Timestamp topDeadline) {
        this.topDeadline = topDeadline;
    }
}