package fwwb.classMoments.controllers;

import fwwb.classMoments.DTO.MomentDTO;
import fwwb.classMoments.DTO.MomentIssueDTO;
import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.convert.MomentConvert;
import fwwb.classMoments.model.MomentsModel;
import fwwb.classMoments.services.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/4/28.
 */

@Controller
@RequestMapping(value = "moment")
public class MomentController {
    @Autowired
    @Qualifier("MomentService")
    private MomentService momentService;

    @Autowired
    private MomentConvert momentConvert;

    @RequestMapping(value = "class_public_timeline", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getClassMoments(
            @RequestParam Integer count,
            @RequestParam Integer page,
            @RequestParam Integer class_id
    ) {
        List<MomentsModel> momentsModelList;
        try {
            momentsModelList = momentService.doGetClassMomentsByClassId(class_id, count, page);
        } catch (Exception e) {
            return new ReturnDTO("moment_class_public", "error", e.getMessage());
        }
        List<MomentDTO> momentDTOList = momentsModelList
                .stream()
                .map(momentDTOListItem -> momentConvert.momentsModel2MomentDTO(momentDTOListItem))
                .collect(Collectors.toList());
        return new ReturnDTO("moment_my_public", "success", momentDTOList);
    }

    @RequestMapping(value = "user_timeline", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getMyMoments(
            @RequestParam Integer count,
            @RequestParam Integer page,
            @RequestParam Integer uid
    ) {
        List<MomentsModel> momentsModelList;
        try {
            momentsModelList = momentService.doGetMyMomentsByUid(uid, count, page);
        } catch (Exception e) {
            return new ReturnDTO("moment_my_public", "error", e.getMessage());
        }

        List<MomentDTO> momentDTOList = momentsModelList
                .stream()
                .map(momentDTOListItem -> momentConvert.momentsModel2MomentDTO(momentDTOListItem))
                .collect(Collectors.toList());
        return new ReturnDTO("moment_my_public", "success", momentDTOList);
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getOneMoment(
            @RequestParam Integer momentId
    ) {
        MomentsModel momentsModel;
        try {
            momentsModel = momentService.doGetOneMomentById(momentId);
        } catch (Exception e) {
            return new ReturnDTO("moment_show", "error", e.getMessage());
        }

        MomentDTO momentDTO = momentConvert.momentsModel2MomentDTO(momentsModel);
        return new ReturnDTO("moment_show", "success", momentDTO);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO issue(
            @RequestBody MomentIssueDTO momentIssueDTO,
            HttpServletRequest httpServletRequest
    ) {
        MomentsModel momentsModel;
        try {
            momentsModel = momentService.doIssueMomentByUid(Integer.parseInt(httpServletRequest.getHeader("uid")), momentIssueDTO);
        } catch (Exception e) {
            return new ReturnDTO("moment_issue", "error", e.getMessage());
        }
        return new ReturnDTO("moment_issue", "success", momentConvert.momentsModel2MomentDTO(momentsModel));
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO delete(
            @RequestBody Map<String,Integer> map
    ) {
        int momentId = map.get("moment_id");
        MomentsModel momentsModel;
        try {
            momentsModel = momentService.doDeleteMomentById(momentId);
        } catch (Exception e) {
            return new ReturnDTO("moment_delete", "error", e.getMessage());
        }
        return new ReturnDTO("moment_delete", "success", momentConvert.momentsModel2MomentDTO(momentsModel));
    }
}
