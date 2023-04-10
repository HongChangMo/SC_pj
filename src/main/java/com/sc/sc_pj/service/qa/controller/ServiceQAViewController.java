package com.sc.sc_pj.service.qa.controller;

import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import com.sc.sc_pj.service.qa.service.QnaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ServiceQAViewController {

    @Autowired
    private QnaService qnaService;

    @Autowired
    private CommonService commonService;

    @GetMapping("/qa/qaView")
    public ModelAndView qaView(@RequestParam("qaNo") String qaNo) {

        ModelAndView mv = new ModelAndView();

        // 조회수 증가
        int views = qnaService.UpdateViews(Long.parseLong(qaNo));

        QnaDTO dto = qnaService.getQna(qaNo);

        String topic = dto.getQaTopic();

        // 공통코드 Topic 조회
        CommonDTO comDto = commonService.getCode("qa01", topic);

        // 해시태그 Map 리스트 조회
        List<ComHashTagMapDTO> tagMaps = commonService.getTagMaps(qaNo, 1);

        List<ComHashTagDTO> hashTagList = new ArrayList<ComHashTagDTO>();

        if( tagMaps != null ) {
            for(ComHashTagMapDTO tagDto : tagMaps ) {
                ComHashTagDTO addDto = commonService.getHashTag(tagDto.getHtNo());

                hashTagList.add(addDto);
            }
        }

        mv.addObject("QnaDTO", dto);
        mv.addObject("CommonDTO", comDto);
        mv.addObject("hashTagList", hashTagList);
        mv.setViewName("service/qa/qaView");

        return mv;
    }
}
