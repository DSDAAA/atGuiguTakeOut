package com.dsdaaa.atguigutakeout.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {
    private String id;
    private String name;
    private double price;
    private String description;
    private String icon;
}
