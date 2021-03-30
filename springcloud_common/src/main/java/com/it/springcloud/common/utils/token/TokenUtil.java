package com.it.springcloud.common.utils.token;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public class TokenUtil {
    private TokenUtil() {
    }

    private static TokenUtil instance = new TokenUtil();

    public static TokenUtil getInstance() {
        return instance;
    }

    /**
     * MD5加密生成token
     *
     * @return
     */
    public String makeToken() {
        String token = (System.currentTimeMillis()) + UUID.randomUUID().toString();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
