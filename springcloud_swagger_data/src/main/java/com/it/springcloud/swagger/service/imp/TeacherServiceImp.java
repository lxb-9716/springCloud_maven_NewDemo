package com.it.springcloud.swagger.service.imp;

import com.it.springcloud.model.pojo.mybatis.mapper.dao.TeachersMapper;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Teachers;
import com.it.springcloud.swagger.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeachersMapper teachersMapper;

    //根据id查询教师信息
    @Override
    public Teachers findTeacherById(Integer id) {
        Teachers teachers = teachersMapper.selectByPrimaryKey(id);
        return teachers;
    }
}
