package com.sc.sc_pj.service.knowledge.controller;

import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.knowledge.domain.KnowledgeDomain;
import com.sc.sc_pj.service.knowledge.dto.KnowledgeDTO;
import com.sc.sc_pj.service.knowledge.service.KnowledgeService;
import com.sc.sc_pj.service.login.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/knowledge")
public class ServiceKnowledgeAddController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private KnowledgeService knowledgeService;

    @RequestMapping("/knowledgeWrite")
    public ModelAndView knowledgeWrite(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if( session != null ) {
            UserDTO userDTO = (UserDTO) session.getAttribute("UserDTO");
            //log.info(userDTO.toString());

            // session이 존재할때만 model에 담아줌.
            mv.addObject("UserDTO", userDTO);
        }

        List<CommonDTO> cmmCodeList = commonService.getCodes("kn01");

        mv.addObject("cmmCodeList", cmmCodeList);
        mv.setViewName("service/knowledge/knowledgeWrite");

        return mv;
    }

    @RequestMapping("/knowledgeAdd")
    public ModelAndView knowledgeAdd( @ModelAttribute( "KnowledgeDTO" ) KnowledgeDTO dto ) {
        ModelAndView mv = new ModelAndView("jsonView");

        KnowledgeDomain result = knowledgeService.addKnowledge(dto);

        if( dto.getHashtags() != null ) {
            for( String str : dto.getHashtags() ) {
                //log.info(s);
                // type_cd (1 : q&a, 2 : 지식, 3: 커뮤니티, 4: 공지사항)
                ComHashTagMapDTO comHashTagMapDTO = new ComHashTagMapDTO(result.getKnNo(), Long.parseLong(str), 2, null);

                ComHashTagMapDomain tagMap_result = commonService.addTagMap(comHashTagMapDTO);
            }
        }

        return mv;
    }
}
