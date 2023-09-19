package com.dsdaaa.atguigutakeout.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailVO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private double orderAmount;
    private double orderStatus;
    private double payStatus;
    private Date createTime;
    private Date updateTime;
    private Object orderDetailList;
}
