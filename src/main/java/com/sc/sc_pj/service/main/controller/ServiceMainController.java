package com.sc.sc_pj.service.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceMainController {

    @RequestMapping("/")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/main/main");
        return mv;
    }
}
