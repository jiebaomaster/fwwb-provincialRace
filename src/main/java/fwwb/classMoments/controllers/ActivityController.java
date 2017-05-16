package fwwb.classMoments.controllers;

import fwwb.classMoments.DTO.ActivityDTO;
import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.services.ActivityService;
import fwwb.classMoments.services.UserService;
import org.apache.ibatis.annotations.Many;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongcj on 2017/4/28.
 */

@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    @Qualifier("ActivityService")
    private ActivityService activityService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "show", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO showActivity(
            @RequestParam Integer activity_id
    ) {
        ActivityDTO activity;
        try {
            activity = activityService.doShowActivity(activity_id);
        } catch (Exception e) {
            return new ReturnDTO("show_activity", "error", e.getMessage());
        }

        Map<String, ActivityDTO> mapReturn = new HashMap<>();
        mapReturn.put("activity", activity);
        return new ReturnDTO("show_activity", "success", mapReturn);
    }

    @RequestMapping(value = "class_timeline", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getClassActivities(
            @RequestParam Integer page,
            @RequestParam Integer count,
            HttpServletRequest httpServletRequest
    ) {
        List<ActivityDTO> activities;
        int class_id;
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        try {
            class_id = userService.doGetUserInfoByUid(uid).getClassId();
            activities = activityService.getClassActivitiesByClassId(class_id, count, page);
        } catch (Exception e) {
            return new ReturnDTO("activity_class_timeline", "success", e.getMessage());
        }

        Map<String, List<ActivityDTO>> map = new HashMap<>();
        map.put("activities", activities);
        return new ReturnDTO("activity_class_timeline", "success", map);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO createActivity(
            @RequestBody Map<String, String> map,
            HttpServletRequest httpServletRequest
    ) {
        int class_id;
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        String activity_content = map.get("activity_content");
        ActivityDTO activity;
        try {
            class_id = userService.doGetUserInfoByUid(uid).getClassId();
            activity = activityService.doCreateOneActivity(activity_content, class_id, uid);
        } catch (Exception e) {
            return new ReturnDTO("create_activity", "error", e.getMessage());
        }

        Map<String, ActivityDTO> mapReturn = new HashMap<>();
        mapReturn.put("activity", activity);
        return new ReturnDTO("create_activity", "success", mapReturn);

    }

    @RequestMapping(value = "join", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO joinActivity(
            @RequestBody Map<String, Integer> map,
            HttpServletRequest httpServletRequest
    ) {
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        int activity_id = map.get("activity_id");
        ActivityDTO activity;
        try {
            activity = activityService.doJoinActivity(activity_id, uid);
        } catch (Exception e) {
            return new ReturnDTO("join_activity", "error", e.getMessage());
        }

        Map<String, ActivityDTO> mapReturn = new HashMap<>();
        mapReturn.put("activity", activity);
        return new ReturnDTO("join_activity", "success", mapReturn);
    }

    @RequestMapping(value = "quit", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO quitActivity(
            @RequestBody Map<String, Integer> map,
            HttpServletRequest httpServletRequest
    ) {
        int activity_id = map.get("activity_id");
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        ActivityDTO activity;
        try {
            activity = activityService.doQuitActivity(activity_id, uid);
        } catch (Exception e) {
            return new ReturnDTO("quit_activity", "error", e.getMessage());
        }

        Map<String, ActivityDTO> mapReturn = new HashMap<>();
        mapReturn.put("activity", activity);
        return new ReturnDTO("quit_activity", "success", mapReturn);
    }
}
