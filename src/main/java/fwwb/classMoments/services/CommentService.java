package fwwb.classMoments.services;

import fwwb.classMoments.DTO.CommentCreateDTO;
import fwwb.classMoments.DTO.CommentDTO;

import java.util.List;

/**
 * Created by hongcj on 2017/4/28.
 */
public interface CommentService {

    int doGetCommentCountByMomentId(int moment_id);

    List<CommentDTO> doGetCommentsByMomentId(int moment_id);

    List<CommentDTO> doGetComments2MeByUid(int uid, int page, int count);

    CommentDTO doCreateComment(CommentCreateDTO commentCreateDTO, int uid);

    CommentDTO doDeleteCommentById(int comment_id);

    void doDeleteByMomentId(int moment_id);
}
