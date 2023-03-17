package com.sc.sc_pj.admin.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminNoticeAddController {
    @RequestMapping("admin/notice/noticeAdd")
    public ModelAndView noticeAdd() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/notice/noticeAdd");

        return mv;
    }

    @PostMapping("admin/notice/noticeAddReal")
    public int noticeAddReal() {
        return 0;
    }
}
