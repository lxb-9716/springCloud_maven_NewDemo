package com.it.springcloud.configClient.controller;

import com.it.springcloud.configClient.controller.dao.ConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
public class ConfigController {

    @Autowired
    private ConfigDao configDao;

    @GetMapping("/testConfigClient")
    public String testConfigClient(@RequestParam("name") String name) {
        return name + "------>" + configDao.getWord();
    }

}
