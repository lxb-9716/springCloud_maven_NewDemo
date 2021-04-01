package com.it.springcloud.swagger.service.imp;

import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.model.pojo.mybatis.mapper.dao.CoursesMapper;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Courses;
import com.it.springcloud.swagger.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursesMapper coursesMapper;

    @Override
    public Courses findCourseById(Integer id) {
        Courses courses = coursesMapper.selectByPrimaryKey(id);
        return courses;
    }
}
