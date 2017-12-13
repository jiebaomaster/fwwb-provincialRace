package fwwb.classMoments.services.externalWareService.impl;

import com.qiniu.util.Auth;
import fwwb.classMoments.services.externalWareService.CloudStorageService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hongcj on 2017/5/3.
 */
@Service("CloudStorageService")
public class CloudStorageServiceImpl implements CloudStorageService {
    @Override
    public String doGetUploadToken() {
        String accessKey,
                secretKey,
                bucketName,
                uploadToken,
                path;
        Properties pro = new Properties();

        //读取配置文件
        try {
            path = Thread.currentThread().getContextClassLoader().getResource("source.properties").getPath();
            FileInputStream inputStream = new FileInputStream(path);
            pro.load(inputStream);
            accessKey = pro.getProperty("SK");
            secretKey = pro.getProperty("AK");
            bucketName = pro.getProperty("BUCKET");
            inputStream.close();

        } catch (Exception e) {
            return "file read error";
        }

        //生成令牌
        Auth auth = Auth.create(accessKey, secretKey);
        uploadToken = auth.uploadToken(bucketName);

        return uploadToken;
    }
}
