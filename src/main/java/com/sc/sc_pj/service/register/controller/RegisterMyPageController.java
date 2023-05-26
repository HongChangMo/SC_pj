package com.sc.sc_pj.service.register.controller;

import com.sc.sc_pj.service.register.dto.RegisterDTO;
import com.sc.sc_pj.service.register.dto.RegisterFileDTO;
import com.sc.sc_pj.service.register.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Controller
public class RegisterMyPageController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/myPage")
    public ModelAndView myPage(@RequestParam("userNo") Long userNo, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        RegisterDTO dto = registerService.getRegister(userNo);

        mv.addObject("RegisterDTO", dto);
        mv.setViewName("service/mypage/mypage");
        return mv;
    }

    @PostMapping("/myPage/editInfo")
    public ModelAndView editInfo(@ModelAttribute("RegisterDTO") RegisterDTO dto) throws Exception {
        ModelAndView mv = new ModelAndView("jsonView");

        // log.info("dto.getUserNo() :" + dto.getUserNo());
        // log.info("profileImage : " + dto.getProfileImage());
        // log.info("dto.getUserNickName() :" + dto.getUserNickName());
        // log.info("dto.getUserPwd() :" + dto.getUserPwd());
        // log.info("dto.getUserPhone() :" + dto.getUserPhone());

        // 유저 정보 수정
        int result = registerService.updateRegister(dto);

        MultipartFile file = dto.getProfileImage();

        registerService.fileUpload( dto.getUserNo(), file );

        mv.addObject("result", result);

        return mv;

    }

    @RequestMapping("/profile/imageview")
    public ModelAndView getImageView(long userNo) {
        ModelAndView mv = new ModelAndView("imageView");

        RegisterFileDTO dto = registerService.getRegisterFile(userNo);

        mv.addObject("fileFullPath", dto.getFileSavePath());

        return mv;
    }

    @RequestMapping("/profile/listImageView")
    public ModelAndView getListImageView(long userNo) {
        ModelAndView mv = new ModelAndView("listImageView");

        RegisterFileDTO dto = registerService.getRegisterFile(userNo);

        mv.addObject("fileFullPath", dto.getFileSavePath());

        return mv;
    }
}
