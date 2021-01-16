package org.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
        configurer.addPathPrefix("api",c->true);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //前端处理逻辑和后端处理逻辑是否一样？
        //前端：敏感资源在拦截器中处理为：没登录跳转首页
        //后端：敏感资源在拦截器中处理为：返回json，401状态码
        registry.addInterceptor(new LoginInterceptor(objectMapper))//addInterceptor添加一个拦截器
                //new LoginInterceptor(objectMapper) 创建一个新的拦截器  实现了HandlerInterceptor接口

                // *代表路径下一级，**代表路径的所有子级
                //所有后端非/user/开头，只有指定的两个前端资源执行拦截器的逻辑

                //.addPathPatterns("/**") 这句的意思是前后端所有的都拦截
                .addPathPatterns("/api/**")//后端以/api 开头的 全部拦截  进入代码逻辑：new LoginInterceptor(objectMapper)
                .excludePathPatterns("/api/user/**")//排除一些资源  即 /api/user/路径下的全部放行 即 后端开放的资源 (负负得正)
                //  excludePathPatterns("/api/user/**")不进入代码逻辑new LoginInterceptor(objectMapper)

                //以下两个路径全部走new LoginInterceptor(objectMapper) 代码逻辑
                .addPathPatterns("/views/article.html","/views/main.html")//一行可以写多个
                .addPathPatterns("/views/main.html");

        //可以添加多个拦截器
        /*registry.addInterceptor(new LoginInterceptor(objectMapper))
                .addPathPatterns("/views/article.html")
                .addPathPatterns("/views/main.html");*/
    }

}
