package fwwb.classMoments.convert;

import fwwb.classMoments.DTO.HonorWallDTO;
import fwwb.classMoments.model.HonorWall;
import fwwb.classMoments.services.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hongcj on 2017/5/7.
 */

@Component
public class HonorWallConvert {
    @Autowired
    private MomentConvert momentConvert;

    @Autowired
    private MomentService momentService;

    public HonorWallDTO honorWall2HonorWallDTO(HonorWall honorWall) {
        return new HonorWallDTO(
                honorWall.getId(),
                honorWall.getUsersId(),
                momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(honorWall.getMomentId()))
        );
    }
}
