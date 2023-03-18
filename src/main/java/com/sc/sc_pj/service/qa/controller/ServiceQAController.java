package com.sc.sc_pj.service.qa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceQAController {

    @RequestMapping("/qa/qaList")
    public ModelAndView qaList() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/qa/qaList");
        return mv;
    }
}
