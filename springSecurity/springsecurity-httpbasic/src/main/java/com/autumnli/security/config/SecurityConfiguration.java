package com.autumnli.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true,jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /***
     * 指定用户对来源 内存还是数据库
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码默认是加密后的，加{noop}代表密码不加密的
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
    }

    /***
     * 配置SpringSecurity相关内容
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test1").permitAll() // perimitAll代表不被拦截的
                .antMatchers("/test2").hasAnyRole("USER","ADMIN") // 需要有USER，ADMIN角色
                .anyRequest()   // 其他链接需要登陆
                .authenticated();
    }

}
