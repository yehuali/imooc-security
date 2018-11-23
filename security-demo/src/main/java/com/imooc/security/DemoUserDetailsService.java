/**
 * 
 */
package com.imooc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @author zhangjie
 * 验证用户信息
 */
@Component
public class DemoUserDetailsService implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 *PasswordEncoder #encode 加密 （加盐后同样的密码，加密后不一致）
	 * PasswordEncoder #matches  "123456"数据库取的密文与用户输入的进行匹配
	 * @param username
	 * @return UserDetails 封装spring security登录的所有信息 ---->处理用户校验
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//根据用户名查找用户信息
		logger.info("登录用户名："+username);
		return new User(username,passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}
}
