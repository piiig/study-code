package com.autumnli.login.shirojwt.service;

import com.autumnli.login.shirojwt.bean.User;
import com.autumnli.login.shirojwt.component.JwtUtil;
import com.autumnli.login.shirojwt.dao.UserMapper;
import com.autumnli.login.shirojwt.util.HashMd5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User findUserByUsername(String username) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username",username);
        try {
            User user = userMapper.selectOne(query);
            return user;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String login(User user) {
        User u = findUserByUsername(user.getUsername());
        if (u == null) return null;
        if (u.getPassword().equals(HashMd5.encodePassword(user.getPassword()))) {
            return jwtUtil.sign(u.getUsername(),u.getPassword());
        }
        return null;
    }


}
