package com.dsdaaa.atguigutakeout.controller;

import com.dsdaaa.atguigutakeout.common.Result;
import com.dsdaaa.atguigutakeout.service.OrderdetailService;
import com.dsdaaa.atguigutakeout.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dsdaaa
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private OrdersService ordersService;
    @Resource
    private OrderdetailService orderdetailService;
    @GetMapping()
    public Result
}
