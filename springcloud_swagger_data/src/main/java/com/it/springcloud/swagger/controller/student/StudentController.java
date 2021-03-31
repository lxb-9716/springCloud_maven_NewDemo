package com.it.springcloud.swagger.controller.student;


import com.alibaba.fastjson.JSON;
import com.it.springcloud.api.student.StudentApi;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.basic.RespBody;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.model.pojo.jpa.mongodb.LogBean;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.swagger.repository.mongoLog.LogRepository;
import com.it.springcloud.swagger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class StudentController implements StudentApi {
    @Autowired
    private StudentService studentService;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private HttpServletRequest request;

    @Override
    public ResponseBusiness<Students> findStudentById(@PathVariable("id") Integer id) {
        ResponseBusiness<Students> res = new ResponseBusiness<>();
        LogBean logBean = new LogBean();
        logBean.setCreateDate(new Date());
        logBean.setClassName(this.getClass().getName());
        logBean.setRequestBody(id + "");
        logBean.setMethodName(Thread.currentThread().getStackTrace()[1].getMethodName());
        StringBuffer url = request.getRequestURL();
        String requestType = request.getMethod();
        logBean.setRequestType(requestType);
        if (!StringUtils.isEmpty(url)) {
            logBean.setUrl(url.toString());
        } else {
            logBean.setUrl("请求路径url空");
        }
        Students student = studentService.findStudentById(id);
        try {
            if (null != student) {
                List<Students> students = new ArrayList<>();
                students.add(student);
                RespBody<Students> respBody = new RespBody<>();
                respBody.setData(students);
                res.setResponseBody(respBody);
                res.setCode(CommonCode.SUCCESS.code());
                res.setMessage(CommonCode.SUCCESS.message());
            } else {
                res.setCode(CommonCode.NOT_FOUND.code());
                res.setMessage(CommonCode.NOT_FOUND.message());
            }
        } catch (Exception e) {
            res.setCode(CommonCode.FAIL.code());
            res.setMessage(CommonCode.FAIL.message());
            e.getMessage();
        }
        logBean.setResponseBody(JSON.toJSONString(res));
        //保存日志信息
        logRepository.save(logBean);
        return res;
    }
}
