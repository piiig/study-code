package com.autumnli.login.shirojwt.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("shiro_jwt_user")
public class User {
    @TableId
    private int id;
    private String username;
    private String password;
}
