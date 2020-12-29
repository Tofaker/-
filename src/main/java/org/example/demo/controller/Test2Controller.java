package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2020-12-29;   Time: 23:10
 */
@Controller
public class Test2Controller {
    @RequestMapping("/test2")
    public String test(){
        //重定向：2次请求，url会变 ，响应3xx+Location，浏览器自动跳转
        return "forward:/home.html";
    }
}
