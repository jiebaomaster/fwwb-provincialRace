package fwwb.classMoments.controllers;

import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.externalWareService.PushService;
import fwwb.classMoments.services.UserService;
import fwwb.classMoments.utils.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hongcj on 2017/4/28.
 */

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

//    @Autowired
//    @Qualifier("PushService")
//    private PushService pushService;

//    @RequestMapping(value = "getOneUser")
//    public String getOneUser(
//            @RequestParam("id") int id,
//            Model model
//    ) {
//        Users users = userService.getUserById(id);
//        model.addAttribute("user", users);
//        return "test";
//    }

    @RequestMapping(value = "JSON")
    @ResponseBody
    public Object testJSON(
            @RequestBody Users users
    ) {
        System.out.print(users.getId());
        System.out.print(users.getUsersName());

        Users myUsers = new Users();
        myUsers.setId(1);
        return myUsers;
    }

    @RequestMapping(value = "interceptor")
    public String testInterceptor() {
        return "success";
    }

//    @RequestMapping("testPush")
//    public void testPush(
//            @RequestParam("uid") int id
//    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        String uuid = MD5Encoder.EncoderByMd5(Integer.toString(id));
//        String msg = "{\"msg\":\"test ddpuch\"}";
//        pushService.pushMessage2app(uuid, msg);
//    }
}
