package com.it.springcloud.swagger.service;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Teachers;

public interface TeacherService {
    //根据id查询教师信息
    public Teachers findTeacherById(Integer id);
}
