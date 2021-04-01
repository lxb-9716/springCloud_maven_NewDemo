package com.it.springcloud.model.pojo.mybatis.mapper.dao;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.StuCouScore;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.StuCouScoreExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StuCouScoreMapper {
    int countByExample(StuCouScoreExample example);

    int deleteByExample(StuCouScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuCouScore record);

    int insertSelective(StuCouScore record);

    List<StuCouScore> selectByExample(StuCouScoreExample example);

    StuCouScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuCouScore record, @Param("example") StuCouScoreExample example);

    int updateByExample(@Param("record") StuCouScore record, @Param("example") StuCouScoreExample example);

    int updateByPrimaryKeySelective(StuCouScore record);

    int updateByPrimaryKey(StuCouScore record);
}