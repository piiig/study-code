package com.autumnli.login.shirojwt.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

/**
 * 加密算法
 * 配合登陆加密
 */
public class HashMd5 {
    public static String encodePassword(String password){

        //暂时盐为salt 实际使用时根据情况而定
        SimpleHash simpleHash = new SimpleHash("MD5",password,"house",1024);
        return simpleHash.toHex();
    }
}
