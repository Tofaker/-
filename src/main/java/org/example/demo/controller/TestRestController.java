package org.example.demo.controller;

import org.example.demo.model.JSONResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2020-12-30;   Time: 0:31
 */
@RestController
@RequestMapping("/rest")
public class TestRestController {
    @GetMapping("/1")
    public Object test1(){
        JSONResponse resp = new JSONResponse();
        resp.setCode("LOG001");
        resp.setMessage("用户不存在");
        resp.setData(new Date());
        return resp;
    }
}
