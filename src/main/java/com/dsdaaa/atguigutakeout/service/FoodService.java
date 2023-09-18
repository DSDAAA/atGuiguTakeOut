package com.dsdaaa.atguigutakeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dsdaaa.atguigutakeout.domain.Food;
import com.dsdaaa.atguigutakeout.domain.vo.FoodVO;

import java.util.List;

/**
* @author dunston
* @description 针对表【food】的数据库操作Service
* @createDate 2023-09-18 14:42:59
*/
public interface FoodService extends IService<Food> {
    /**
     *获取商品列表
     *
     * @return List 查询foodType，关联food表
     */
    List list();

    /**
     * Food转化成FoodVO
     *
     * @param food
     * @return
     */
    FoodVO toFoodVO(Food food);
}
