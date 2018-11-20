package com.waein.oauth.security;

import com.waein.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: AuthorizationServerConfiguration, v 0.1 授权服务配置类
 * @CreateDate 2018/11/19
 * @CreateTime 10:18
 * @GitHub https://github.com/Waein
 * ===================================
 */
@Configuration
@EnableAuthorizationServer //EnableAuthorizationServer注解用于配置 OAuth 2.0 授权服务器机制
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("client") //客户端Id:填写自己需要的clientId
                .authorizedGrantTypes("password", "refresh_token") //授予类型(可选多种):password and refresh_token
                .scopes("read", "write") //授权范围:read and write
                .secret("wjwsecurity"); //密钥:填写自己想要的密钥

        /***********************************************************************************************
         * authorization_code — 授权码模式(即先登录获取code,再获取token)                                  ❤️
         * password — 密码模式(将用户名,密码传过去,直接获取token);                                        ❤️
         * client_credentials — 客户端模式(无用户,用户向客户端注册,然后客户端以自己的名义向’服务端’获取资源); ❤️
         * implicit — 简化模式(在redirect_uri 的Hash传递token; Auth客户端运行在浏览器中,如JS,Flash);    ❤️
         * refresh_token — 刷新access_token                                                       ❤️
         ****************************************************************************************/
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userService);
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true); // support refresh token
        tokenServices.setTokenStore(tokenStore); // use in-memory token store
        return tokenServices;
    }

}
