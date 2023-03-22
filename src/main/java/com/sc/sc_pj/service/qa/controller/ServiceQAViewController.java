package com.sc.sc_pj.service.qa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceQAViewController {
    @RequestMapping("/qa/qaView")
    public ModelAndView qaView() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/qa/qaView");

        return mv;
    }
}
