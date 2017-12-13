package fwwb.classMoments.DTO;

/**
 * Created by hongcj on 2017/4/29.
 */

public class UserDTO {
    private Integer uid;

    private String user_mobile;

    private String user_name;

    private String user_type;

    private int class_id;

    private String avatar_url;

    private String background_url;

    private Boolean have_red_flower;

    private String sex;

    public UserDTO() {
    }

    public UserDTO(Integer uid, String user_mobile, String user_name, String user_type, int class_id, String avatar_url, String background_url, Boolean have_red_flower, String sex) {
        this.uid = uid;
        this.user_mobile = user_mobile;
        this.user_name = user_name;
        this.user_type = user_type;
        this.class_id = class_id;
        this.avatar_url = avatar_url;
        this.background_url = background_url;
        this.have_red_flower = have_red_flower;
        this.sex = sex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getBackground_url() {
        return background_url;
    }

    public void setBackground_url(String background_url) {
        this.background_url = background_url;
    }

    public Boolean getHave_red_flower() {
        return have_red_flower;
    }

    public void setHave_red_flower(Boolean have_red_flower) {
        this.have_red_flower = have_red_flower;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
