/**
 * 
 */
package com.imooc.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhangjie
 * @ConfigurationProperties(prefix = "imooc.security")
 * -->读取配置文件imooc.security开头的配置项
 *    让该配置生效，需要在配置类中进行配置，详情见SecurityCoreConfig
 */
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {
    /**
     * 浏览器环境配置
     */
    private BrowserProperties browser = new BrowserProperties();
    /**
     * 社交登录配置
     */
    private SocialProperties social = new SocialProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }
}

