package com.it.springcloud.model.pojo.mybatis.mapper.dao;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Goods;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.GoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品信息查询相关接口
 */
@Repository
@Mapper
public interface GoodsMapper {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 查询商品信息(根据id查询单个商品信息)
     */
    public Goods selectForUpdate(Long id);

    /**
     * 修改商品信息(根据id修改其他属性值)
     */
    public int update(Goods Goods);
}