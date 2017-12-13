package fwwb.classMoments.services.externalWareService.impl;

import fwwb.classMoments.DAO.PushMapper;
import fwwb.classMoments.model.Push;
import fwwb.classMoments.services.externalWareService.PushService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by hongcj on 2017/4/28.
 */

@Service("PushService")
public class PushServiceImpl implements PushService {
    private String appId;
    private String apiId;

    @Autowired
    private PushMapper pushMapper;

    public PushServiceImpl() {
        this.appId = "701a482095cb0da1e5533cbd428846ff";
        this.apiId = "609049b91a56ee139b445ff885152030";
    }

    @Override
    public boolean bind(int uid, String uuid) {
        Push push = new Push(uid, uuid);
        int result = pushMapper.insert(push);
        return result != 0;

    }

    private String getUuid(int uid) {
        return pushMapper.selectByUid(uid).getUuid();
    }

    private String getMessage(String type, String userName) {
        String message = userName;
        switch (type) {
            case "comment":
                message += "评论了你的动态";
                break;
            case "like":
                message += "赞了你的动态";
                break;
            case "aite":
                message += "@了您";
                break;
            case "activity":
                message += "邀请您参加活动！";
                break;
            case "notice":
                message += "发表了公告";
                break;
            default:
                message = "error";
        }

        return message;
    }

    @Override
    public boolean pushMessage2app(int uid, String type, String userName) {
        OkHttpClient client = new OkHttpClient();

        String uuid = this.getUuid(uid);
        String message = this.getMessage(type, userName);
        MediaType mediaType = MediaType.parse("application/json");
        String jsonStr = "{\n\t\"where\":\"" + uuid + "\",\n\t\"data\":{\n\t\t\"type\":\"" + type + "\",\n\t\t\"message\":\"" + message + "\"\n\t}\n}";

        RequestBody body = RequestBody.create(mediaType, jsonStr);
        Request request = new Request.Builder()
                .url("https://api.bmob.cn/1/push")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("X-Bmob-Application-Id", appId)
                .addHeader("X-Bmob-REST-API-Key", apiId)
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            System.out.print(e.getMessage());
            return false;
        }
        return true;
    }
}
