package com.sc.sc_pj.service.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceNoticeController {
    @RequestMapping("/notice/noticeList")
    public ModelAndView noticeList() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/notice/noticeList");

        return mv;
    }

    @RequestMapping("/notice/noticeWrite")
    public ModelAndView noticeWrite() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/notice/noticeWrite");

        return mv;
    }
}
