package com.it.springcloud.model.pojo.mybatis.mapper.dao;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.StudentsExample;

import java.util.List;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.extend.StudentsExtend;
import com.it.springcloud.model.vo.student.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentsMapper {
    int countByExample(StudentsExample example);

    int deleteByExample(StudentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Students record);

    int insertSelective(Students record);

    List<Students> selectByExample(StudentsExample example);

    Students selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Students record, @Param("example") StudentsExample example);

    int updateByExample(@Param("record") Students record, @Param("example") StudentsExample example);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    /**
     * 根据id插叙学生信息
     *
     * @param id
     * @return
     */
    Students findStudentsById(Integer id);

    /**
     * 根据多个id插叙学生信息
     *
     * @param studentVo
     * @return
     */
    List<Students> findStudentsByIds(StudentVo studentVo);

    /**
     * 查询学生的个人信息包括都选了哪些课程,每门课的分数，学分信息
     *
     * @return
     */
    List<StudentsExtend> findStudentWithCourse();
}