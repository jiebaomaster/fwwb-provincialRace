package fwwb.classMoments.services;

import fwwb.classMoments.DTO.FavorDTO;
import fwwb.classMoments.DTO.LikeDTO;

import java.util.List;

/**
 * Created by hongcj on 2017/4/28.
 */
public interface FavorService {
    int doGetLikeCountByMomentId(int moment_id);

    LikeDTO doGetLikeInfoByMomentId(int moment_id);

    List<FavorDTO> doGetLikes2MeByUid(int uid,int count, int page);

    void doCreateOneFavor(int moment_id, int uid);

    void doDeleteOneFavor(int moment_id, int uid);

    void doDeleteByMomentId(int moment_id);
}
