package com.it.springcloud.api.teacher;

import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Teachers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "教师信息管理接口", description = "教师信息的增加、删除、修改、查询")
@RequestMapping("/teacher")
public interface TeacherApi {

    /*根据商品id查询学生信息*/
    @ApiOperation("根据id查询教师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true,
                    paramType = "path", dataType = "int")
    })
    @GetMapping(value = "/findTeacherById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Teachers> findTeacherById(@PathVariable("id") Integer id);
}
