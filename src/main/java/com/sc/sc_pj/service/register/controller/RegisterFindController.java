package com.sc.sc_pj.service.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterFindController {
    // 계정찾기 페이지
    @RequestMapping("/findAccount")
    public String findAccount() {
        return "/service/register/account";
    }
}
