package fwwb.classMoments.DTO;

import java.util.List;

/**
 * Created by hongcj on 2017/5/6.
 */
public class LikeDTO {
    private Integer total_num;

    private List<UserDTO> like_users;

    private MomentDTO moment;

    public Integer getTotal_num() {
        return total_num;
    }

    public LikeDTO() {
    }

    public LikeDTO(Integer total_num, List<UserDTO> like_users, MomentDTO moment) {
        this.total_num = total_num;
        this.like_users = like_users;
        this.moment = moment;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public List<UserDTO> getLike_users() {
        return like_users;
    }

    public void setLike_users(List<UserDTO> like_users) {
        this.like_users = like_users;
    }

    public MomentDTO getMoment() {
        return moment;
    }

    public void setMoment(MomentDTO moment) {
        this.moment = moment;
    }
}
