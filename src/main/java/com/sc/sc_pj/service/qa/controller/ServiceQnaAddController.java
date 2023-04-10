package com.sc.sc_pj.service.qa.controller;

import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.domain.CommonDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.qa.domain.QnaDomain;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import com.sc.sc_pj.service.qa.service.QnaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/qa")
public class ServiceQnaAddController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private QnaService qnaService;

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

        // 230405 로그인 기능 미개발로 임시 writer id 하드코딩
        dto.setQaWriter("111");

        // qna 정보 저장
        QnaDomain result = qnaService.addQna(dto);

        if( dto.getHashtags() != null ) {
            for( String str : dto.getHashtags() ) {
                //log.info(s);
                // type_cd (1 : q&a, 2 : 지식, 3: 커뮤니티, 4: 공지사항)
                ComHashTagMapDTO comHashTagMapDTO = new ComHashTagMapDTO(result.getQaNo(), Long.parseLong(str), 1);

                ComHashTagMapDomain tagMap_result = commonService.addTagMap(comHashTagMapDTO);
            }
        }

        return mv;
    }
}
