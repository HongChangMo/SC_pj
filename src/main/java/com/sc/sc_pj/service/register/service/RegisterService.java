package com.sc.sc_pj.service.register.service;

import com.sc.sc_pj.service.register.domain.RegisterDomain;
import com.sc.sc_pj.service.register.dto.RegisterDTO;
import com.sc.sc_pj.service.register.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterService {
    private final RegisterRepository registerRepository;

    /*
    * 회원가입
    * @param RegisterDTO
    * @return
    */
    public RegisterDTO addRegister(RegisterDTO dto) {
        RegisterDomain result = registerRepository.save(dto.toEntity());

        return result.toDTO();
    }

    public int getRegisterCount(String userId) {
        Long userCount = registerRepository.CountByUserId(userId);
        System.out.println("userCount : "+userCount);
        return userCount.intValue();
    }
}
