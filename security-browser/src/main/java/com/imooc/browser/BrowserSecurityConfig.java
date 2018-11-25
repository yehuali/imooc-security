package com.imooc.browser;


import com.imooc.core.properties.SecurityConstants;
import com.imooc.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 浏览器环境下安全配置主类
 * 常见问题：重定向次数过多，登录页也需要授权形成死循环
 * 表单登录由UsernamePasswordAuthenticationFilter处理，处理指定的登录路径  --->  loginProcessingUrl("/authentication/form")
 * spring security默认提供CSRF跨站请求伪造的防护
 * @author zhangjie
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;
	/**
	 * /auth/qq
	 * SocialAuthenticationFilter 拦截/auth请求
	 * qq 是在QQAutoConfig里配置，类似其他providerId(微信wx)
	 */
	@Autowired
	private SpringSocialConfigurer springSocialConfigurer; //往过滤器链上添加过滤器

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
         * 表单登录 -- 身份认证
		 * 授权
		 */
		http.formLogin()
				.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)  //自定义登录页面
				.loginProcessingUrl("/authentication/form")
				.and()
				.apply(springSocialConfigurer)
				.and()
				.authorizeRequests()
				.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
						securityProperties.getBrowser().getSignInPage()).permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.csrf().disable();
	}
}
