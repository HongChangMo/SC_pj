package com.sc.sc_pj.service.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    // 회원가입 페이지
    @RequestMapping("/register")
    public String register() {
        return "/service/register/register";
    }

}
