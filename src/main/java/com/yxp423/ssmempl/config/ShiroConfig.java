package com.yxp423.ssmempl.config;

import com.yxp423.ssmempl.bean.User;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-19 12:04
 * @Version: 1.0
 */

@Configuration
public class ShiroConfig {

//   创建shiroFilterFactoryBean

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);


        /**
         * 添加shiro内置过滤器
         *  常用过滤器：
         *         anon: 无需认证就能访问
         *         authc: 必须认证才能访问
         *         user: 使用remember功能
         *         perms: 必须得到资源的访问权限才能访问
         *         role: 必须得到角色权限才能访问
         *
         */

        Map<String,String>  filterMap = new LinkedHashMap<>();

        filterMap.put("/loginPage","anon");
        filterMap.put("/login","anon");


//        filterMap.put("/logout", "logout");
        filterMap.put("/*","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        shiroFilterFactoryBean.setLoginUrl("/loginPage");




        return shiroFilterFactoryBean;
    }


//    创建defaultWebSecurityManager

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") UserRealm userRealm){

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        defaultWebSecurityManager.setRealm(userRealm);

        return defaultWebSecurityManager;
    }


    /**
     * 创建一个realm
     * @return MyRealm
     */
    @Bean
    public UserRealm getRealm(){
        return new UserRealm();
    }
}