package com.it.springcloud.swagger.service;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;

public interface StudentService {
    public Students findStudentById(Integer id);
}
