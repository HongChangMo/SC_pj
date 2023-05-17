package com.sc.sc_pj.service.register.dto;

import com.sc.sc_pj.service.register.domain.RegisterDomain;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class RegisterDTO {
    private Long userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userNickName;
    private String userEmail;
    private int userAge;
    private String userGender;
    private String userPhone;
    // 관리자 여부
    private int userManager;

    private MultipartFile profileImage;

    public RegisterDomain toEntity() {
        return new RegisterDomain(userId, userPwd, userName, userNickName, userEmail, userAge, userGender, userPhone, userManager);
    }

}
