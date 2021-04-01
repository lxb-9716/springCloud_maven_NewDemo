package com.it.springcloud.swagger.service;

import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Courses;

public interface CourseService {
    public Courses findCourseById(Integer id);
}
