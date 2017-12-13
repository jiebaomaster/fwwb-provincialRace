package fwwb.classMoments.model;

public class Push {
    private Integer id;

    private Integer usersId;

    private String uuid;

    public Push() {
    }

    public Push(Integer usersId, String uuid) {
        this.usersId = usersId;
        this.uuid = uuid;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}