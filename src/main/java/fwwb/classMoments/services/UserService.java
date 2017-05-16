package fwwb.classMoments.services;

import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.model.Users;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by hongcj on 2017/4/27.
 */
public interface UserService {

    /**
     * 执行token验证
     *
     * @param token 令牌
     * @param uid   用户id
     * @return 验证是否成功
     */
    boolean doCheckToken(String token, String uid);

    Users doLogin(String phoneNum, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    Users doLogout(int uid);

    Users doResetPasswd(int uid, String passwd);

    Users doResetAvatar(int uid, String avatar_url);

    Users doResetBackground(int uid, String background_url);

    void doUpdateUserInfo(UserDTO userDTO);

    Users doGetUserInfoByUid(int uid);

    List<Users> doGetMembersByUid(int uid);
}
