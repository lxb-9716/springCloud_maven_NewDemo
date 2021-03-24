package com.it.springcloud.configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

@Controller
@ResponseBody
public class ConfigController {

    @Value("${spring-cloud-config-client}")
    private String springCloudConfigClient;

    @GetMapping(value = "/testConfigClient")
    public String testConfigClient(@RequestParam("name") String name) {
        //解决中文乱码的问题
        return name + "------>" + springCloudConfigClient;
    }

}
