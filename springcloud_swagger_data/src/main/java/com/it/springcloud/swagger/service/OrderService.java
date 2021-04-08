package com.it.springcloud.swagger.service;

import com.it.springcloud.model.pojo.mybatis.mapper.dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface OrderService {
    /**
     * 创建订单(注意：订单在创建的同时，商品库存也要进行相应的变化)
     *
     * @param goodsId 商品id
     * @param count   购买商品数量
     * @return 返回值表示是否创建成功
     */
    public int createOrder(Long goodsId, Long count);
}
