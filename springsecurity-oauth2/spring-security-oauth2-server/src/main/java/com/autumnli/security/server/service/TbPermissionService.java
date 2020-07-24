package com.autumnli.security.server.service;

import com.autumnli.security.server.domain.TbPermission;

import java.util.List;

public interface TbPermissionService {
    List<TbPermission> selectByUserId(Long userId);
}
