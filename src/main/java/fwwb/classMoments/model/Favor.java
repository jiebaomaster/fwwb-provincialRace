package fwwb.classMoments.model;

import java.sql.Timestamp;
import java.util.Date;

public class Favor {
    private Integer id;

    private Integer usersId;

    private Integer momentId;

    private Timestamp createAt;

    private Integer momentUserId;

    public Favor() {
    }

    public Favor(Integer usersId, Integer momentId,Integer momentUserId) {
        this.usersId = usersId;
        this.momentId = momentId;
        this.createAt=new Timestamp(System.currentTimeMillis());
        this.momentUserId=momentUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Integer getMomentUserId() {
        return momentUserId;
    }

    public void setMomentUserId(Integer momentUserId) {
        this.momentUserId = momentUserId;
    }
}