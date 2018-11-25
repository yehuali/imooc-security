/**
 * 
 */
package com.imooc.core.properties;

/**
 * 社交登录配置项
 * @author zhailiang
 *
 */
public class SocialProperties {
	

	private QQProperties qq = new QQProperties();
	

	public QQProperties getQq() {
		return qq;
	}

	public void setQq(QQProperties qq) {
		this.qq = qq;
	}

}
