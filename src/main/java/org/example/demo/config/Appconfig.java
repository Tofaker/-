package org.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2021-01-02;   Time: 15:38
 */
@Configuration//定义springmvc的启动配置类
public class Appconfig implements WebMvcConfigurer {//springmvc自定义配置
    //随便可以实现哪个方法，
    //接口在jdk1.8之后，提供有default的接口，可以不用实现方法
    //即采用父类内默认的接口实现的方法，所以子类可以实现可以不实现

    //配置controller中请求映射方法路径匹配规则
    @Override//配置路径匹配规则
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //configurer.addPathPrefix("api",c->true);
    }
}
