package com.it.springcloud.api.course;

import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Courses;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Teachers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "课程信息管理接口", description = "课程信息的增加、删除、修改、查询")
@RequestMapping("/course")
public interface CourseApi {
    /*根据商品id查询课程信息*/
    @ApiOperation("根据id查询课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true,
                    paramType = "path", dataType = "int")
    })
    @GetMapping(value = "/findCourseById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Courses> findCourseById(@PathVariable("id") Integer id);
}
