package fwwb.classMoments.controllers;

import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.UserService;
import fwwb.classMoments.utils.ConstantValues;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by hongcj on 2017/5/8.
 */

@RequestMapping(value = "/webapp")
@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(
            @CookieValue(value = "uid", required = false) String uid,
            @CookieValue(value = "access-token", required = false) String token,
            @CookieValue(value = "remember-me", required = false) String rememberMe
    ) {
        if (rememberMe != null && rememberMe.equals("yes") && userService.doCheckToken(token, uid)) {
            return "admin";
        } else {
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(
            @RequestParam String phone_num,
            @RequestParam String password,
            @RequestParam String rememberMe,
            HttpServletResponse httpServletResponse
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Users users;
        try {
            users = userService.doLogin(phone_num, password);
        } catch (Exception e) {
            return "error";
        }

        if (users != null) {
            Cookie uid = new Cookie("uid", users.getId().toString());
            Cookie accessToken = new Cookie("access-token", users.getAccessToken());
            httpServletResponse.addCookie(uid);
            httpServletResponse.addCookie(accessToken);

            //选择了记住我则设置一个7天过期的cookie
            if (rememberMe.equals("yes")) {
                Cookie rememberMeCookie = new Cookie("remember-me", "yes");
                rememberMeCookie.setMaxAge(ConstantValues.ONE_DAY_TIMESTAMP * 7);
                httpServletResponse.addCookie(rememberMeCookie);
            }
            return "admin";
        } else {
            return "login";
        }
    }
}
