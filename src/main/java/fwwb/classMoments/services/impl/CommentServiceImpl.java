package fwwb.classMoments.services.impl;

import fwwb.classMoments.DAO.CommentsMapper;
import fwwb.classMoments.DTO.CommentCreateDTO;
import fwwb.classMoments.DTO.CommentDTO;
import fwwb.classMoments.convert.CommentConvert;
import fwwb.classMoments.model.Comments;
import fwwb.classMoments.services.CommentService;
import fwwb.classMoments.utils.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/4/28.
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private CommentConvert commentConvert;

    @Transactional
    @Override
    public int doGetCommentCountByMomentId(int moment_id) {
        return commentsMapper.countCommentByMomentId(moment_id);
    }

    @Transactional
    @Override
    public List<CommentDTO> doGetCommentsByMomentId(int moment_id) {
        List<Comments> commentsList = commentsMapper.selectByMomentId(moment_id);

        return commentsList
                .stream()
                .map(comments -> commentConvert.comment2CommentDTO(comments))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<CommentDTO> doGetComments2MeByUid(int uid, int count, int page) {
        int start = (page - 1) * count;
        List<Comments> commentsList = commentsMapper.selectByUid(uid, start, count);

        return commentsList
                .stream()
                .map(comments -> commentConvert.comment2CommentDTO(comments))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CommentDTO doCreateComment(CommentCreateDTO commentCreateDTO, int uid) {

        int reply_to;
        if (commentCreateDTO.getComment_id() == null) {
            reply_to = ConstantValues.REPLY_2_EMPTY;
        } else {
            reply_to = commentsMapper.selectByPrimaryKey(commentCreateDTO.getComment_id()).getPosterId();

        }

        Comments comments = new Comments(
                uid,
                reply_to,
                commentCreateDTO.getMoment_id(),
                commentCreateDTO.getComment_content());
        commentsMapper.insert(comments);

        return commentConvert.comment2CommentDTO(comments);
    }

    @Transactional
    @Override
    public CommentDTO doDeleteCommentById(int comment_id) {
        Comments comments = commentsMapper.selectByPrimaryKey(comment_id);
        commentsMapper.deleteByPrimaryKey(comment_id);
        return commentConvert.comment2CommentDTO(comments);
    }

    @Transactional
    @Override
    public void doDeleteByMomentId(int moment_id) {
        commentsMapper.deleteByMomentId(moment_id);
    }
}