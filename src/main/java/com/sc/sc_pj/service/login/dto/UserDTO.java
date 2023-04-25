package com.sc.sc_pj.service.login.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDTO {
    private Long userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private int userAge;
    private String userGender;
    private String userPhone;
    // 관리자 여부
    private int userManager;

}
