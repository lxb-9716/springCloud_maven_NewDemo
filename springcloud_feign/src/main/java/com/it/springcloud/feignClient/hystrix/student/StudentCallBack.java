package com.it.springcloud.feignClient.hystrix.student;

import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.feignClient.feign.student.StudentClient;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.extend.StudentsExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import java.util.List;

@Component
@RestController
@RequestMapping("/StudentCallBack")
public class StudentCallBack implements StudentClient {

    @Override
    public ResponseBusiness<Students> findStudentById(Integer id) {
        ResponseBusiness<Students> responseBusiness = new ResponseBusiness<>();
        responseBusiness.setCode("-1");
        responseBusiness.setMessage("调用根据id查询学生信息接口失败！！！");
        return responseBusiness;
    }

    @Override
    public ResponseBusiness<Students> finStudentsByIds(RequestBussiness<List<Integer>> requestBussiness) {
        ResponseBusiness<Students> responseBusiness = new ResponseBusiness<>();
        responseBusiness.setCode("-1");
        responseBusiness.setMessage("调用根据多个ids值查询学生信息接口失败！！！");
        return responseBusiness;
    }

    /**
     * 查询学生的个人信息包括都选了哪些课程
     *
     * @return
     */
    @Override
    public ResponseBusiness<StudentsExtend> findStudentWithCourse() {
        ResponseBusiness<StudentsExtend> responseBusiness = new ResponseBusiness<>();
        responseBusiness.setCode("-1");
        responseBusiness.setMessage("调用查询学生的个人信息包括都选了哪些课程接口失败！！！");
        return responseBusiness;
    }

    @Override
    public ResponseResult saveStudents(RequestBussiness<Students> requestBussiness) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode("-1");
        responseResult.setMessage("调用保存学生个人信息接口失败！！！");
        return responseResult;
    }

    @Override
    public ResponseResult delStudentsById(Integer id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode("-1");
        responseResult.setMessage("调用根据id删除学生信息接口失败！！！");
        return responseResult;
    }
}
