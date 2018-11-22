package com.ticket.browser;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 浏览器环境下安全配置主类
 * @author zhangjie
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * 表单登录 -- 身份认证
		 * 授权
		 */
		http.formLogin()
				.and()
				.authorizeRequests()
				.anyRequest()
				.authenticated();
	}
}
