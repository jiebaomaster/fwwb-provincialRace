package fwwb.classMoments.convert;

import fwwb.classMoments.DTO.ActivityDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.model.ActivityModel;
import fwwb.classMoments.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/5/7.
 */

@Component
public class ActivityConvert {
    @Autowired
    private UserService userService;

    @Autowired
    private UserConvert userConvert;

    public ActivityDTO activityModel2ActivityDTO(ActivityModel activityModel) {
        List<UserDTO> userDTOList=activityModel
                .getUsersActivityList().stream()
                .map(usersActivity -> userConvert.userEntity2UserDTO(userService.doGetUserInfoByUid(usersActivity.getUsersId())))
                .collect(Collectors.toList());

        return new ActivityDTO(
                activityModel.getId(),
                activityModel.getCreateTime(),
                activityModel.getContent(),
                userConvert.userEntity2UserDTO(userService.doGetUserInfoByUid(activityModel.getPosterId())),
                userDTOList
        );
    }
}