package fwwb.classMoments.DTO;

/**
 * Created by hongcj on 2017/5/4.
 */
public class CommentCreateDTO {
    private Integer comment_id;

    private Integer moment_id;

    private String comment_content;

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

    public Integer getMoment_id() {
        return moment_id;
    }

    public void setMoment_id(Integer moment_id) {
        this.moment_id = moment_id;
    }
}
