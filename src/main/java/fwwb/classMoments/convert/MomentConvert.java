package fwwb.classMoments.convert;

import fwwb.classMoments.DTO.MomentDTO;
import fwwb.classMoments.DTO.MomentIssueDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.model.Moments;
import fwwb.classMoments.model.MomentsModel;
import fwwb.classMoments.services.CommentService;
import fwwb.classMoments.services.FavorService;
import fwwb.classMoments.utils.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by hongcj on 2017/4/30.
 */
@Component
public class MomentConvert {
    @Autowired
    @Qualifier("FavorService")
    private FavorService favorService;

    @Autowired
    @Qualifier("CommentService")
    private CommentService commentService;

    @Autowired
    private UserConvert userConvert;

    public MomentDTO momentsModel2MomentDTO(MomentsModel moments) {
        int like_count = favorService.doGetLikeCountByMomentId(moments.getId());
        int comment_count = commentService.doGetCommentCountByMomentId(moments.getId());
        UserDTO userDTO = userConvert.userEntity2UserDTO(moments.getUsers());

        return new MomentDTO(
                moments.getCreateTime(),
                moments.getId(),
                moments.getContent(),
                like_count,
                comment_count,
                moments.getTop(),
                userDTO,
                moments.getSources()
        );
    }

    public Moments momentIssueDTO2MomentsEntity(MomentIssueDTO momentIssueDTO, int uid, int class_id, int display_days) {
        return new Moments(
                new Timestamp(System.currentTimeMillis()),
                uid,
                class_id,
                momentIssueDTO.getContent(),
                momentIssueDTO.getIs_top(),
                new Timestamp(System.currentTimeMillis() + display_days * ConstantValues.ONE_DAY_TIMESTAMP)
        );
    }


}
