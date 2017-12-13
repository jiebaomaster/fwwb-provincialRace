package fwwb.classMoments.model;

public class HonorWall {
    private Integer id;

    private Integer usersId;

    private Integer momentId;

    public HonorWall() {
    }

    public HonorWall(Integer usersId, Integer momentId) {
        this.usersId = usersId;
        this.momentId = momentId;
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
}