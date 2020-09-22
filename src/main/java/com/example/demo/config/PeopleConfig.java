package com.example.demo.config;

import com.example.demo.pojo.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration
 * 指明当前类时一个配置类
 */
@Configuration
public class PeopleConfig {

    /**
     * 将方法的返回值添加到容器中，
     * 容器中组件默认的id就是这个方法名
     * @return
     */
    @Bean
    public People getPeople(){
        return new People();
    }
}
