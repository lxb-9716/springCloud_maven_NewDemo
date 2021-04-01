package com.it.springcloud.swagger.controller.student;


import com.alibaba.fastjson.JSON;
import com.it.springcloud.api.student.StudentApi;
import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.basic.RespBody;
import com.it.springcloud.common.response.basic.ResponseBodyPage;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.model.pojo.jpa.mongodb.LogBean;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.extend.StudentsExtend;
import com.it.springcloud.model.vo.student.StudentVo;
import com.it.springcloud.swagger.repository.mongoLog.LogRepository;
import com.it.springcloud.swagger.service.StudentService;
import com.it.springcloud.swagger.utils.log.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
        //保存日志信息
        LogBean logBean = LogUtils.save(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), id, res, request);
        logRepository.save(logBean);
        return res;
    }

    @Override
    public ResponseBusiness<Students> finStudentsByIds(@RequestBody RequestBussiness<List<Integer>> requestBussiness) {
        ResponseBusiness<Students> res = new ResponseBusiness<>();
        StudentVo studentVo = new StudentVo();
        List<Integer> data = requestBussiness.getRequestBody().getData();
        studentVo.setIds(data);
        List<Students> studentsList = studentService.findStudentsByVo(studentVo);
        try {
            if (null != studentsList && studentsList.size() > 0) {
                RespBody<Students> respBody = new RespBody<>();
                respBody.setData(studentsList);
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
        } //保存日志信息
        LogBean logBean = LogUtils.save(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), requestBussiness, res, request);
        logRepository.save(logBean);
        return res;
    }

    @Override
    public ResponseBusiness<StudentsExtend> findStudentWithCourse() {
        ResponseBusiness<StudentsExtend> res = new ResponseBusiness<>();
        List<StudentsExtend> studentsExtendList = studentService.findStudentWithCourse();
        try {
            if (null != studentsExtendList && studentsExtendList.size() > 0) {
                RespBody<StudentsExtend> respBody = new RespBody<>();
                respBody.setData(studentsExtendList);
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
        } //保存日志信息
        LogBean logBean = LogUtils.save(this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "该接口次请求参数为空", res, request);
        logRepository.save(logBean);
        return res;
    }
}
