package fwwb.classMoments.convert;

import fwwb.classMoments.DTO.CollectionDTO;
import fwwb.classMoments.model.Collections;
import fwwb.classMoments.services.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by hongcj on 2017/5/7.
 */

@Component
public class CollectionConvert {
    @Autowired
    private MomentConvert momentConvert;

    @Autowired
    private MomentService momentService;

    public CollectionDTO collection2CollectionDTO(Collections collections) {
        return new CollectionDTO(
                collections.getId(),
                collections.getUsersId(),
                momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(collections.getMomentId())),
                collections.getCreateAt()
        );
    }
}
