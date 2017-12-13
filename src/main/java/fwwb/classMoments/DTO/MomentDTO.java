package fwwb.classMoments.DTO;

import fwwb.classMoments.model.Source;
import fwwb.classMoments.model.Users;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by hongcj on 2017/4/30.
 */

public class MomentDTO {
    private Timestamp create_time;
    private int moment_id;
    private String content;
    private int like_count;
    private int comment_count;
    private boolean is_top;
    private UserDTO userDTO;
    private List<Source> sources;

    public MomentDTO() {
    }

    public MomentDTO(Timestamp create_time, int moment_id, String content, int like_count, int comment_count, boolean is_top, UserDTO userDTO, List<Source> sourceList) {
        this.create_time = create_time;
        this.moment_id = moment_id;
        this.content = content;
        this.like_count = like_count;
        this.comment_count = comment_count;
        this.is_top = is_top;
        this.userDTO = userDTO;
        this.sources = sourceList;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getMoment_id() {
        return moment_id;
    }

    public void setMoment_id(int moment_id) {
        this.moment_id = moment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public boolean isIs_top() {
        return is_top;
    }

    public void setIs_top(boolean is_top) {
        this.is_top = is_top;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sourceList) {
        this.sources = sourceList;
    }
}
