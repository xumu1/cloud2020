package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * date: 2020-11-28
 *
 * @author xumu
 */
@RestController
public class monitor {

    @GetMapping("monitor")
    public String monitor(){
        return "ok";
    }
}
