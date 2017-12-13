package fwwb.classMoments.model;

public class Users {
    private Integer id;

    private String phone;

    private String passwd;

    private String usersName;

    private String usersType;

    private Integer classId;

    private String accessToken;

    private String avatarUrl;

    private String backgroundUrl;

    private Boolean haveRedFlower;

    private String sex;

    public Users() {
    }

    public Users(Integer id, String phone, String usersName, String usersType, Integer classId, String avatarUrl, String backgroundUrl, Boolean haveRedFlower, String sex) {
        this.id = id;
        this.phone = phone;
        this.usersName = usersName;
        this.usersType = usersType;
        this.classId = classId;
        this.avatarUrl = avatarUrl;
        this.backgroundUrl = backgroundUrl;
        this.haveRedFlower = haveRedFlower;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName == null ? null : usersName.trim();
    }

    public String getUsersType() {
        return usersType;
    }

    public void setUsersType(String usersType) {
        this.usersType = usersType == null ? null : usersType.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl == null ? null : backgroundUrl.trim();
    }

    public Boolean getHaveRedFlower() {
        return haveRedFlower;
    }

    public void setHaveRedFlower(Boolean haveRedFlower) {
        this.haveRedFlower = haveRedFlower;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}