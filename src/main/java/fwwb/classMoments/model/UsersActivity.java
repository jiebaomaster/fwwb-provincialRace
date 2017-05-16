package fwwb.classMoments.model;

public class UsersActivity {
    private Integer id;

    private Integer usersId;

    private Integer activityId;

    public UsersActivity() {
    }

    public UsersActivity(Integer usersId, Integer activityId) {
        this.usersId = usersId;
        this.activityId = activityId;
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}