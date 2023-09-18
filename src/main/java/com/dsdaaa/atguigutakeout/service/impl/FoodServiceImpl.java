package com.dsdaaa.atguigutakeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dsdaaa.atguigutakeout.domain.Food;
import com.dsdaaa.atguigutakeout.domain.Foodtype;
import com.dsdaaa.atguigutakeout.domain.vo.FoodVO;
import com.dsdaaa.atguigutakeout.mapper.FoodMapper;
import com.dsdaaa.atguigutakeout.mapper.FoodtypeMapper;
import com.dsdaaa.atguigutakeout.service.FoodService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author dunston
 * @description 针对表【food】的数据库操作Service实现
 * @createDate 2023-09-18 14:42:59
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
        implements FoodService {
    @Resource
    private FoodMapper foodMapper;
    @Resource
    private FoodtypeMapper foodtypeMapper;

    /**
     * 返回含有map的食品信息
     *
     * @return List
     */
    public List list() {
        //查询出全部类型
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("typeid");
        //准备结果集和迭代器
        List list = foodtypeMapper.selectList(queryWrapper);
        List resultList = new LinkedList();
        Iterator iteratorFoodType = list.iterator();
        while (iteratorFoodType.hasNext()) {
            //map集合
            Map<String, Object> map = new HashMap<>();
            List<FoodVO> foodVOList = new LinkedList<>();
            Foodtype foodtype = (Foodtype) iteratorFoodType.next();
            //食物结果集合
            QueryWrapper queryWrapperSelectType = new QueryWrapper();
            queryWrapperSelectType.eq("foodtypeid", foodtype.getTypeid());
            List foodList = foodMapper.selectList(queryWrapperSelectType);
            Iterator iteratorFood = foodList.iterator();
            //遍历食物集合
            while (iteratorFood.hasNext()) {
                Food food = (Food) iteratorFood.next();
                //商品转化为商品视图
                FoodVO foodVO = toFoodVO(food);
                foodVOList.add(foodVO);
            }
            map.put("name", foodtype.getTypename());
            map.put("type", foodtype.getTypeid());
            map.put("foods", foodVOList);
            resultList.add(map);
        }
        return resultList;
    }

    /**
     * Food转化成FoodVO
     *
     * @param food
     * @return
     */
    @Override
    public FoodVO toFoodVO(Food food) {
        String foodid = food.getFoodid();
        String foodname = food.getFoodname();
        Double foodprice = food.getFoodprice();
        String fooddesc = food.getFooddesc();
        String foodicon = food.getFoodicon();
        FoodVO foodVO = new FoodVO(foodid, foodname, foodprice, fooddesc, foodicon);
        return foodVO;
    }

}




