package fwwb.classMoments.services.externalWareService;

/**
 * Created by hongcj on 2017/4/28.
 */
public interface PushService {
    boolean pushMessage2app(int uid, String type,String userName);

    boolean bind(int uid,String uuid);
}
