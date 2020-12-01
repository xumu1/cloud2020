package com.atguigu.springcloud.controller;

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

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/zk")
    public String getPaymentById() {
        return "success,server port:" + serverPort;
    }

}
