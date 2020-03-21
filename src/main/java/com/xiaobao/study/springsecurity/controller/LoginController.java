package com.xiaobao.study.springsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author lbw
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String showHome(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆人:" + name);
        return "../static/home.html";
    }

    @RequestMapping("login")
    public String showLogin(){
        return "../static/login.html";
    }
    @RequestMapping("failure")
    public String showFailure(){
        return "../static/failure.html";
    }
    /**
     * PreAuthorize 这个注解用来判断用户是否有指定权限，没有就不能访问
     * @return
     */
    @RequestMapping("admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin(){
        return "恭喜，你有Role_Admin角色";
    }
    @RequestMapping("user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser(){
        return "恭喜，你有Role_User角色";
    }
}
