package com.it.springcloud.swagger.controller.operateController;

import com.it.springcloud.api.token.OperateHeader;
import com.it.springcloud.swagger.service.operateService.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperateController implements OperateHeader {
    @Autowired
    private OperateService operateService;

    @Override
    public String makeToken() {
        String token = operateService.getToken();
        return token;
    }
}
