package com.it.springcloud.swagger.service.imp;

import com.it.springcloud.model.pojo.mybatis.mapper.dao.StudentsMapper;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.StudentsExample;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.extend.StudentsExtend;
import com.it.springcloud.model.vo.student.StudentVo;
import com.it.springcloud.swagger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public Students findStudentById(Integer id) {
        //  Students students = studentsMapper.selectByPrimaryKey(id);
        Students students = studentsMapper.findStudentsById(id);
        return students;
    }

    @Override
    public List<Students> findStudentsByVo(StudentVo studentVo) {
        List<Students> students = studentsMapper.findStudentsByIds(studentVo);
        return students;
    }

    @Override
    public List<StudentsExtend> findStudentWithCourse() {
        List<StudentsExtend> studentsExtendList = studentsMapper.findStudentWithCourse();
        return studentsExtendList;
    }
}
