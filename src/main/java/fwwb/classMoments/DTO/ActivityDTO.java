package fwwb.classMoments.DTO;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hongcj on 2017/5/7.
 */
public class ActivityDTO {
    private Integer activity_id;

    private Timestamp activity_create_time;

    private String activity_content;

    private UserDTO activity_create_user;

    private List<UserDTO> activity_join_users;

    public ActivityDTO() {
    }

    public ActivityDTO(Integer activity_id, Timestamp activity_create_time, String activity_content, UserDTO activity_create_user, List<UserDTO> activity_join_users) {
        this.activity_id = activity_id;
        this.activity_create_time = activity_create_time;
        this.activity_content = activity_content;
        this.activity_create_user = activity_create_user;
        this.activity_join_users = activity_join_users;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public Timestamp getActivity_create_time() {
        return activity_create_time;
    }

    public void setActivity_create_time(Timestamp activity_create_time) {
        this.activity_create_time = activity_create_time;
    }

    public String getActivity_content() {
        return activity_content;
    }

    public void setActivity_content(String activity_content) {
        this.activity_content = activity_content;
    }

    public UserDTO getActivity_create_user() {
        return activity_create_user;
    }

    public void setActivity_create_user(UserDTO activity_create_user) {
        this.activity_create_user = activity_create_user;
    }

    public List<UserDTO> getActivity_join_users() {
        return activity_join_users;
    }

    public void setActivity_join_users(List<UserDTO> activity_join_users) {
        this.activity_join_users = activity_join_users;
    }
}
