package org.example.demo.controller;

import org.example.demo.exception.AppException;
import org.example.demo.model.JSONResponse;
import org.example.demo.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: madala
 * Date: 2021-01-14;   Time: 16:23
 */
//用户登录注册注销等功能
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public Object login(User user, HttpServletRequest req){
        JSONResponse json = new JSONResponse();
        if ("abc".equals(user.getUsername())){//返回账号密码匹配成功
            //通过请求头cookie：JSESSIONID=xxx,在服务端map中通过xxx查找session
            HttpSession session = req.getSession();//找到session就返回，没有就创建一个
            session.setAttribute("user",user);
            json.setSuccess(true);

        }else {//返回账号密码匹配失败
            json.setCode("USRLOG");
            json.setMessage("用户或密码错误");
        }
        return json;
    }

    @PostMapping("/login2")
    public Object login2(User user){
        if ("abc".equals(user.getUsername())){
            return user;
        }else {
            throw new AppException("USELOG001","用户名或密码错误");
        }
    }
}
