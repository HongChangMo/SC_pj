package com.sc.sc_pj.service.qa.controller;

import com.sc.sc_pj.service.common.domain.CommonDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.dto.PageDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.login.dto.UserDTO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ServiceQAController {

    @Autowired
    private QnaService qnaService;

    @Autowired
    private CommonService commonService;

    @GetMapping("/qa/qaList")
    public ModelAndView qaList(HttpServletRequest request,
                               @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
                               @RequestParam(value = "searchTopic", required = false) String searchTopic,
                               @PageableDefault(size = 10, sort = "qaNo", direction = Sort.Direction.DESC) Pageable pageable) {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if( session != null ) {
        UserDTO userDTO = (UserDTO) session.getAttribute("UserDTO");
        //log.info(userDTO.toString());

        // session이 존재할때만 model에 담아줌.
        mv.addObject("UserDTO", userDTO);
    }

        Page<QnaDTO> qnaList = null;

        if( searchKeyword != null ) {
            if( searchTopic!= "" || !searchTopic.equals("") ) {
                System.out.println("searchTopic : " + searchTopic);
                // 토픽 검색 시
                qnaList = qnaService.getQnaSearch(searchKeyword, searchTopic, pageable);
            } else {
                // 검색 키워드있을 경우
                qnaList = qnaService.getQnaSearch(searchKeyword, pageable);
            }
        } else {
            // 검색 조건없이 전체 조회
            qnaList = qnaService.getQnaList(pageable);
        }

        // 토픽 리스트 호충
        List<CommonDTO> cmmCodeList = commonService.getCodes("qa01");
        // 해시태그 리스트 호출
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
        mv.addObject("searchTopic", searchTopic);
        mv.addObject("searchKeyword", searchKeyword);
        mv.addObject("cmmCodeList", cmmCodeList);
        mv.setViewName("service/qa/qaList");
        return mv;
    }
}
