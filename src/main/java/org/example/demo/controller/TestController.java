package org.example.demo.controller;

import org.example.demo.model.JSONResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        //转发：只有一次请求，url不变，服务端把资源作为响应体直接返回
        return "forward:/home.html";
    }
    @RequestMapping("/2")
    public String test2(){
        //重定向：2次请求，url会变 ，响应3xx+Location，浏览器自动跳转
        return "redirect:/home.html";
    }
    @RequestMapping("/3")
    @ResponseBody
    public String test3(){//字符串内容作为响应体返回
        //重定向：2次请求，url会变 ，响应3xx+Location，浏览器自动跳转
        return "redirect:/home.html";
    }
    @RequestMapping("/4")
    @ResponseBody
    public Object test4(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");
        return map;
    }

    @RequestMapping(value = "/4_1" ,method = RequestMethod.GET)//指定请求方法 ,value为指定的 服务路径
    @ResponseBody
    public Object test4_1(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");
        return map;
    }

    @RequestMapping("/5")
    @ResponseBody
    public Object test5(){
        Map<Object, Object> map = new HashMap<>();
        map.put("success", true);
        //map.put("data", [{"id":1,"title":"神话故事"},{"id":2,"title":"希腊神话"}]);
        map.put(3, "王五");
        return map;
    }
    @RequestMapping("/6")
    @ResponseBody
    public Object test6(){
        Map<Object,Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data",null);
        return map;
    }
    @RequestMapping("/7")
    @ResponseBody
    public Object test7(){
        Map<Object,Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code","LOG001");
        map.put("message","用户不存在");
        map.put("data",null);
        return map;
    }
    @RequestMapping("/8")
    @ResponseBody
    public Object test8(){
        JSONResponse resp = new JSONResponse();
        //resp.setCode("LOG001");
        //resp.setMessage("用户不存在");
        resp.setData(new Date());
        return resp;
    }
    @RequestMapping("/9")
    @ResponseBody
    public ResponseEntity test9(){
        JSONResponse resp = new JSONResponse();
        //resp.setCode("LOG000");
        //resp.setMessage("未授权的请求，不允许访问");
        resp.setData(new Date());
        return ResponseEntity.status(401).body(resp);//手动返回状态码
    }

    /*
    * 1.success = true ，data有数据
    * 2.success = true，data = null
    * 3.success = false， 返回code错误码和message错误信息
    */



}
