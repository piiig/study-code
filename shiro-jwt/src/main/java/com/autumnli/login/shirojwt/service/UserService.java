package com.autumnli.login.shirojwt.service;

import com.autumnli.login.shirojwt.bean.User;

public interface UserService {
    User findUserByUsername(String username);

    String login(User user);
}
