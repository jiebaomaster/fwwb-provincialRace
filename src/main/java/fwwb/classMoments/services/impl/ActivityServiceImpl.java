package fwwb.classMoments.services.impl;

import fwwb.classMoments.DAO.ActivitiesMapper;
import fwwb.classMoments.DAO.UsersActivityMapper;
import fwwb.classMoments.DTO.ActivityDTO;
import fwwb.classMoments.convert.ActivityConvert;
import fwwb.classMoments.model.Activities;
import fwwb.classMoments.model.ActivityModel;
import fwwb.classMoments.model.UsersActivity;
import fwwb.classMoments.services.ActivityService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/4/28.
 */

@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivitiesMapper activitiesMapper;

    @Autowired
    private UsersActivityMapper usersActivityMapper;

    @Autowired
    private ActivityConvert activityConvert;

    @Override
    @Transactional
    public ActivityDTO doShowActivity(int activity_id) {
        ActivityModel activityModel = activitiesMapper.getActivityModelById(activity_id);
        return activityConvert.activityModel2ActivityDTO(activityModel);
    }

    @Override
    @Transactional
    public List<ActivityDTO> getClassActivitiesByClassId(int class_id, int count, int page) {
        int start = (page - 1) * count;
        List<ActivityModel> activityModelList = activitiesMapper.selectClassActivitiesByClassId(class_id, start, count);

        return activityModelList
                .stream()
                .map(activityModel -> activityConvert.activityModel2ActivityDTO(activityModel))
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDTO doCreateOneActivity(String activity_content, int class_id, int uid) {
        Activities activities = new Activities(uid, class_id, activity_content);
        activitiesMapper.insert(activities);

        doJoinActivity(activities.getId(), uid);
        return doShowActivity(activities.getId());
    }

    /**
     * 加入活动
     * @param activity_id 活动id
     * @param uid 用户id
     * @return 活动基本信息
     */
    @Override
    public ActivityDTO doJoinActivity(int activity_id, int uid) {
        UsersActivity usersActivity = new UsersActivity(uid, activity_id);
        usersActivityMapper.insert(usersActivity);
        return doShowActivity(activity_id);
    }

    /**
     * 退出活动
     * @param activity_id 活动id
     * @param uid 用户id
     * @return 活动基本信息
     */
    @Override
    @Transactional
    public ActivityDTO doQuitActivity(int activity_id, int uid) {
        UsersActivity usersActivity = new UsersActivity(uid, activity_id);
        usersActivityMapper.deleteByObj(usersActivity);
        return doShowActivity(activity_id);
    }
}
