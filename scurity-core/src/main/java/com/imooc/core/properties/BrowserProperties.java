/**
 * 
 */
package com.imooc.core.properties;

/**
 * 浏览器环境配置项
 * 
 * @author zhailiang
 *
 */
public class BrowserProperties {
	
	/**
	 * 登录页面，当引发登录行为的url以html结尾时，会跳到这里配置的url上
	 */
	private String signInPage = SecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;

	public String getSignInPage() {
		return signInPage;
	}

	public void setSignInPage(String signInPage) {
		this.signInPage = signInPage;
	}
}
