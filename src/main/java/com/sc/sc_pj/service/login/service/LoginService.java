package com.sc.sc_pj.service.login.service;

import com.sc.sc_pj.service.login.domain.UserDomain;
import com.sc.sc_pj.service.login.dto.UserDTO;
import com.sc.sc_pj.service.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    /*
     * 로그인 시도 user info
     * @param userId, userPwd
     * @return
     * */
    public UserDTO getLoginInfo(String userId, String userPwd) {
        UserDomain domain = loginRepository.findByUserId(userId).filter(m -> m.getUserPwd().equals(userPwd))
                .orElse(null);
        UserDTO dto = new UserDTO();
        if( domain != null ) {
            dto = domain.toDTO();
        } else {
            dto = null;
        }
        return dto;
    }
}
