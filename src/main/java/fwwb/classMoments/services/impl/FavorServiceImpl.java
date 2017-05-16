package fwwb.classMoments.services.impl;

import fwwb.classMoments.DAO.FavorMapper;
import fwwb.classMoments.DTO.FavorDTO;
import fwwb.classMoments.DTO.LikeDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.convert.FavorConvert;
import fwwb.classMoments.convert.MomentConvert;
import fwwb.classMoments.convert.UserConvert;
import fwwb.classMoments.model.Favor;
import fwwb.classMoments.services.FavorService;
import fwwb.classMoments.services.MomentService;
import fwwb.classMoments.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/4/28.
 */
@Service("FavorService")
public class FavorServiceImpl implements FavorService {
    @Autowired
    private FavorMapper favorMapper;

    @Autowired
    private MomentService momentService;

    @Autowired
    private MomentConvert momentConvert;

    @Autowired
    private FavorConvert favorConvert;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConvert userConvert;

    @Override
    public int doGetLikeCountByMomentId(int moment_id) {
        return favorMapper.countLikeByMomentId(moment_id);
    }

    private UserDTO getUserDTObyUid(Favor favor) {
        return userConvert.userEntity2UserDTO(userService.doGetUserInfoByUid(favor.getUsersId()));
    }

    @Transactional
    @Override
    public LikeDTO doGetLikeInfoByMomentId(int moment_id) {
        List<UserDTO> userDTOList = favorMapper
                .selectByMomentId(moment_id)
                .stream()
                .map(favor -> getUserDTObyUid(favor))
                .collect(Collectors.toList());

        return new LikeDTO(
                doGetLikeCountByMomentId(moment_id),
                userDTOList,
                momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(moment_id))
        );
    }


    @Transactional
    @Override
    public List<FavorDTO> doGetLikes2MeByUid(int uid, int count, int page) {
        int start = (page - 1) * count;
        List<Favor> favorList = favorMapper.selectMomentFavorByUid(uid, start, count);

        return favorList
                .stream()
                .map(favor -> favorConvert.favor2FavorDTO(favor))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void doCreateOneFavor(int moment_id, int uid) {
        int moment_user_id = momentService.doGetOneMomentById(moment_id).getPoster_id();
        Favor favor = new Favor(uid, moment_id, moment_user_id);
        favorMapper.insert(favor);
    }

    @Transactional
    @Override
    public void doDeleteOneFavor(int moment_id, int uid) {
        int moment_user_id = momentService.doGetOneMomentById(moment_id).getPoster_id();
        Favor favor = new Favor(uid, moment_id, moment_user_id);
        int favorId = favorMapper.selectByMomentIdUid(favor).getId();
        favorMapper.deleteByPrimaryKey(favorId);
    }

    @Override
    public void doDeleteByMomentId(int moment_id) {
        favorMapper.deleteByMomentId(moment_id);
    }
}
