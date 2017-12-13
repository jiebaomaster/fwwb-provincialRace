package fwwb.classMoments.controllers;

import fwwb.classMoments.DTO.PushDTO;
import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.services.externalWareService.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by hongcj on 2017/5/12.
 */
@Controller
@RequestMapping("push")
public class PushController {

    @Autowired
    @Qualifier("PushService")
    private PushService pushService;

    @RequestMapping(value = "bind", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO bind(
            @RequestBody Map<String, String> map,
            HttpServletRequest httpServletRequest
    ) {
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        String uuid = map.get("uuid");

        try {
            pushService.bind(uid, uuid);
        } catch (Exception e) {
            return new ReturnDTO("push_bind", "error", e.getMessage());
        }

        return new ReturnDTO("push_bind", "success", "");
    }


    @RequestMapping(value = "aite", method = RequestMethod.POST)
    public void aite(
            @RequestBody PushDTO pushDTO
    ) {
        String type = pushDTO.getType();
        String userName = pushDTO.getUserName();
        pushDTO.getUids().forEach(integer -> pushService.pushMessage2app(integer, type, userName));
    }
}
