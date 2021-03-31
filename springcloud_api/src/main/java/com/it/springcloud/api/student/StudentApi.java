package com.it.springcloud.api.student;
import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "学生信息管理接口", description = "学生信息的增加、删除、修改、查询")
@RequestMapping("/student")
public interface StudentApi {

    /*根据商品id查询商品信息*/
    @ApiOperation("根据id查询学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true,
                    paramType = "path", dataType = "int")
    })
    @GetMapping(value = "/findStudentById/{id}", produces = "application/json;charset=UTF-8")
    public ResponseBusiness<Students> findStudentById(Integer id);
}
