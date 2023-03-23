package com.sc.sc_pj.service.knowledge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceKnowledgeController {
    @RequestMapping("/knowledge/knowledgeList")
    public ModelAndView knowledgeList() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/knowledge/knowledgeList");

        return mv;
    }
    @RequestMapping("/knowledge/knowledgeWrite")
    public ModelAndView knowledgeWrite() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/knowledge/knowledgeWrite");

        return mv;
    }
}
