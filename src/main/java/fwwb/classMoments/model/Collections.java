package fwwb.classMoments.model;

import java.sql.Timestamp;

public class Collections {
    private Integer id;

    private Integer usersId;

    private Integer momentId;

    private Timestamp createAt;

    public Collections(Integer usersId, Integer momentId) {
        this.usersId = usersId;
        this.momentId = momentId;
        this.createAt = new Timestamp(System.currentTimeMillis());
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
}