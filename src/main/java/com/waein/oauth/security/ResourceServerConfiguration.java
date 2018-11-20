package com.waein.oauth.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: ResourceServerConfiguration, v 0.1 资源服务配置类
 * @CreateDate 2018/11/19
 * @CreateTime 10:18
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //授权认证页面路径或方法配置,请求相应的接口即需要授权认证才能访问
        http.
                authorizeRequests()
                .antMatchers("/users/**").authenticated() //users下所有接口都需要授权验证
                .antMatchers(HttpMethod.GET, "/nurserys/**").permitAll() //nurserys下的所有get请求方法都授权允许
                .anyRequest().authenticated();
    }

}
