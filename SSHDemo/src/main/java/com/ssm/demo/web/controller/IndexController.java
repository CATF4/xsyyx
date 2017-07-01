package com.ssm.demo.web.controller;

import com.ssm.demo.core.dto.ResultDto;
import com.ssm.demo.web.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Describe：简单的描述一下该文件
 * Created by 欧阳猛 on 2017/6/30.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    IndexService indexService;

    @RequestMapping("ryfg")
    public String index(){
        return "ryfg";
    }

    @RequestMapping("start")
    public String start(@RequestParam("wd")String exp,
                        @RequestParam("denv")String denv,
                        Model model){

        ResultDto resultDto = indexService.leProcess(exp,denv);
        model.addAttribute("result",resultDto);
        return "result";
    }
}
