package fwwb.classMoments.services.impl;

import fwwb.classMoments.DAO.HonorWallMapper;
import fwwb.classMoments.DTO.HonorWallDTO;
import fwwb.classMoments.DTO.MomentDTO;
import fwwb.classMoments.convert.HonorWallConvert;
import fwwb.classMoments.convert.MomentConvert;
import fwwb.classMoments.model.HonorWall;
import fwwb.classMoments.services.HonorWallService;
import fwwb.classMoments.services.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/5/7.
 */

@Service("HonorWallService")
public class HonorWallServiceImpl implements HonorWallService {

    @Autowired
    private HonorWallMapper honorWallMapper;

    @Autowired
    private MomentService momentService;

    @Autowired
    private HonorWallConvert honorWallConvert;

    @Autowired
    private MomentConvert momentConvert;

    @Transactional
    @Override
    public HonorWallDTO doCreateOneHonorWallItem(int moment_id, int uid) {
        HonorWall honorWall = new HonorWall(uid, moment_id);
        honorWallMapper.insert(honorWall);

        return honorWallConvert.honorWall2HonorWallDTO(honorWall);
    }

    @Transactional
    @Override
    public List<MomentDTO> getMomentDTOListByUid(int uid, int count, int page) {
        int start = (page - 1) * count;

        return honorWallMapper
                .selectMomentIdByUid(uid, start, count)
                .stream()
                .map(moment_id -> momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(moment_id)))
                .collect(Collectors.toList());
    }

    @Override
    public void doDeleteByMomentId(int moment_id) {
        honorWallMapper.deleteByMomentId(moment_id);
    }
}
