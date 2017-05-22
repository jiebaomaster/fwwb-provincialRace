package fwwb.classMoments.controllers.webApp;

import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.DTO.TeacherUserDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.DTO.UserWithChildDTO;
import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.UserService;
import fwwb.classMoments.utils.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * Created by hongcj on 2017/5/19.
 */

@Controller
@RequestMapping(value = "/webapp/user")
public class UserWebController {
    @Autowired
    private UserService userService;

    @RequestMapping("admin")
    public String getAdmin(
            @CookieValue(value = "uid", required = false) String uid,
            @CookieValue(value = "access-token", required = false) String token
    ) {
        if (userService.doCheckToken(token, uid)) {
            return "admin";
        } else {
            return "redirect:login";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(
            @CookieValue(value = "remember-me", required = false) String rememberMe
    ) {
        if (rememberMe != null && rememberMe.equals("yes")) {
            return "redirect:admin";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String login(
            @RequestParam String phone_num,
            @RequestParam String password,
            @RequestParam(required = false) String rememberMe,
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
            Cookie rememberMeCookie;
            if (rememberMe != null && rememberMe.equals("yes")) {
                //选择了记住我则设置一个7天过期的cookie
                rememberMeCookie = new Cookie("remember-me", "yes");
                uid.setMaxAge(ConstantValues.ONE_DAY_TIMESTAMP * 7);
                accessToken.setMaxAge(ConstantValues.ONE_DAY_TIMESTAMP * 7);
                rememberMeCookie.setMaxAge(ConstantValues.ONE_DAY_TIMESTAMP * 7);
                httpServletResponse.addCookie(rememberMeCookie);
            } else {
                //为选择记住我，则设置一个立马过期的cookie，即删除cookie
                rememberMeCookie = new Cookie("remember-me", null);
                rememberMeCookie.setMaxAge(0);
                httpServletResponse.addCookie(rememberMeCookie);
            }
            httpServletResponse.addCookie(uid);
            httpServletResponse.addCookie(accessToken);
            return "redirect:admin";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "classUserInfoWithChild", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getMyClassWithChild(
            HttpServletRequest httpServletRequest
    ) {
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        List<UserWithChildDTO> userWithChildDTOS;
        try {
            userWithChildDTOS = userService.doGetMembersWithChildDTOByUid(uid);
        } catch (Exception e) {
            return new ReturnDTO("members_child_show", "error", e.getMessage());
        }

        return new ReturnDTO("members_child_show", "success", userWithChildDTOS);
    }

    @RequestMapping(value = "classTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getClassTeacher(
            HttpServletRequest httpServletRequest
    ) {
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        List<TeacherUserDTO> teacherUserDTOS;
        try {
            teacherUserDTOS = userService.doGetTeacherUserDTOByUid(uid);
        } catch (Exception e) {
            return new ReturnDTO("members_teacher_show", "error", e.getMessage());
        }

        return new ReturnDTO("members_teacher_show", "success", teacherUserDTOS);
    }

    @RequestMapping(value = "addParentWithChild", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO addParentWithChild(
            @RequestBody List<UserWithChildDTO> userWithChildDTOList
    ) {
        try {
            userService.registerParentStudentAll(userWithChildDTOList);
        } catch (Exception e) {
            return new ReturnDTO("add_parent_student", "error", e.getMessage());
        }

        return new ReturnDTO("add_parent_student", "success", userWithChildDTOList);
    }


    @RequestMapping(value = "addTeacher", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO addTeacher(
            @RequestBody List<TeacherUserDTO> teacherUserDTOList
    ) {
        try {
            userService.registerTeacherAll(teacherUserDTOList);
        } catch (Exception e) {
            return new ReturnDTO("add_teacher", "error", e.getMessage());
        }

        return new ReturnDTO("add_teacher", "success", teacherUserDTOList);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO userDelete(
            @RequestBody Map<String, Integer> map
    ) {
        UserDTO userDTO;
        int uid=map.get("userNo");
        try {
            userDTO = userService.userDeleteByUid(uid);
        } catch (Exception e) {
            return new ReturnDTO("delete_user", "error", e.getMessage());
        }

        return new ReturnDTO("delete_user", "success", userDTO);
    }
}
