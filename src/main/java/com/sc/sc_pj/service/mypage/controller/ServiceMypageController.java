package com.sc.sc_pj.service.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceMypageController {

    @RequestMapping("/myPage")
    public ModelAndView myPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("service/mypage/mypage");
        return mv;
    }

}
