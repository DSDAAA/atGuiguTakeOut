package com.dsdaaa.atguigutakeout.controller;

import com.dsdaaa.atguigutakeout.common.Code;
import com.dsdaaa.atguigutakeout.common.Result;
import com.dsdaaa.atguigutakeout.domain.Orders;
import com.dsdaaa.atguigutakeout.domain.vo.CancelVO;
import com.dsdaaa.atguigutakeout.domain.vo.CreateOrderVO;
import com.dsdaaa.atguigutakeout.domain.vo.DetailVO;
import com.dsdaaa.atguigutakeout.domain.vo.PageVO;
import com.dsdaaa.atguigutakeout.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @Resource
    private OrdersService ordersService;

    /**
     * 创建订单
     *
     * @param createOrderVO
     * @return Result
     */
    @PostMapping("create")
    @Operation(summary = "创建订单")
    public Result create(@RequestBody CreateOrderVO createOrderVO) {
        Map<String, String> stringStringMap = ordersService.create(createOrderVO);
        if (stringStringMap != null) {
            return new Result(Code.SUCCESS_CODE.getCode(), "成功", stringStringMap);
        }
        return new Result(Code.ERROE_CODE, null);
    }

    /**
     * 分页获取订单列表
     *
     * @param pageVO
     * @return Result<T>
     */
    @PostMapping("/list")
    @Operation(summary = "订单列表")
    public Result list(@RequestBody PageVO pageVO) {
        List<Orders> list = ordersService.list(pageVO);
        if (list != null) {
            return new Result(Code.SUCCESS_CODE.getCode(), "成功", list);
        }
        return new Result(Code.ERROE_CODE, null);
    }

    /**
     * 查询订单详情
     *
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail/{openid}/{orderId}")
    @Operation(summary = "查询订单详情")
    public Result detail(@PathVariable String openid, @PathVariable String orderId) {
        DetailVO detail = ordersService.detail(openid, orderId);
        if (detail != null) {
            return new Result(Code.SUCCESS_CODE.getCode(), "成功", detail);
        }
        return new Result(Code.ERROE_CODE, null);
    }

    /**
     * 删除帖子
     *
     * @param cancelVO
     * @return
     */
    @PostMapping("/cancel")
    @Operation(summary = "取消订单")
    public Result cancel(@RequestBody CancelVO cancelVO) {
        Boolean cancel = ordersService.cancel(cancelVO);
        if (cancel) {
            return new Result(Code.SUCCESS_CODE.getCode(), "成功", null);
        }
        return new Result(Code.ERROE_CODE, null);
    }
}
