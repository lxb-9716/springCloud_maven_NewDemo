package com.it.springcloud.swagger.service.imp;

import com.it.springcloud.common.utils.token.TokenUtil;
import com.it.springcloud.swagger.service.OperateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OperateServiceImp implements OperateService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 将生成的token存放在redis
     */
    @Override
    public String getToken() {
        //获取redis中存储的token值
        String token = stringRedisTemplate.opsForValue().get("token");
        if (StringUtils.isBlank(token)) {
            String makeToken = TokenUtil.getInstance().makeToken();
            //将生成的token值保存到redis中，并设置过期时间
            stringRedisTemplate.opsForValue().set("token", makeToken, 300, TimeUnit.SECONDS);
            return makeToken;
        }
        return token;
    }
}
