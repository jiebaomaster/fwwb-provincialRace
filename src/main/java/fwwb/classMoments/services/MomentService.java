package fwwb.classMoments.services;

import fwwb.classMoments.DTO.MomentIssueDTO;
import fwwb.classMoments.model.MomentsModel;

import java.util.List;

/**
 * Created by hongcj on 2017/4/28.
 */
public interface MomentService {
    List<MomentsModel> doGetClassMomentsByClassId(int class_id, int count, int page);

    List<MomentsModel> doGetMyMomentsByUid(int uid, int count, int page);

    MomentsModel doGetOneMomentById(int moment_id);

    MomentsModel doIssueMomentByUid(int uid, MomentIssueDTO momentIssueDTO);

    MomentsModel doDeleteMomentById(int moment_id);
}
