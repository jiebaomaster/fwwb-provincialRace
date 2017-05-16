package fwwb.classMoments.model;

import java.sql.Timestamp;

public class Activities {
    private Integer id;

    private Integer posterId;

    private Timestamp createTime;

    private String content;

    private Integer classId;


    public Activities() {
    }

    public Activities(Integer posterId, int classId, String content) {
        this.posterId = posterId;
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.content = content;
        this.classId = classId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
        this.posterId = posterId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}