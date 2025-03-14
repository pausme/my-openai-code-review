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
        System.out.println(isPrime(2147483647));  // 输出 true
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // 检查 6k ± 1 形式的因数
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
