package com.sc.sc_pj.admin.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminNoticeListController {
    @RequestMapping("admin/notice/noticeList")
    public ModelAndView noticeList() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/notice/noticeList");

        return mv;
    }
}
