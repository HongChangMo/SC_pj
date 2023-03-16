package com.sc.sc_pj.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMainController {

    @RequestMapping("/admin")
    public ModelAndView adminMain() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/main/main");
        return mv;
    }
}
