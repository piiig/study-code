package com.autumnli.login.shirojwt.shiro;

import com.autumnli.login.shirojwt.util.HashMd5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordTest {
    @Test
    void test1() {
        String password = "admin";
        System.out.println(HashMd5.encodePassword(password));
    }
}
