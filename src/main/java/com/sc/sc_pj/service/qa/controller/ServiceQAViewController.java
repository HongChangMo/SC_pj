package com.sc.sc_pj.service.qa.controller;

import com.sc.sc_pj.service.common.dto.ComCommentDTO;
import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.login.dto.UserDTO;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import com.sc.sc_pj.service.qa.service.QnaService;
import com.sc.sc_pj.service.register.dto.RegisterDTO;
import com.sc.sc_pj.service.register.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ServiceQAViewController {

    @Autowired
    private QnaService qnaService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private CommonService commonService;

    @RequestMapping("/qa/qaView")
    public ModelAndView qaView(@RequestParam("qaNo") String qaNo, HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if( session != null ) {
            UserDTO userDTO = (UserDTO) session.getAttribute("UserDTO");
            //log.info(userDTO.toString());

            // session이 존재할때만 model에 담아줌.
            mv.addObject("UserDTO", userDTO);
        }

        // 조회수 증가
        int views = qnaService.UpdateViews(Long.parseLong(qaNo));

        QnaDTO dto = qnaService.getQna(qaNo);

        String topic = dto.getQaTopic();

        RegisterDTO registerDTO = registerService.getRegisterInfo(dto.getQaWriter());


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

        // 댓글 리스트
        List<ComCommentDTO> commentList = commonService.getCommentList(Integer.parseInt(qaNo), 1);

        mv.addObject("CommentList", commentList);
        mv.addObject("RegisterDTO", registerDTO);
        mv.addObject("QnaDTO", dto);
        mv.addObject("CommonDTO", comDto);
        mv.addObject("hashTagList", hashTagList);
        mv.setViewName("service/qa/qaView");

        return mv;
    }
}
