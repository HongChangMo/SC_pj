package com.sc.sc_pj.service.login.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecaptchaController {
    @Value("${recaptcha.secretKey}")
    private String secretKey;

    /*@GetMapping("/recaptcha/login")
    public ResRecaptchaForm login() {

    }*/
}
