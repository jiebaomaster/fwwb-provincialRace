package fwwb.classMoments.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hongcj on 2017/5/7.
 */

public class ActivityModel {
    private Integer id;

    private Integer posterId;

    private Timestamp createTime;

    private String content;

    private List<UsersActivity> usersActivityList;

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
        this.content = content;
    }

    public List<UsersActivity> getUsersActivityList() {
        return usersActivityList;
    }

    public void setUsersActivityList(List<UsersActivity> usersActivityList) {
        this.usersActivityList = usersActivityList;
    }
}
