package com.it.springcloud.swagger.service.imp;

import com.it.springcloud.model.pojo.mybatis.mapper.dao.GoodsMapper;
import com.it.springcloud.model.pojo.mybatis.mapper.dao.OrdersMapper;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Goods;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Orders;
import com.it.springcloud.swagger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 注意：事务在有些情况下不会生效：
     * 1、事务默认配置的情况下，当抛出受检异常的话事务不会生效(Exception)
     * 2、如果在同一个类中，一个事务方法调用另一个事务方法，可能会导致被调用的事务方法的事务失效
     * @param goodsId 商品id
     * @param count   购买商品数量
     * @return
     */
    @Transactional(rollbackFor = Exception.class)//只要抛出异常就会回滚
    @Override
    public int createOrder(Long goodsId, Long count){
        Goods goods = goodsMapper.selectForUpdate(goodsId);
        //计算出剩余的库存数量
        Long s = goods.getNum() - count;
        //更新减少数据库中的商品库存数量
        goods.setNum(s);
        goodsMapper.update(goods);
        //发生运行时异常，事务会生效
        //int a = 1 / 0;
        //生成订单
        Orders orders = new Orders();
        orders.setGoodsId(goodsId);
        orders.setCount(count);
        int i = ordersMapper.insert(orders);
        return i;
    }
}
