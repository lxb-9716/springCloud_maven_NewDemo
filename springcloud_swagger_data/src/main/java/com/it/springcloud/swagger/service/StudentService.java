package com.it.springcloud.swagger.service;

import com.it.springcloud.common.response.ResponseBusiness;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.extend.StudentsExtend;
import com.it.springcloud.model.vo.student.StudentVo;

import java.util.List;

public interface StudentService {
    /**
     * 根据id查询学生信息
     *
     * @param id
     * @return
     */
    public Students findStudentById(Integer id);

    /**
     * 多个id查询学生信息
     *
     * @param studentVo
     * @return
     */
    public List<Students> findStudentsByVo(StudentVo studentVo);

    /**
     * 查询学生的个人信息包括都选了哪些课程
     *
     * @return
     */
    public List<StudentsExtend> findStudentWithCourse();

    public int saveStudents(Students students);

    public int delStudentsById(Integer id);
}
