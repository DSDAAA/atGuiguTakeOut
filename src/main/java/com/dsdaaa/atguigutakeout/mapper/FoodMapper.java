package com.dsdaaa.atguigutakeout.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dsdaaa.atguigutakeout.domain.Food;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 13180
* @description 针对表【food】的数据库操作Mapper
* @createDate 2023-09-18 14:42:59
* @Entity generator.domain.Food
*/
@Mapper
public interface FoodMapper extends BaseMapper<Food> {

}




