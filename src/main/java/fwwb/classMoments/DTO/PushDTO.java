package fwwb.classMoments.DTO;

import java.util.List;

/**
 * Created by hongcj on 2017/5/12.
 */
public class PushDTO {
    private List<Integer> uids;

    private String userName;

    private String type;

    public List<Integer> getUids() {
        return uids;
    }

    public void setUids(List<Integer> uids) {
        this.uids = uids;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
