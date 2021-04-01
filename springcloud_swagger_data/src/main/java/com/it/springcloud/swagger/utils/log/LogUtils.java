package com.it.springcloud.swagger.utils.log;

import com.alibaba.fastjson.JSON;
import com.it.springcloud.model.pojo.jpa.mongodb.LogBean;
import com.it.springcloud.swagger.repository.mongoLog.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class LogUtils {

    private LogUtils() {
    }

    public static LogBean save(String className, String methodName, String requestBody, String responseBody, HttpServletRequest request) {
        LogBean logBean = new LogBean();
        logBean.setClassName(className);
        logBean.setMethodName(methodName);
        logBean.setRequestBody(JSON.toJSONString(requestBody));
        logBean.setResponseBody(JSON.toJSONString(responseBody));
        logBean.setCreateDate(new Date());
        logBean.setUrl(request.getRequestURL().toString());
        logBean.setRequestType(request.getMethod());
        return logBean;
    }
}
