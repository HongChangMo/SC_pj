package com.sc.sc_pj.service.common.service;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import com.sc.sc_pj.service.common.domain.CommonDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.repository.ComHashTagRepository;
import com.sc.sc_pj.service.common.repository.CommonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonService {
    private final CommonRepository commonRepository;
    private final ComHashTagRepository comHashTagRepository;

    /*
    * 공통코드 리스트 출력
    * @param com_type
    * @return
    * */
    public List<CommonDTO> getCodes(String cmmType) {
        return commonRepository.findByCmmType(cmmType);
    }

    /*
     * 해시태그 리스트 출력
     * @param com_type
     * @return
     * */
    public List<ComHashTagDTO> getTags(String htNm) {
        return comHashTagRepository.findByHtNmLike("%" +htNm.toUpperCase() + "%");
    }

    public ComHashTagDomain addTag(ComHashTagDTO dto) {

        ComHashTagDomain comHashTagDomain = dto.toEntity();

        ComHashTagDomain result = comHashTagRepository.save(comHashTagDomain);

        return result;
    }
}
