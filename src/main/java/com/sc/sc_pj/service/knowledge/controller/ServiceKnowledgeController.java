package com.sc.sc_pj.service.knowledge.controller;

import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.dto.PageDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.knowledge.dto.KnowledgeDTO;
import com.sc.sc_pj.service.knowledge.service.KnowledgeService;
import com.sc.sc_pj.service.login.dto.UserDTO;
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
public class ServiceKnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private CommonService commonService;

    @GetMapping("/knowledge/knowledgeList")
    public ModelAndView knowledgeList(HttpServletRequest request,
                                      @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
                                      @RequestParam(value = "searchTopic", required = false) String searchTopic,
                                      @PageableDefault(size = 10, sort = "knNo", direction = Sort.Direction.DESC) Pageable pageable) {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if(session != null) {
            UserDTO userDTO = (UserDTO) session.getAttribute("UserDTO");

            // session이 존재할때만 model에 담아줌.
            mv.addObject("UserDTO", userDTO);
        }

        Page<KnowledgeDTO> knowledgeList = null;

        if( searchKeyword != null ) {
            if( searchTopic!= "" || !searchTopic.equals("") ) {
                // 토픽 검색 시
                knowledgeList = knowledgeService.getKnowledgeSearch(searchKeyword, searchTopic, pageable);
            } else {
                // 검색 키워드있을 경우
                knowledgeList = knowledgeService.getKnowledgeSearch(searchKeyword, pageable);
            }
        } else {
            // 검색 조건없이 전체 조회
            knowledgeList = knowledgeService.getKnowledgeList(pageable);
        }

        // 토픽 리스트 호충
        List<CommonDTO> cmmCodeList = commonService.getCodes("kn01");
        // 해시태그 리스트 호출
        List<ComHashTagMapDTO> tagsList = commonService.getAllTags();

        PageDTO pageDTO = new PageDTO();

        pageDTO.setPageNumber(knowledgeList.getPageable().getPageNumber()); //현재페이지
        pageDTO.setTotalPages(knowledgeList.getTotalPages());
        pageDTO.setStartBlockPage(((pageDTO.getPageNumber())/ pageDTO.getPageBlock())*pageDTO.getPageBlock()+1);
        int endBlockPage = pageDTO.getStartBlockPage()+pageDTO.getPageBlock()-1;
        endBlockPage= pageDTO.getTotalPages()<endBlockPage? pageDTO.getTotalPages():endBlockPage;
        pageDTO.setEndBlockPage(endBlockPage);

        mv.addObject("PageDTO", pageDTO);
        mv.addObject("KnowledgeList", knowledgeList);
        mv.addObject("TagsList", tagsList);
        mv.addObject("searchTopic", searchTopic);
        mv.addObject("searchKeyword", searchKeyword);
        mv.addObject("cmmCodeList", cmmCodeList);
        mv.setViewName("service/knowledge/knowledgeList");

        return mv;
    }

}
