package fwwb.classMoments.controllers;

import fwwb.classMoments.DTO.*;
import fwwb.classMoments.convert.UserConvert;
import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/4/27.
 */

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @Autowired
    private UserConvert userConvert;

    /**
     * 登录
     *
     * @param userLoginDTO password phone
     * @return 固定的返回对象
     * @throws NoSuchAlgorithmException     md5
     * @throws UnsupportedEncodingException md5
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO login(
            @RequestBody UserLoginDTO userLoginDTO
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Users users = userService.doLogin(userLoginDTO.getPhone_num(), userLoginDTO.getPassword());

        ReturnDTO returnDTO = new ReturnDTO();
        returnDTO.setRequest_type("login.html");
        if (users != null) {
            returnDTO.setStatus("success");
            Map<String, Object> map = new HashMap<>();
            map.put("user", userConvert.userEntity2UserDTO(users));
            map.put("access_token", users.getAccessToken());
            returnDTO.setBody(map);
        } else {
            returnDTO.setStatus("error");
        }
        return returnDTO;
    }

    /**
     * 注销
     *
     * @param httpServletRequest uid
     * @return 固定的返回对象
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO logout(
            HttpServletRequest httpServletRequest
    ) {
        Users users = userService.doLogout(Integer.parseInt(httpServletRequest.getHeader("uid")));

        if (users != null) {
            return new ReturnDTO("logout", "success", userConvert.userEntity2UserDTO(users));
        } else {
            return new ReturnDTO("logout", "error", "");
        }
    }

    /**
     * 修改密码
     *
     * @param map                new_passwd
     * @param httpServletRequest uid
     * @return 固定的返回对象
     */
    @RequestMapping(value = "passwd_reset", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO resetPassword(
            @RequestBody Map<String, String> map,
            HttpServletRequest httpServletRequest
    ) {
        Users users = userService
                .doResetPasswd(Integer.parseInt(httpServletRequest.getHeader("uid")), map.get("new_passwd"));

        if (users != null) {
            return new ReturnDTO("passwd_reset", "success", userConvert.userEntity2UserDTO(users));
        } else {
            return new ReturnDTO("passwd_reset", "error", "");
        }
    }

    /**
     * 修改头像
     *
     * @param map                new_avatar_url
     * @param httpServletRequest uid
     * @return 固定的返回对象
     */
    @RequestMapping(value = "avatar_reset", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO resetAvatar(
            @RequestBody Map<String, String> map,
            HttpServletRequest httpServletRequest
    ) {
        Users users = userService
                .doResetAvatar(Integer.parseInt(httpServletRequest.getHeader("uid")), map.get("new_avatar_url"));

        if (users != null) {
            return new ReturnDTO("passwd_reset", "success", userConvert.userEntity2UserDTO(users));
        } else {
            return new ReturnDTO("passwd_reset", "error", "");
        }
    }

    /**
     * 修改背景图片
     *
     * @param map                new_background_url
     * @param httpServletRequest uid
     * @return 固定的返回对象
     */
    @RequestMapping(value = "background_reset", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO resetBackground(
            @RequestBody Map<String, String> map,
            HttpServletRequest httpServletRequest
    ) {
        Users users = userService
                .doResetBackground(Integer.parseInt(httpServletRequest.getHeader("uid")), map.get("new_background_url"));

        if (users != null) {
            return new ReturnDTO("passwd_reset", "success", userConvert.userEntity2UserDTO(users));
        } else {
            return new ReturnDTO("passwd_reset", "error", "");
        }
    }


    @RequestMapping(value = "update_userInfo", method = RequestMethod.POST)
    @ResponseBody
    public ReturnDTO updateUserInfo(
            @RequestBody UserDTO userDTO
    ) {
        Users users;

        try {
            userService.doUpdateUserInfo(userDTO);
            users = userService.doGetUserInfoByUid(userDTO.getUid());
            return new ReturnDTO("userInfo_update", "success", userConvert.userEntity2UserDTO(users));
        } catch (Exception e) {
            return new ReturnDTO("userInfo_update", "error", e.getMessage());
        }
    }

    /**
     * 返回用户信息
     *
     * @param httpServletRequest uid
     * @return 固定的返回对象
     */
    @RequestMapping(value = "show", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getMyInfo(
            HttpServletRequest httpServletRequest
    ) {
        Users users = userService
                .doGetUserInfoByUid(Integer.parseInt(httpServletRequest.getHeader("uid")));

        if (users != null) {
            return new ReturnDTO("user_show", "success", userConvert.userEntity2UserDTO(users));
        } else {
            return new ReturnDTO("user_show", "error", "");
        }
    }

    /**
     * 我的班级人员列表
     *
     * @param httpServletRequest uid
     * @return 固定的返回对象
     */
    @RequestMapping(value = "members", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getMyClass(
            HttpServletRequest httpServletRequest
    ) {
        int uid = Integer.parseInt(httpServletRequest.getHeader("uid"));
        List<Users> usersList;
        List<UserDTO> userDTOS;
        try {
            usersList = userService.doGetMembersByUid(uid);
        } catch (Exception e) {
            return new ReturnDTO("members_show", "error", e.getMessage());
        }

        userDTOS = usersList
                .stream()
                .map(users -> userConvert.userEntity2UserDTO(users))
                .collect(Collectors.toList());

        return new ReturnDTO("members_show", "success", userDTOS);
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
}
