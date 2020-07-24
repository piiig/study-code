package com.autumnli.security.server.service;

import com.autumnli.security.server.domain.TbUser;

public interface TbUserService{

    TbUser getByUsername(String username);
}
