package fwwb.classMoments.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hongcj on 2017/4/29.
 */
public class TokenCreater {
    public static String createToken(
            int uid
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return MD5Encoder.EncoderByMd5(uid+""+System.currentTimeMillis());
    }
}
