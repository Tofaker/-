package org.example.demo.controller;

import org.example.demo.model.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2021-01-02;   Time: 16:20
 */
@RestController
@RequestMapping("/login")
public class loginController {

    @PostMapping("/json1")
    public Object json(@RequestBody Login login){
        //
        login.setData("tongguo");
        Map<Boolean,Object> map = new HashMap<>();
        map.put(true,login.getData());
        return map;
    }
}
