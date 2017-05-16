package fwwb.classMoments.services;

import fwwb.classMoments.DTO.CollectionDTO;
import fwwb.classMoments.DTO.MomentDTO;

import java.util.List;

/**
 * Created by hongcj on 2017/5/7.
 */
public interface CollectionService {
    CollectionDTO doCreateOneCollectionItem(int moment_id, int uid);

    List<MomentDTO> getMomentDTOListByUid(int uid, int count, int page);

    void doDeleteByMomentId(int moment_id);
}
