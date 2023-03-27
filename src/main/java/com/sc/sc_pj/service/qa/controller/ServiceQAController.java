package com.sc.sc_pj.service.qa.controller;

import com.sc.sc_pj.service.common.domain.CommonDomain;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceQAController {

    @Autowired
    private CommonService commonService;

    @RequestMapping("/qa/qaList")
    public ModelAndView qaList() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("service/qa/qaList");
        return mv;
    }

    @RequestMapping("/qa/qaWrite")
    public ModelAndView qaWrite() {
        ModelAndView mv = new ModelAndView();

        List<CommonDTO> cmmCodeList = commonService.getCodes("qa01");

        mv.addObject("cmmCodeList", cmmCodeList);
        mv.setViewName("service/qa/qaWrite");
        return mv;
    }

}
