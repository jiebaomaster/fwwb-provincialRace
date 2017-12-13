package fwwb.classMoments.controllers;

import fwwb.classMoments.DTO.CommentCreateDTO;
import fwwb.classMoments.DTO.CommentDTO;
import fwwb.classMoments.DTO.CommentShowDTO;
import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.services.CommentService;
import fwwb.classMoments.services.externalWareService.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by hongcj on 2017/4/28.
 */

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    @Qualifier("CommentService")
    private CommentService commentService;

    @Autowired
    @Qualifier("PushService")
    private PushService pushService;

    @RequestMapping(value = "show", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getCommentsByMomentId(
            @RequestParam Integer moment_id
    ) {
        CommentShowDTO commentShowDTO = new CommentShowDTO();
        try {
            commentShowDTO.setCommentDTOList(commentService.doGetCommentsByMomentId(moment_id));
            commentShowDTO.setTotal_num(commentService.doGetCommentCountByMomentId(moment_id));
        } catch (Exception e) {
            return new ReturnDTO("comment_show", "error", e.getMessage());
        }
        return new ReturnDTO("comment_show", "success", commentShowDTO);
    }

    @RequestMapping(value = "to_me", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getComments2Me(
            @RequestParam Integer count,
            @RequestParam Integer page,
            HttpServletRequest httpServletRequest
    ) {
        List<CommentDTO> commentDTOList;
        try {
            commentDTOList = commentService.doGetComments2MeByUid(Integer.parseInt(httpServletRequest.getHeader("uid")), count, page);
        } catch (Exception e) {
            return new ReturnDTO("comment_to_me", "error", e.getMessage());
        }
        return new ReturnDTO("comment_to_me", "success", commentDTOList);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO create(
            @RequestBody CommentCreateDTO commentCreateDTO,
            HttpServletRequest httpServletRequest
    ) {
        CommentDTO commentDTO;
        try {
            commentDTO = commentService.doCreateComment(commentCreateDTO, Integer.parseInt(httpServletRequest.getHeader("uid")));
        } catch (Exception e) {
            return new ReturnDTO("comment_create", "error", e.getMessage());
        }

        pushService.pushMessage2app(commentDTO.getReply_user().getUid(), "comment", commentDTO.getPoster_user().getUser_name());
        return new ReturnDTO("comment_create", "success", commentDTO);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO delete(
            @RequestBody Map<String, Integer> map
    ) {
        int commentId = map.get("comment_id");
        CommentDTO commentDTO;
        try {
            commentDTO = commentService.doDeleteCommentById(commentId);
        } catch (Exception e) {
            return new ReturnDTO("comment_delete", "error", e.getMessage());
        }
        return new ReturnDTO("comment_delete", "success", commentDTO);
    }
}
