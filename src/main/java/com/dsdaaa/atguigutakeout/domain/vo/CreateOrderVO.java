package com.dsdaaa.atguigutakeout.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * 创建订单获取参数订单视图
 */
@Data
public class CreateOrderVO {
    private String name;
    private String phone;
    private String address;
    private String openid;
    private List items;
}
