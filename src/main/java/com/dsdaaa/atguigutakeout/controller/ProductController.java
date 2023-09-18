package com.dsdaaa.atguigutakeout.controller;

import com.dsdaaa.atguigutakeout.common.Code;
import com.dsdaaa.atguigutakeout.common.Result;
import com.dsdaaa.atguigutakeout.service.FoodService;
import com.dsdaaa.atguigutakeout.service.OrderdetailService;
import com.dsdaaa.atguigutakeout.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品业务逻辑层
 *
 * @author dsdaaa
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
@Tag(name = "product参数")
public class ProductController {
    @Resource
    private FoodService foodService;

    @GetMapping("list")
    @Operation(summary = "商品列表")
    public Result list() {
        List list = foodService.list();
        return new Result(Code.SUCCESS_CODE, list);
    }
}
