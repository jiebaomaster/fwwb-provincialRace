package fwwb.classMoments.DTO;

import java.util.List;

/**
 * Created by hongcj on 2017/5/3.
 */
public class CommentShowDTO {
    private  Integer total_num;
    private List<CommentDTO> commentDTOList;

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public List<CommentDTO> getCommentDTOList() {
        return commentDTOList;
    }

    public void setCommentDTOList(List<CommentDTO> commentDTOList) {
        this.commentDTOList = commentDTOList;
    }
}
