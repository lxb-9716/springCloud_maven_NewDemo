package com.it.springcloud.api.student;

import com.it.springcloud.common.request.RequestBussiness;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.ResponseResult;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.extend.StudentsExtend;
import com.it.springcloud.model.vo.student.StudentVo;
import com.netflix.discovery.CommonConstants;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "学生信息管理接口", description = "学生信息的增加、删除、修改、查询")
@RequestMapping("/student")
public interface StudentApi {

    /*根据商品id查询学生信息*/
    @ApiOperation("根据id查询学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true,
                    paramType = "path", dataType = "int")
    })
    @GetMapping(value = "/findStudentById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Students> findStudentById(@PathVariable("id") Integer id);

    /*根据多个id值查询学生信息*/
    @ApiOperation("根据多个id值查询学生信息")
    @PostMapping(value = "/finStudentsByIds", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Students> finStudentsByIds(@RequestBody RequestBussiness<List<Integer>> requestBussiness);

    /**
     * 查询学生的个人信息包括都选了哪些课程
     *
     * @return
     */
    @ApiOperation("查询学生的个人信息包括选了哪些课程，课程的名称，课程对应编号，每门课考试的成绩及对应的学分(注：mybatis框架多对多关系mapper映射文件的配置)")
    @GetMapping(value = "/findStudentWithCourse", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<StudentsExtend> findStudentWithCourse();

    /**
     * 添加学生信息
     *
     * @return
     */
    @ApiOperation("添加学生信息")
    @PostMapping(value = "/saveStudents", produces = "application/json;charset=UTF-8")
    public ResponseResult saveStudents(@RequestBody RequestBussiness<Students> requestBussiness);

    /**
     * 根据id删除学生信息
     *
     * @return
     */
    @ApiOperation("根据id删除学生信息")
    @GetMapping(value = "/delStudentsById/{id}", produces = "application/json;charset=UTF-8")
    ResponseResult delStudentsById(@PathVariable("id") Integer id);
}
