package com.it.springcloud.swagger.controller.teacher;

import com.it.springcloud.api.teacher.TeacherApi;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.basic.RespBody;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.model.pojo.jpa.mongodb.LogBean;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Teachers;
import com.it.springcloud.swagger.repository.mongoLog.LogRepository;
import com.it.springcloud.swagger.service.TeacherService;
import com.it.springcloud.swagger.utils.log.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TeacherController implements TeacherApi {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private HttpServletRequest request;

    @Override
    public ResponseBusiness<Teachers> findTeacherById(@PathVariable("id") Integer id) {
        ResponseBusiness<Teachers> res = new ResponseBusiness<>();
        Teachers teacher = teacherService.findTeacherById(id);
        try {
            if (null != teacher) {
                List<Teachers> teachers = new ArrayList<>();
                teachers.add(teacher);
                RespBody<Teachers> respBody = new RespBody<>();
                respBody.setData(teachers);
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
        //保存日志信息
        LogBean logBean = LogUtils.save(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), id, res, request);
        logRepository.save(logBean);
        return res;
    }
}
