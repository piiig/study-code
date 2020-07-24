package com.autumnli.security.server.mapper;

import com.autumnli.security.server.domain.TbPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbPermissionMapper extends Mapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);
}
