package fwwb.classMoments.model;

import fwwb.classMoments.DTO.CommentCreateDTO;

import java.sql.Timestamp;

public class Comments {
    private Integer id;

    private Integer posterId;

    private Integer replyTo;

    private Integer momentId;

    private Timestamp commentTime;

    private String content;

    public Comments() {
    }

    public Comments(Integer posterId, Integer replyTo, Integer momentId, String content) {
        this.posterId = posterId;
        this.replyTo = replyTo;
        this.momentId = momentId;
        this.content = content;
        this.commentTime = new Timestamp(System.currentTimeMillis());
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

    public Integer getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}