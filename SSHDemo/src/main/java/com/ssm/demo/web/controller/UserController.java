package com.ssm.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * user:ouym
 * date: 2015/7/31
 * time: 13:26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/index")
    public String index(@RequestParam("wd")String wd){
        return "result";
    }
}
