package com.ssm.demo.test;

import com.ssm.demo.core.dto.ResultDto;
import com.ssm.demo.web.model.User;
import com.ssm.demo.web.service.IndexService;
import com.ssm.demo.web.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * user:ouym
 * date: 2015/7/31
 * time: 11:55
 */

public class IndexTest extends BaseTest{

    @Autowired
    private IndexService indexService;


    @Test
    public void myTest(){
        String exp = "ge(add(var(x),mul(cons(2),var(y))),var(z))";
        String denv = "[x->34, y->7, z->50]";
        ResultDto resultDto = indexService.leProcess(exp,denv);


    }
}
