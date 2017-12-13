package fwwb.classMoments.convert;

import fwwb.classMoments.DTO.CommentDTO;
import fwwb.classMoments.model.Comments;
import fwwb.classMoments.services.MomentService;
import fwwb.classMoments.services.UserService;
import fwwb.classMoments.utils.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hongcj on 2017/5/3.
 */
@Component
public class CommentConvert {
    @Autowired
    private UserService userService;

    @Autowired
    private MomentService momentService;

    @Autowired
    private MomentConvert momentConvert;

    @Autowired
    private UserConvert userConvert;

    public CommentDTO comment2CommentDTO(Comments comments) {
        return comments.getReplyTo().equals(ConstantValues.REPLY_2_EMPTY) ?
                new CommentDTO(
                        comments.getCommentTime(),
                        comments.getId(),
                        comments.getContent(),
                        userConvert.userEntity2UserDTO(userService.doGetUserInfoByUid(comments.getPosterId())),
                        momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(comments.getMomentId()))) :
                new CommentDTO(
                        comments.getCommentTime(),
                        comments.getId(),
                        comments.getContent(),
                        userConvert.userEntity2UserDTO(userService.doGetUserInfoByUid(comments.getPosterId())),
                        userConvert.userEntity2UserDTO(userService.doGetUserInfoByUid(comments.getReplyTo())),
                        momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(comments.getMomentId()))
                );
    }
}
