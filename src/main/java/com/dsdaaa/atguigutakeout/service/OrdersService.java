package com.dsdaaa.atguigutakeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dsdaaa.atguigutakeout.domain.Orderdetail;
import com.dsdaaa.atguigutakeout.domain.Orders;
import com.dsdaaa.atguigutakeout.domain.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @author dunston
 * @description 针对表【orders】的数据库操作Service
 * @createDate 2023-09-18 14:43:11
 */
public interface OrdersService extends IService<Orders> {
    /**
     * 创建订单
     *
     * @return
     */
    Map<String, String> create(CreateOrderVO createOrderVO);

    /**
     * 订单视图转化
     *
     * @param createOrderVO
     * @return
     */
    Orders toOrder(CreateOrderVO createOrderVO);

    /**
     * 订单分页查询
     *
     * @param pageVO
     * @return List
     */
    List<Orders> list(PageVO pageVO);

    /**
     * 查询订单详情
     *
     * @param openid
     * @param orderId
     * @return Map<String, Object>
     */
    DetailVO detail(String openid, String orderId);

    /**
     * 转化为详细订单视图
     *
     * @param orderdetail
     * @return
     */
    OrderDetailVO toOrderDetailVO(Orderdetail orderdetail);

    /**
     * 转化为结果详细视图
     *
     * @param orders
     * @param resultList
     * @return
     */
    DetailVO toDetailVO(Orders orders, List resultList);

    /**
     * 删除订单
     *
     * @param cancelVO
     * @return
     */
    Boolean cancel(CancelVO cancelVO);
}
