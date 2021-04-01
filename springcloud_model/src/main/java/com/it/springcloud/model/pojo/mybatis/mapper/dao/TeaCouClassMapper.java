package com.it.springcloud.model.pojo.mybatis.mapper.dao;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.TeaCouClass;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.TeaCouClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeaCouClassMapper {
    int countByExample(TeaCouClassExample example);

    int deleteByExample(TeaCouClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeaCouClass record);

    int insertSelective(TeaCouClass record);

    List<TeaCouClass> selectByExample(TeaCouClassExample example);

    TeaCouClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeaCouClass record, @Param("example") TeaCouClassExample example);

    int updateByExample(@Param("record") TeaCouClass record, @Param("example") TeaCouClassExample example);

    int updateByPrimaryKeySelective(TeaCouClass record);

    int updateByPrimaryKey(TeaCouClass record);
}