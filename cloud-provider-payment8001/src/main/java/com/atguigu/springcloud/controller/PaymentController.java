package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description:
 * date: 2020-11-28
 *
 * @author xumu
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.insert(payment);
        log.info("插入结果："+res);
        if(res > 0){
            return new CommonResult(200,"insert success",res);
        }else {
            return new CommonResult(444,"insert fail");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.selectByPrimaryKey(id);
        if (payment!=null){
            return new CommonResult(200,"success",payment);
        }else{
            return new CommonResult(444,"query fail");
        }
    }

}
