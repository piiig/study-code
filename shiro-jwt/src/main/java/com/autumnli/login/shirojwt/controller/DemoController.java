package com.autumnli.login.shirojwt.controller;

import com.autumnli.login.shirojwt.api.Result;
import com.autumnli.login.shirojwt.bean.User;
import com.autumnli.login.shirojwt.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        String token = userService.login(user);
        if (StringUtils.isEmpty(token)) {
            return Result.fail(401,"账号或密码错误");
        }
        return Result.succ(token);
    }

    @GetMapping("/test0")
    public Result test0(){
        return Result.succ("不需要登陆");
    }

    @RequiresAuthentication
    @GetMapping("/test1")
    public Result test1(){
        return Result.succ("需要登陆");
    }
}
