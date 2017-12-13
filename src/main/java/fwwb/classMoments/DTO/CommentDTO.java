package fwwb.classMoments.DTO;

import com.sun.org.apache.bcel.internal.generic.NEW;
import fwwb.classMoments.model.Users;

import java.sql.Timestamp;

/**
 * Created by hongcj on 2017/5/3.
 */
public class CommentDTO {
    private Timestamp comment_time;

    private Integer comment_id;

    private String comment_content;

    private UserDTO poster_user;

    private UserDTO reply_user;

    private MomentDTO momentDTO;

    public CommentDTO() {
    }

    public CommentDTO(Timestamp comment_time, Integer comment_id, String comment_content, UserDTO poster_user, MomentDTO momentDTO) {
        this.comment_time = comment_time;
        this.comment_id = comment_id;
        this.comment_content = comment_content;
        this.poster_user = poster_user;
        this.reply_user= new UserDTO();
        this.momentDTO = momentDTO;
    }

    public CommentDTO(Timestamp comment_time, Integer comment_id, String comment_content, UserDTO poster_user, UserDTO reply_user, MomentDTO momentDTO) {
        this.comment_time = comment_time;
        this.comment_id = comment_id;
        this.comment_content = comment_content;
        this.poster_user = poster_user;
        this.reply_user = reply_user;
        this.momentDTO = momentDTO;
    }

    public Timestamp getComment_time() {
        return comment_time;
    }

    public void setComment_time(Timestamp comment_time) {
        this.comment_time = comment_time;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }


    public UserDTO getPoster_user() {
        return poster_user;
    }

    public void setPoster_user(UserDTO poster_user) {
        this.poster_user = poster_user;
    }

    public UserDTO getReply_user() {
        return reply_user;
    }

    public void setReply_user(UserDTO reply_user) {
        this.reply_user = reply_user;
    }

    public MomentDTO getMomentDTO() {
        return momentDTO;
    }

    public void setMomentDTO(MomentDTO momentDTO) {
        this.momentDTO = momentDTO;
    }
}
