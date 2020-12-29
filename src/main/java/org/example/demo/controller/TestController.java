package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2020-12-29;   Time: 21:10
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/1")
    public String test1(){
        return "forward:/home.html";
    }
    @RequestMapping("/2")
    public String test2(){
        return "redirect:/home.html";
    }
}
