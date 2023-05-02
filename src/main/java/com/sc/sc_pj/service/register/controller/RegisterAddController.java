package com.sc.sc_pj.service.register.controller;

import com.sc.sc_pj.service.register.dto.RegisterDTO;
import com.sc.sc_pj.service.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/register")
public class RegisterAddController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/addUser")
    public ModelAndView registerAdd(@ModelAttribute("RegisterDTO")RegisterDTO dto) {
        ModelAndView mv = new ModelAndView("jsonView");

        RegisterDTO resultDto = registerService.addRegister(dto);

        mv.addObject("resultDto", resultDto);

        return mv;
    }

    @PostMapping("/idCheck")
    public int idCheck(@RequestParam("id")String id) {
        int result = 0;

        result = registerService.getRegisterCount(id);

        return result;
    }
}
