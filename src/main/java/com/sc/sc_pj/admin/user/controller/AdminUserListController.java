package com.sc.sc_pj.admin.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminUserListController {

    @RequestMapping("admin/user/userList")
    public ModelAndView userList() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/user/userList");

        return mv;
    }
}
