package com.autumnli.login.shirojwt.component;

import com.autumnli.login.shirojwt.bean.User;
import com.autumnli.login.shirojwt.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class JwtRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 重写supports 说明使用的token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 获取角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo =
                new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 登陆验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {

        //LOGGER.info("Realm进入..");
        String token = (String) auth.getCredentials();
        String username = jwtUtil.getUsername(token);
        //LOGGER.info("username:{}",username);
        //检查token
        if(username == null){
            throw new AuthenticationException("token错误");
        }
        //检查user
        User user = userService.findUserByUsername(username);
        if(user == null){
            throw new AuthenticationException("用户不存在");
        }
        //登陆检查
        if(!jwtUtil.verity(token,username,user.getPassword())){
            throw new AuthenticationException("账号或密码错误");
        }
        //LOGGER.info("成功");
        //实际上并不会通过加密 因为使用的是token 但不返回会错误
        return new SimpleAuthenticationInfo(token,token,"JwtRelam");

    }
}
