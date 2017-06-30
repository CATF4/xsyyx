package com.ssm.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Describe：简单的描述一下该文件
 * Created by 欧阳猛 on 2017/6/30.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("ryfg")
    public String index(){
        return "ryfg";
    }
}
