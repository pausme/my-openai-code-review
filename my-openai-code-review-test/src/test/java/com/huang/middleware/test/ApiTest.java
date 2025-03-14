package com.huang.middleware.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: 测试类
 * @Version: 1.0
 * @Author: huang
 * @Date: 2025/3/13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ApiTest {

    @Test
    public void test() {
        System.out.println("hello world");
    }

}
