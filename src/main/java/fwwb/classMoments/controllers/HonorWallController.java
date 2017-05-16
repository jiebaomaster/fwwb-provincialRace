package fwwb.classMoments.controllers;

import fwwb.classMoments.DTO.HonorWallDTO;
import fwwb.classMoments.DTO.MomentDTO;
import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.model.HonorWall;
import fwwb.classMoments.services.HonorWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by hongcj on 2017/5/7.
 */

@RequestMapping("honorWall")
@Controller
public class HonorWallController {
    @Autowired
    @Qualifier("HonorWallService")
    private HonorWallService honorWallService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO createItem(
            @RequestBody Map<String, Integer> map,
            HttpServletRequest httpServletRequest
    ) {
        int moment_id = map.get("moment_id");
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        HonorWallDTO honorWallDTO;

        try {
            honorWallDTO = honorWallService.doCreateOneHonorWallItem(moment_id, uid);
            return new ReturnDTO("create_honorWallItem", "success", honorWallDTO);
        } catch (Exception e) {
            return new ReturnDTO("create_honorWallItem", "error", e.getMessage());
        }
    }

    @RequestMapping(value = "timeline", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getTimeline(
            @RequestParam Integer count,
            @RequestParam Integer page,
            HttpServletRequest httpServletRequest
    ) {
        List<MomentDTO> momentDTOList;
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));

        try {
                momentDTOList = honorWallService.getMomentDTOListByUid(uid, count, page);
            return new ReturnDTO("HonorWall_timeline", "success", momentDTOList);
        } catch (Exception e) {
            return new ReturnDTO("HonorWall_timeline", "error", e.getMessage());
        }
    }
}
