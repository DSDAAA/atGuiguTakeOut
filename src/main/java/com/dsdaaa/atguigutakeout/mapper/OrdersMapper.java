package com.dsdaaa.atguigutakeout.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dsdaaa.atguigutakeout.domain.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 13180
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2023-09-18 14:43:11
* @Entity generator.domain.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}




