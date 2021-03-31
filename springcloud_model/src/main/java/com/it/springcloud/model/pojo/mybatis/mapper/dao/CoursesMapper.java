package com.it.springcloud.model.pojo.mybatis.mapper.dao;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Courses;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.CoursesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CoursesMapper {
    int countByExample(CoursesExample example);

    int deleteByExample(CoursesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Courses record);

    int insertSelective(Courses record);

    List<Courses> selectByExample(CoursesExample example);

    Courses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByExample(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByPrimaryKeySelective(Courses record);

    int updateByPrimaryKey(Courses record);
}