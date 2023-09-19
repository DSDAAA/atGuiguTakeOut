package com.dsdaaa.atguigutakeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dsdaaa.atguigutakeout.domain.Food;
import com.dsdaaa.atguigutakeout.domain.Orderdetail;
import com.dsdaaa.atguigutakeout.domain.Orders;
import com.dsdaaa.atguigutakeout.domain.vo.*;
import com.dsdaaa.atguigutakeout.mapper.FoodMapper;
import com.dsdaaa.atguigutakeout.mapper.OrderdetailMapper;
import com.dsdaaa.atguigutakeout.mapper.OrdersMapper;
import com.dsdaaa.atguigutakeout.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author dunston
 * @description 针对表【orders】的数据库操作Service实现
 * @createDate 2023-09-18 14:43:11
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrderdetailMapper orderdetailMapper;
    @Resource
    private FoodMapper foodMapper;

    @Override
    public Map<String, String> create(CreateOrderVO createOrderVO) {
        Orders order = toOrder(createOrderVO);
        String openid = order.getOpenid();
        ordersMapper.insert(order);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("openid", openid);
        Orders selectOne = ordersMapper.selectOne(queryWrapper);
        if (selectOne != null) {
            String orderId = selectOne.getOrderId();
            Map<String, String> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("orderId", orderId);
            return objectObjectHashMap;
        }
        return null;
    }

    @Override
    public Orders toOrder(CreateOrderVO createOrderVO) {
        String name = createOrderVO.getName();
        String phone = createOrderVO.getPhone();
        String address = createOrderVO.getAddress();
        String openid = createOrderVO.getOpenid();

        QueryWrapper queryWrapper1 = new QueryWrapper();
        Long l1 = ordersMapper.selectCount(queryWrapper1);
        double orderAmount = 0;
        List items = createOrderVO.getItems();
        Orders orders = new Orders();

        orders.setBuyerName(name);
        orders.setBuyerPhone(phone);
        orders.setBuyerAddress(address);
        orders.setOpenid(openid);
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> next = (Map<String, Object>) iterator.next();
            String productId = (String) next.get("productId");
            Integer productQuantity = (Integer) next.get("productQuantity");

            orderAmount += productQuantity.intValue();

            Orderdetail orderdetail = new Orderdetail();
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.isNotNull("detailid");
            Long l = orderdetailMapper.selectCount(queryWrapper);
            orderdetail.setDetailid(l.longValue() + 1 + "");
            orderdetail.setOrderid(l1.longValue() + 1 + "");
            orderdetail.setProductid(productId);
            orderdetail.setProductcount(productQuantity);
            orderdetailMapper.insert(orderdetail);
        }
        orders.setOrderAmount(orderAmount);
        return orders;
    }

    /**
     * 分页获取订单列表
     *
     * @param pageVO
     * @return List<Orders>
     */
    @Override
    public List<Orders> list(PageVO pageVO) {
        String openid = pageVO.getOpenid();
        Integer pageNo = pageVO.getPage();
        Integer size = pageVO.getSize();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("openid", openid);
        Page<Orders> page = new Page(pageNo, size);
        ordersMapper.selectPage(page, queryWrapper);
        List<Orders> records = page.getRecords();
        return records;
    }

    @Override
    public DetailVO detail(String openid, String orderId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("orderId", orderId);
        Orders orders = ordersMapper.selectOne(queryWrapper);
        List list = orderdetailMapper.selectList(queryWrapper);
        List<OrderDetailVO> resultList = new LinkedList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Orderdetail next = (Orderdetail) iterator.next();
            OrderDetailVO orderDetailVO = toOrderDetailVO(next);
            resultList.add(orderDetailVO);
        }
        DetailVO detailVO = toDetailVO(orders, resultList);
        return detailVO;
    }

    @Override
    public OrderDetailVO toOrderDetailVO(Orderdetail orderdetail) {
        String detailid = orderdetail.getDetailid();
        String orderid = orderdetail.getOrderid();
        Integer productcount = orderdetail.getProductcount();
        String productid = orderdetail.getProductid();
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("foodid", productid);
        Food food = foodMapper.selectOne(queryWrapper1);
        Double foodprice = food.getFoodprice();
        String foodname = food.getFoodname();
        String foodicon = food.getFoodicon();
        String foodimage = food.getFoodimage();
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        orderDetailVO.setDetailId(detailid);
        orderDetailVO.setOrderId(orderid);
        orderDetailVO.setProductId(productid);
        orderDetailVO.setProdectName(foodname);
        orderDetailVO.setProductPrice(foodprice);
        orderDetailVO.setProductQuantity(productcount);
        orderDetailVO.setProductIcon(foodicon);
        orderDetailVO.setProductImage(foodimage);
        return orderDetailVO;
    }

    @Override
    public DetailVO toDetailVO(Orders orders, List resultList) {
        String orderId = orders.getOrderId();
        String buyerName = orders.getBuyerName();
        String buyerPhone = orders.getBuyerPhone();
        String buyerAddress = orders.getBuyerAddress();
        String openid = orders.getOpenid();
        Double orderAmount = orders.getOrderAmount();
        Integer orderStatus = orders.getOrderStatus();
        Integer payStatus = orders.getPayStatus();
        Date createTime = orders.getCreateTime();
        Date updateTime = orders.getUpdateTime();
        DetailVO detailVO = new DetailVO();
        detailVO.setOrderId(orderId);
        detailVO.setBuyerName(buyerName);
        detailVO.setBuyerPhone(buyerPhone);
        detailVO.setBuyerAddress(buyerAddress);
        detailVO.setBuyerOpenid(openid);
        detailVO.setOrderAmount(orderAmount);
        detailVO.setOrderStatus(orderStatus);
        detailVO.setPayStatus(payStatus);
        detailVO.setCreateTime(createTime);
        detailVO.setUpdateTime(updateTime);
        detailVO.setOrderDetailList(resultList);
        return detailVO;
    }

    /**
     * 删除订单
     *
     * @param cancelVO
     * @return
     */
    @Override
    public Boolean cancel(CancelVO cancelVO) {
        String openid = cancelVO.getOpenid();
        String orderId = cancelVO.getOrderId();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("openid", openid);
        queryWrapper.eq("orderId", orderId);
        int delete = ordersMapper.delete(queryWrapper);
        if (delete != 0) {
            return true;
        }
        return false;
    }

}




