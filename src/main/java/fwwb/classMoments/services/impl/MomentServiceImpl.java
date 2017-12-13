package fwwb.classMoments.services.impl;

import fwwb.classMoments.DAO.MomentsMapper;
import fwwb.classMoments.DAO.SourceMapper;
import fwwb.classMoments.DAO.UsersMapper;
import fwwb.classMoments.DTO.MomentIssueDTO;
import fwwb.classMoments.DTO.SourceDTO;
import fwwb.classMoments.convert.MomentConvert;
import fwwb.classMoments.model.Moments;
import fwwb.classMoments.model.MomentsModel;
import fwwb.classMoments.model.Source;
import fwwb.classMoments.model.Users;
import fwwb.classMoments.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hongcj on 2017/4/28.
 */
@Service("MomentService")
public class MomentServiceImpl implements MomentService {
    @Autowired
    private MomentsMapper momentsMapper;

    @Autowired
    private MomentConvert momentConvert;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private SourceMapper sourceMapper;

    @Autowired
    private FavorService favorService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private HonorWallService honorWallService;

    @Autowired
    private CollectionService collectionService;

    /**
     * 查找每个momentsModel的User
     *
     * @param momentsModelList 待查找的列表
     */
    private void getUser(List<MomentsModel> momentsModelList) {
        momentsModelList.forEach(momentsModel -> momentsModel.setUsers(usersMapper.selectByPrimaryKey(momentsModel.getPoster_id())));
    }

    @Transactional
    @Override
    public List<MomentsModel> doGetClassMomentsByClassId(int class_id, int count, int page) {
        //得到普通动态
        int start = (page - 1) * count;
        List<MomentsModel> momentsList = momentsMapper.selectClassMomentsByClassId(class_id, start, count);
        getUser(momentsList);

        //第一次请求时，需要取得公告
        if (page == 1) {
            List<MomentsModel> tops = momentsMapper.selectTopsByClassId(class_id, new Timestamp(System.currentTimeMillis()));
            getUser(tops);
            tops.addAll(momentsList);
            return tops;
        }

        return momentsList;
    }

    @Transactional
    @Override
    public List<MomentsModel> doGetMyMomentsByUid(int uid, int count, int page) {
        int start = (page - 1) * count;
        List<MomentsModel> momentsModelList = momentsMapper.selectMyMomentsByUid(uid, start, count);
        getUser(momentsModelList);
        return momentsModelList;
    }

    @Transactional
    @Override
    public MomentsModel doGetOneMomentById(int moment_id) {
        MomentsModel momentsModel = momentsMapper.selectByPrimaryKey(moment_id);
        momentsModel.setUsers(usersMapper.selectByPrimaryKey(momentsModel.getPoster_id()));
        return momentsModel;
    }

    @Transactional
    @Override
    public MomentsModel doIssueMomentByUid(int uid, MomentIssueDTO momentIssueDTO) {
        Users users = usersMapper.selectByPrimaryKey(uid);
        Moments newMoments = momentConvert.momentIssueDTO2MomentsEntity(momentIssueDTO, uid, users.getClassId(), 50);
        //存储动态
        momentsMapper.insert(newMoments);
        int moment_id = newMoments.getId();

        //存储动态的资源
        Source[] sourceArr = momentIssueDTO.getSources();
        if (sourceArr != null) {
            for (Source source : sourceArr) {
                source.setInMomentId(moment_id);
                sourceMapper.insertGenerated(source);
            }
        }
        MomentsModel momentsModel = momentsMapper.selectByPrimaryKey(moment_id);
        momentsModel.setUsers(usersMapper.selectByPrimaryKey(momentsModel.getPoster_id()));
        return momentsModel;
    }

    @Transactional
    @Override
    public MomentsModel doDeleteMomentById(int moment_id) {
        MomentsModel momentsModel = momentsMapper.selectByPrimaryKey(moment_id);
        momentsModel.setUsers(usersMapper.selectByPrimaryKey(momentsModel.getPoster_id()));

        //删除动态的资源
        List<Source> sourceList = momentsModel.getSources();
        if (!sourceList.isEmpty()) {
            sourceList.forEach(source -> sourceMapper.deleteByPrimaryKey(source.getId()));
        }

        //删除动态的评论
        commentService.doDeleteByMomentId(moment_id);

        //删除动态的点赞
        favorService.doDeleteByMomentId(moment_id);

        //删除动态的收藏
        collectionService.doDeleteByMomentId(moment_id);

        //删除动态的荣誉墙
        honorWallService.doDeleteByMomentId(moment_id);

        //删除动态
        momentsMapper.deleteByPrimaryKey(moment_id);

        return momentsModel;
    }
}
