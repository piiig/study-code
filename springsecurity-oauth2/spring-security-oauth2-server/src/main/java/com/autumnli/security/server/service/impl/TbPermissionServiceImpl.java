package com.autumnli.security.server.service.impl;

import com.autumnli.security.server.domain.TbPermission;
import com.autumnli.security.server.mapper.TbPermissionMapper;
import com.autumnli.security.server.service.TbPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        List<TbPermission> tbPermissions = tbPermissionMapper.selectByUserId(userId);
        return tbPermissions;
    }
}
