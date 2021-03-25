package com.it.springcloud.feignClient.utils;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 解决中文乱码问题
 */
public class TransCoding {
    private static String charSetName_ISO = "ISO-8859-1";
    private static String charSetName_UTF = "utf-8";

    public static String transCode(String str) {
        try {
            if (!StringUtils.isEmpty(str)) {
                byte[] bytes = str.getBytes(charSetName_ISO);
                str = new String(bytes, charSetName_UTF);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
