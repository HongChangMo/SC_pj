package com.sc.sc_pj.service.login.domain;

import com.sc.sc_pj.service.common.domain.ComCommentDomain;
import com.sc.sc_pj.service.login.dto.UserDTO;
import com.sc.sc_pj.service.qa.domain.QnaDomain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="tb_user")
public class UserDomain implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no")
    private Long userNo;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_pwd")
    private String userPwd;
    @Column(name="user_name")
    private String userName;

    @Column(name="user_nick_name")
    private String userNickName;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="user_age")
    private int userAge;
    @Column(name="user_gender")
    private String userGender;
    @Column(name="user_phone")
    private String userPhone;
    @Column(name="user_manager")
    private int userManager; // 관리자 여부

    @OneToMany(mappedBy = "user")
    private List<QnaDomain> qnaList = new ArrayList<>();

    @OneToMany(mappedBy = "userDomain")
    private List<ComCommentDomain> commentList = new ArrayList<>();


    @Builder
    public UserDomain(String userId, String userPwd, String userName, String userNickName, String userEmail, int userAge, String userGender, String userPhone, int userManager) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userNickName = userNickName;
        this.userEmail = userEmail;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userPhone = userPhone;
        this.userManager = userManager;
    }

    public UserDTO toDTO() {
        return new UserDTO(userNo, userId, userPwd, userName, userNickName, userEmail, userAge, userGender, userPhone, userManager);
    }
}
