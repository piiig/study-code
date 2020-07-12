package com.autumnli.login.shirojwt.shiro;

import com.autumnli.login.shirojwt.util.HashMd5;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(HashMd5.encodePassword("admin"));
    }
}
