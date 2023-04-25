package com.sc.sc_pj.service.qa.controller;

import com.sc.sc_pj.service.common.domain.CommonDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.dto.PageDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import com.sc.sc_pj.service.qa.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceQAController {

    @Autowired
    private QnaService qnaService;

    @Autowired
    private CommonService commonService;

    @GetMapping("/qa/qaList")
    public ModelAndView qaList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword, @PageableDefault(size = 10, sort = "qaNo", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView mv = new ModelAndView();

        Page<QnaDTO> qnaList = null;

        if( searchKeyword != null ) {
            // 검색 키워드있을 경우
            qnaList = qnaService.getQnaSearch(searchKeyword, pageable);
        } else {
            // 검색 조건없이 전체 조회
            qnaList = qnaService.getQnaList(pageable);
        }

        List<ComHashTagMapDTO> tagsList = commonService.getAllTags();

        PageDTO pageDTO = new PageDTO();

        pageDTO.setPageNumber(qnaList.getPageable().getPageNumber()); //현재페이지
        pageDTO.setTotalPages(qnaList.getTotalPages());
        pageDTO.setStartBlockPage(((pageDTO.getPageNumber())/ pageDTO.getPageBlock())*pageDTO.getPageBlock()+1);
        int endBlockPage = pageDTO.getStartBlockPage()+pageDTO.getPageBlock()-1;
        endBlockPage= pageDTO.getTotalPages()<endBlockPage? pageDTO.getTotalPages():endBlockPage;
        pageDTO.setEndBlockPage(endBlockPage);

        mv.addObject("PageDTO", pageDTO);
        mv.addObject("QnaList", qnaList);
        mv.addObject("TagsList", tagsList);
        mv.addObject("searchKeyword", searchKeyword);
        mv.setViewName("service/qa/qaList");
        return mv;
    }
}
