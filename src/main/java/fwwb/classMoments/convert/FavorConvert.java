package fwwb.classMoments.convert;

import fwwb.classMoments.DTO.FavorDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.model.Favor;
import fwwb.classMoments.services.MomentService;
import fwwb.classMoments.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hongcj on 2017/5/7.
 */
@Component
public class FavorConvert {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConvert userConvert;

    @Autowired
    private MomentService momentService;

    @Autowired
    private MomentConvert momentConvert;

    public static UserDTO getUserDTOFromFavorDTO(FavorDTO favorDTO) {
        return favorDTO.getUserDTO();
    }

    public FavorDTO favor2FavorDTO(Favor favor) {
        return new FavorDTO(
                userConvert.userEntity2UserDTO(userService.doGetUserInfoByUid(favor.getUsersId())),
                momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(favor.getMomentId())),
                favor.getCreateAt()
        );
    }
}
