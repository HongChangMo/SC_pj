package com.sc.sc_pj.service.login.controller;

import com.sc.sc_pj.RecaptchaConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RecaptchaController {
    @Value("${recaptcha.secretKey}")
    private String secretKey;

    @GetMapping("/recaptcha/login")
    public int login( HttpServletRequest request ) {

        // recaptcha 시크릿 키 적용 ( properties에서 가져옴 보안 유지 )
        RecaptchaConfig.setSecretKey(secretKey);
        
        String gRecaptchaResponse = request.getParameter("recaptcha");

        try{

            if( RecaptchaConfig.verify(gRecaptchaResponse) ) {
                
                // 성공
                
                return 0;
            } else {
                
                // 실패
                return 1;
            }

        } catch(Exception e) {
            e.printStackTrace();
            
            // 오류일시 -1 반환
            return -1;
        }
    }
}
