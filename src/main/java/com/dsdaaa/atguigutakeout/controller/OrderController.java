package com.dsdaaa.atguigutakeout.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单业务逻辑层
 *
 * @author dsdaaa
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
@Tag(name = "order参数")
public class OrderController {
}
