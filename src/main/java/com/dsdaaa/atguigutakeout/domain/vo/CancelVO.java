package com.dsdaaa.atguigutakeout.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancelVO {
    private String openid;
    private String orderId;
}
