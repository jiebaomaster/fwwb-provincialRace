package fwwb.classMoments.services.impl;

import fwwb.classMoments.DAO.StudentsMapper;
import fwwb.classMoments.DAO.TeachersMapper;
import fwwb.classMoments.DAO.UsersMapper;
import fwwb.classMoments.DTO.TeacherUserDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.DTO.UserWithChildDTO;
import fwwb.classMoments.convert.UserConvert;
import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.UserService;
import fwwb.classMoments.utils.TokenCreater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/4/27.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private TeachersMapper teachersMapper;

    @Autowired
    private UserConvert userConvert;

    @Transactional
    @Override
    public boolean doCheckToken(String token, String uid) {
        return usersMapper
                .selectByPrimaryKey(Integer.parseInt(uid))
                .getAccessToken()
                .equals(token);
    }

    @Transactional
    @Override
    public Users doLogin(String phoneNum, String password
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Users users = usersMapper.selectByPhone(phoneNum);
        if (users != null && users.getPasswd().equals(password)) {
            //设置新的token
            users.setAccessToken(TokenCreater.createToken(users.getId()));
            usersMapper.updateByPrimaryKey(users);
            return users;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public Users doLogout(int uid) {
        //将token作废，赋值为"logout"
        Users users = usersMapper.selectByPrimaryKey(uid);
        users.setAccessToken("logout");
        usersMapper.updateByPrimaryKey(users);
        return users;
    }

    @Transactional
    @Override
    public Users doResetPasswd(int uid, String passwd) {
        Users users = usersMapper.selectByPrimaryKey(uid);
        users.setPasswd(passwd);
        usersMapper.updateByPrimaryKey(users);
        return users;
    }

    @Transactional
    @Override
    public Users doResetAvatar(int uid, String avatar_url) {
        Users users = usersMapper.selectByPrimaryKey(uid);
        users.setAvatarUrl(avatar_url);
        usersMapper.updateByPrimaryKey(users);
        return users;

    }

    @Transactional
    @Override
    public Users doResetBackground(int uid, String background_url) {
        Users users = usersMapper.selectByPrimaryKey(uid);
        users.setBackgroundUrl(background_url);
        usersMapper.updateByPrimaryKey(users);
        return users;
    }

    @Transactional
    @Override
    public void doUpdateUserInfo(UserDTO userDTO) {
        Users users = userConvert.usersDTO2UsersEntity(userDTO);
        usersMapper.updateByPrimaryKeySelective(users);
    }

    @Transactional
    @Override
    public Users doGetUserInfoByUid(int uid) {
        return usersMapper.selectByPrimaryKey(uid);
    }

    @Transactional
    @Override
    public UserDTO doGetUserDTOByUid(int uid) {
        return usersMapper.selectUserDTOByPrimaryKey(uid);
    }

    @Transactional
    @Override
    public List<Users> doGetMembersByUid(int uid) {
        Users users = usersMapper.selectByPrimaryKey(uid);
        return usersMapper
                .selectMembersByClassId(users)
                .stream()
                .filter(test_users -> !users.getId().equals(test_users.getId()))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<UserWithChildDTO> doGetMembersWithChildDTOByUid(int uid) {
        Users users = usersMapper.selectByPrimaryKey(uid);
        return usersMapper.selectUserWithChildDTOByClassId(users);
    }

    @Transactional
    @Override
    public List<TeacherUserDTO> doGetTeacherUserDTOByUid(int uid) {
        Users users = usersMapper.selectByPrimaryKey(uid);
        return usersMapper.selectTeacherUserDTOByClassId(users);
    }

    @Transactional
    @Override
    public void registerParentStudentAll(List<UserWithChildDTO> list) {
        usersMapper.insertParentBatch(list);
        studentsMapper.insertStudentBatch(list);
    }

    @Transactional
    @Override
    public void registerTeacherAll(List<TeacherUserDTO> list) {
        usersMapper.insertTeacherUserBatch(list);
        teachersMapper.insertTeacherBatch(list);
    }
}
