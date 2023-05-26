package com.sc.sc_pj.service.knowledge.controller;

import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.knowledge.dto.KnowledgeDTO;
import com.sc.sc_pj.service.knowledge.service.KnowledgeService;
import com.sc.sc_pj.service.register.dto.RegisterDTO;
import com.sc.sc_pj.service.register.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequestMapping("/knowledge")
public class ServiceKnowledgeViewController {
    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private CommonService commonService;

    @GetMapping("/knowledgeView")
    public ModelAndView knowledgeView(@RequestParam("knNo") String knNo ) {
        ModelAndView mv = new ModelAndView();

        int views = knowledgeService.UpdateViews(Long.parseLong(knNo));

        KnowledgeDTO dto = knowledgeService.getKnowledge(Long.parseLong(knNo));

        String topic = dto.getKnTopic();

        RegisterDTO registerDTO = registerService.getRegisterInfo(dto.getKnWriter());

        // 공통코드 Topic 조회
        CommonDTO comDto = commonService.getCode("kn01", topic);

        // 해시태그 Map 리스트 조회
        List<ComHashTagMapDTO> tagMaps = commonService.getTagMaps(knNo, 2);

        List<ComHashTagDTO> hashTagList = new ArrayList<ComHashTagDTO>();

        if( tagMaps != null ) {
            for(ComHashTagMapDTO tagDto : tagMaps ) {
                ComHashTagDTO addDto = commonService.getHashTag(tagDto.getHtNo());

                hashTagList.add(addDto);
            }
        }

        mv.addObject("RegisterDTO", registerDTO);
        mv.addObject("KnowledgeDTO", dto);
        mv.addObject("CommonDTO", comDto);
        mv.addObject("hashTagList", hashTagList);
        mv.setViewName("service/knowledge/knowledgeView");

        return mv;
    }
}
