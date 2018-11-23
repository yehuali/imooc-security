package com.imooc.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Spring Security OAuth把四种授权模式已实现
 * -->@EnableAuthorizationServer添加注解即可  授权服务器
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig {
}
