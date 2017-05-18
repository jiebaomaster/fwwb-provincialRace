package fwwb.classMoments.convert;

import fwwb.classMoments.DTO.TeacherUserDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.DTO.UserWithChildDTO;
import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hongcj on 2017/4/27.
 */

@Component
public class UserConvert {
    public UserDTO userEntity2UserDTO(Users users) {
        return new UserDTO(
                users.getId(),
                users.getPhone(),
                users.getUsersName(),
                users.getUsersType(),
                users.getClassId(),
                users.getAvatarUrl(),
                users.getBackgroundUrl(),
                users.getHaveRedFlower()
        );
    }

    public Users usersDTO2UsersEntity(UserDTO userDTO) {
        return new Users(
                userDTO.getUid(),
                userDTO.getUser_mobile(),
                userDTO.getUser_name(),
                userDTO.getUser_type(),
                userDTO.getClass_id(),
                userDTO.getAvatar_url(),
                userDTO.getBackground_url(),
                userDTO.getHave_red_flower()
        );
    }
}
