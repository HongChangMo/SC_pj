package com.sc.sc_pj.service.qa.controller;

import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/qa")
public class ServiceQnaAddController {

    @Autowired
    private CommonService commonService;

    @RequestMapping("/qaWrite")
    public ModelAndView qaWrite() {
        ModelAndView mv = new ModelAndView();

        List<CommonDTO> cmmCodeList = commonService.getCodes("qa01");

        mv.addObject("cmmCodeList", cmmCodeList);
        mv.setViewName("service/qa/qaWrite");
        return mv;
    }

    @RequestMapping("/qaAdd")
    public ModelAndView qaAdd(@ModelAttribute("QnaDTO") QnaDTO dto) {
        ModelAndView mv = new ModelAndView("jsonView");

        //log.info("dto.getQaTopic() : " + dto.getQaTopic());
        //log.info("dto.getQaContents() : " + dto.getQaContents());
        //log.info("dto.getQaTitle() : " + dto.getQaTitle());

        if( dto.getHashtags() != null ) {
            for( String s : dto.getHashtags() ) {
                //log.info(s);

            }
        }

        return mv;
    }
}
