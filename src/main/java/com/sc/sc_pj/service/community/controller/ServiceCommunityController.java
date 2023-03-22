package com.sc.sc_pj.service.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceCommunityController {
    @RequestMapping("/community/communityList")
    public ModelAndView knowledgeList() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/community/communityList");

        return mv;
    }
}
