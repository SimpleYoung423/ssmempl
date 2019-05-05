package com.yxp423.ssmempl.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;


/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-16 19:35
 * @Version: 1.0
 */
@org.springframework.context.annotation.Configuration
@MapperScan(basePackages = "com.yxpempl.mapper")
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer customizer(){

        return  new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration) {
               //开启驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);


            }
        };

    }


}
