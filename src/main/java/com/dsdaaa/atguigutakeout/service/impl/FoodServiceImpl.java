package com.dsdaaa.atguigutakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dsdaaa.atguigutakeout.domain.Food;
import com.dsdaaa.atguigutakeout.mapper.FoodMapper;
import com.dsdaaa.atguigutakeout.service.FoodService;
import org.springframework.stereotype.Service;

/**
* @author 13180
* @description 针对表【food】的数据库操作Service实现
* @createDate 2023-09-18 14:42:59
*/
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
    implements FoodService {

}




