package fwwb.classMoments.DTO;

/**
 * Created by hongcj on 2017/5/17.
 */
public class UserWithChildDTO {
    private Integer id;

    private String user_mobile;

    private String user_name;

    private String parent_sex;

    private Integer class_id;

    private String avatar_url;

    private String background_url;

    private Boolean have_red_flower;

    private String child_name;

    private Integer child_no;

    private String child_sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getParent_sex() {
        return parent_sex;
    }

    public void setParent_sex(String parent_sex) {
        this.parent_sex = parent_sex;
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

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public Integer getChild_no() {
        return child_no;
    }

    public void setChild_no(Integer child_no) {
        this.child_no = child_no;
    }

    public String getChild_sex() {
        return child_sex;
    }

    public void setChild_sex(String child_sex) {
        this.child_sex = child_sex;
    }
}
