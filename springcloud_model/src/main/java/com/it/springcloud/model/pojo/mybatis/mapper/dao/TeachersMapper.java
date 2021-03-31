package com.it.springcloud.model.pojo.mybatis.mapper.dao;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Teachers;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.TeachersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeachersMapper {
    int countByExample(TeachersExample example);

    int deleteByExample(TeachersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    List<Teachers> selectByExample(TeachersExample example);

    Teachers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teachers record, @Param("example") TeachersExample example);

    int updateByExample(@Param("record") Teachers record, @Param("example") TeachersExample example);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);
}