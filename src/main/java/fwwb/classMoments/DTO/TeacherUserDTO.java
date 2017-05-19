package fwwb.classMoments.DTO;

/**
 * Created by hongcj on 2017/5/17.
 */
public class TeacherUserDTO {
    private Integer id;

    private String user_mobile;

    private String user_name;

    private String sex;

    private int class_id;

    private String avatar_url;

    private String background_url;

    private Integer teacher_no;

    private String teacher_type;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public Integer getTeacher_no() {
        return teacher_no;
    }

    public void setTeacher_no(Integer teacher_no) {
        this.teacher_no = teacher_no;
    }

    public String getTeacher_type() {
        return teacher_type;
    }

    public void setTeacher_type(String teacher_type) {
        this.teacher_type = teacher_type;
    }
}
