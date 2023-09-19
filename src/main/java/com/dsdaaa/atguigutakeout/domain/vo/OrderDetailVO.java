package com.dsdaaa.atguigutakeout.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO {
    private String detailId;
    private String orderId;
    private String productId;
    private String prodectName;
    private double productPrice;
    private double productQuantity;
    private String productIcon;
    private String productImage;
}
