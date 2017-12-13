package fwwb.classMoments.controllers;

import fwwb.classMoments.DTO.FavorDTO;
import fwwb.classMoments.DTO.LikeDTO;
import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.model.Favor;
import fwwb.classMoments.services.FavorService;
import fwwb.classMoments.services.UserService;
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
@RequestMapping(value = "/like")
public class FavorController {
    @Autowired
    @Qualifier("FavorService")
    private FavorService favorService;

    @Autowired
    @Qualifier("PushService")
    private PushService pushService;

    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @RequestMapping(value = "show", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO showLikeByMomentsId(
            @RequestParam Integer moment_id
    ) {
        LikeDTO likeDTO;

        try {
            likeDTO = favorService.doGetLikeInfoByMomentId(moment_id);
        } catch (Exception e) {
            return new ReturnDTO("like_show", "error", e.getMessage());
        }
        return new ReturnDTO("like_show", "success", likeDTO);
    }

    @RequestMapping(value = "timeline", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getLikes2Me(
            @RequestParam Integer count,
            @RequestParam Integer page,
            HttpServletRequest httpServletRequest
    ) {
        List<FavorDTO> favorDTOList;
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));

        try {
            favorDTOList = favorService.doGetLikes2MeByUid(uid, count, page);
        } catch (Exception e) {
            return new ReturnDTO("like_timeline", "error", e.getMessage());
        }
        return new ReturnDTO("like_timeline", "success", favorDTOList);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO create(
            @RequestBody Map<String, Integer> map,
            HttpServletRequest httpServletRequest
    ) {
        LikeDTO likeDTO;
        int moment_id = map.get("moment_id");
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));

        try {
            favorService.doCreateOneFavor(moment_id, uid);
            likeDTO = favorService.doGetLikeInfoByMomentId(moment_id);
        } catch (Exception e) {
            return new ReturnDTO("like_create", "error", e.getMessage());
        }

        String userName = userService.doGetUserInfoByUid(uid).getUsersName();
        pushService.pushMessage2app(likeDTO.getMoment().getUserDTO().getUid(), "like", userName);
        return new ReturnDTO("like_create", "success", likeDTO);

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO delete(
            @RequestBody Map<String, Integer> map,
            HttpServletRequest httpServletRequest
    ) {

        LikeDTO likeDTO;
        int moment_id = map.get("moment_id");
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));

        try {
            favorService.doDeleteOneFavor(moment_id, uid);
            likeDTO = favorService.doGetLikeInfoByMomentId(moment_id);
        } catch (Exception e) {
            return new ReturnDTO("like_delete", "error", e.getMessage());
        }
        return new ReturnDTO("like_delete", "success", likeDTO);
    }
}
