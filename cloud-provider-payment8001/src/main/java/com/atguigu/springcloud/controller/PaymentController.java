package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.insert(payment);
        log.info("插入结果："+res);
        if(res > 0){
            return new CommonResult(200,"insert success,server port:"+serverPort,res);
        }else {
            return new CommonResult(444,"insert fail,server port:"+serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.selectByPrimaryKey(id);
        if (payment!=null){
            return new CommonResult(200,"success,server port:"+serverPort,payment);
        }else{
            return new CommonResult(444,"query fail,server port:"+serverPort);
        }
    }

}
