package com.sc.sc_pj.service.main.controller;

import com.sc.sc_pj.service.login.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ServiceMainController {

    @RequestMapping("/")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if( session != null ) {
            UserDTO userDTO = (UserDTO) session.getAttribute("UserDTO");
            //log.info(userDTO.toString());

            // session이 존재할때만 model에 담아줌.
            mv.addObject("UserDTO", userDTO);
        }

        mv.setViewName("service/main/main");

        return mv;
    }
}
