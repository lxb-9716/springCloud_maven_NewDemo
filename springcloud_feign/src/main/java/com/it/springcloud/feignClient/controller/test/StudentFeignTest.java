package com.it.springcloud.feignClient.controller.test;

import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.feignClient.feign.student.StudentClient;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.extend.StudentsExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StudentFeignTest")
public class StudentFeignTest {
    @Autowired
    private StudentClient studentClient;

    @GetMapping(value = "/findStudentById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Students> findStudentById(@PathVariable("id") Integer id) {
        ResponseBusiness<Students> student = studentClient.findStudentById(id);
        return student;
    }

    @GetMapping(value = "/findStudentWithCourse", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<StudentsExtend> findStudentWithCourse() {
        ResponseBusiness<StudentsExtend> studentWithCourse = studentClient.findStudentWithCourse();
        return studentWithCourse;
    }
}
