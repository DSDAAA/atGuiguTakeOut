package com.dsdaaa.atguigutakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dsdaaa.atguigutakeout.domain.Orders;
import com.dsdaaa.atguigutakeout.mapper.OrdersMapper;
import com.dsdaaa.atguigutakeout.service.OrdersService;
import org.springframework.stereotype.Service;

/**
* @author 13180
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-09-18 14:43:11
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService {

}




