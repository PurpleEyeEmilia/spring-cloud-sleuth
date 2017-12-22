package com.yryz.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2017 2017/12/18 14:49
 * @Author: pn
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String getHi() {
        return "hi, I'm from port: " + port;
    }

    @PostMapping("hello")
    public String getHello() {
        return "hello, I'm from port: " + port;
    }

    @RequestMapping("ha")
    public String getHa(@RequestParam String name) {
        return "hello: " + name + " I'm from port: " + port;
    }

    @RequestMapping("zz")
    public String zz(String name) {
        return "hello: " + name + " I'm from port: " + port;
    }

}
