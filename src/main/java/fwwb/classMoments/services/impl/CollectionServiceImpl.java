package fwwb.classMoments.services.impl;

import fwwb.classMoments.DAO.CollectionsMapper;
import fwwb.classMoments.DTO.CollectionDTO;
import fwwb.classMoments.DTO.MomentDTO;
import fwwb.classMoments.convert.CollectionConvert;
import fwwb.classMoments.convert.MomentConvert;
import fwwb.classMoments.model.Collections;
import fwwb.classMoments.services.CollectionService;
import fwwb.classMoments.services.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hongcj on 2017/5/7.
 */

@Service("CollectionService")
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionsMapper collectionsMapper;

    @Autowired
    private CollectionConvert collectionConvert;

    @Autowired
    private MomentConvert momentConvert;

    @Autowired
    private MomentService momentService;

    @Override
    public CollectionDTO doCreateOneCollectionItem(int moment_id, int uid) {
        Collections collections = new Collections(uid, moment_id);
        collectionsMapper.insert(collections);

        return collectionConvert.collection2CollectionDTO(collections);
    }

    @Override
    public List<MomentDTO> getMomentDTOListByUid(int uid, int count, int page) {
        int start = (page - 1) * count;
        return collectionsMapper
                .selectMomentIdByUid(uid, start, count)
                .stream()
                .map(moment_id -> momentConvert.momentsModel2MomentDTO(momentService.doGetOneMomentById(moment_id)))
                .collect(Collectors.toList());
    }

    @Override
    public void doDeleteByMomentId(int moment_id) {
        collectionsMapper.deleteByMomentId(moment_id);
    }
}
