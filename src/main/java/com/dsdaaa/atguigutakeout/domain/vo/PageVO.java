package com.dsdaaa.atguigutakeout.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageVO {
    private String openid;
    private Integer page;
    private Integer size;
}
