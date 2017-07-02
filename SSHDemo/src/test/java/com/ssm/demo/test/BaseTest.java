package com.ssm.demo.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Describe：简单的描述一下该文件
 * Created by 欧阳猛 on 2017/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml","classpath:conf/spring-mybatis.xml"})
public class BaseTest {
}
