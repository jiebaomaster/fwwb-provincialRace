package fwwb.classMoments.controllers;

import com.qiniu.util.Auth;
import fwwb.classMoments.DTO.ReturnDTO;
import fwwb.classMoments.services.externalWareService.CloudStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hongcj on 2017/5/3
 */
@Controller
public class SourceController {
    @Autowired
    @Qualifier("CloudStorageService")
    private CloudStorageService cloudStorageService;

    @RequestMapping(value = "/getUploadToken", method = RequestMethod.GET)
    @ResponseBody
    public ReturnDTO getUploadToken() {
        String uploadToken;
        Map<String, String> map = new HashMap<>();

        try {
            uploadToken = cloudStorageService.doGetUploadToken();
            map.put("uploadToken", uploadToken);
            return new ReturnDTO("get_upload_token", "success", map);
        } catch (Exception e) {
            return new ReturnDTO("get_upload_token", "error", e.getMessage());
        }
    }
}
