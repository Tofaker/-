package org.example.demo.controller;

import org.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2021-01-01;   Time: 9:25
 */
@RestController
@RequestMapping("/arg")
public class TestArugumentController {
    private static final Logger log = LoggerFactory.getLogger(TestArugumentController.class);
    @GetMapping("/holiday/{day}")
    public Object holiday(@PathVariable String day){
        log.debug("获取到请求路径参数："+day);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;

    }
    @PostMapping("/login")
    public Object login(@RequestParam String username, @RequestParam String password){
        log.debug("获取到请求路径参数：username = {}",username+", password = "+password);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }
    @PostMapping("/login2")
    public Object login2(@RequestParam(required = false) int i){
        log.debug("获取到请求路径参数：i = "+i);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/register")
    //前端向后端提交文件，
    public Object register(@RequestParam String username,//提交到username
                           @RequestParam String password,//提交的password
                           @RequestParam MultipartFile file//提交的文件  方法内可以使用file .  点出文件的具体操作
    ) throws IOException {
        log.debug("获取到请求路径参数：username = {}",username+", password = "+password);
        log.debug("头像信息，名称={},内容={}",file.getOriginalFilename(),new String(file.getBytes()));
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/loginpojo")
    public Object loginpojo(User user){//springmvc 自动实例化user对象，
        // 再根据请求key获取值(value user实例对象)，注入到user对象的属性中
        log.debug("获取到请求路径参数：username = {}",user.getUsername()+", password = "+user.getPassword());
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }
    /*@PostMapping("/loginpojo")
    public Object loginpojo(@RequestParam String username, @RequestParam String password){//springmvc 自动实例化user对象，
        // 再根据请求key获取值(value user实例对象)，注入到user对象的属性中
        log.debug("获取到请求路径参数：username = {}",username+", password = "+password);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }*/

    @PostMapping("/loginpojo1")
    public Object loginpojo1(String username, String password){//springmvc 自动实例化user对象，
        // 再根据请求key获取值(value user实例对象)，注入到user对象的属性中
        log.debug("获取到请求路径参数：username = {}",username+", password = "+password);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/registerpojo")
    //前端向后端提交文件，
    public Object register(User user, MultipartFile file//提交的文件  方法内可以使用file .  点出文件的具体操作
    ) throws IOException {
        log.debug("获取到请求路径参数：username = {}",user.getUsername()+", password = "+user.getPassword());
        log.debug("头像信息，名称={},内容={}",file.getOriginalFilename(),new String(file.getBytes()));
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }
}















