package com.sc.sc_pj.service.login.controller;


import com.sc.sc_pj.service.login.dto.UserDTO;
import com.sc.sc_pj.service.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login() {
        return "/service/login/login";
    }

    @RequestMapping("/loginFail")
    public String loginFail() {
        return "/service/login/loginFail";
    }

    @PostMapping("/login/signIn")
    public String signIn(@RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd, HttpServletRequest request, HttpServletResponse response) {

        String redirectUrl = "";

        HttpSession session = request.getSession();

        UserDTO userDTO = loginService.getLoginInfo(userId, userPwd);

        if( userDTO == null ) {
            redirectUrl = "/loginFail";
        } else {
            session.setAttribute("UserDTO", userDTO);
            redirectUrl = "/";
        }

        return "redirect:"+redirectUrl;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {

        // 세션이 없으면 새로 생성하지 않음
        HttpSession session = request.getSession(false);

        if( session!= null ) {
            session.invalidate();
        }

        return "redirect:/";
    }

}
