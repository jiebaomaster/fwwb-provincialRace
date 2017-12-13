package fwwb.classMoments.services;

import fwwb.classMoments.DTO.ActivityDTO;

import java.util.List;

/**
 * Created by hongcj on 2017/4/28.
 */

public interface ActivityService {
    ActivityDTO doShowActivity(int activity_id);

    List<ActivityDTO> getClassActivitiesByClassId(int class_id, int count, int page);

    ActivityDTO doCreateOneActivity(String activity_content,int class_id, int uid);

    ActivityDTO doJoinActivity(int activity_id, int uid);

    ActivityDTO doQuitActivity(int activity_id, int uid);
}
