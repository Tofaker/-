package org.example.demo.controller;

import org.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2021-01-14;   Time: 16:23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public Object login(User user){
        if (){
            session = request.getSession();

        }else {

        }
    }
}
