package com.sc.sc_pj.service.common.service;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.domain.CommonDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import com.sc.sc_pj.service.common.repository.ComHashTagMapRepository;
import com.sc.sc_pj.service.common.repository.ComHashTagRepository;
import com.sc.sc_pj.service.common.repository.CommonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonService {
    private final CommonRepository commonRepository;
    private final ComHashTagRepository comHashTagRepository;

    private final ComHashTagMapRepository comHashTagMapRepository;

    /*
    * 공통코드 리스트 출력
    * @param com_type
    * @return
    * */
    public List<CommonDTO> getCodes(String cmmType) {

        List<CommonDomain> cmmCodeList = commonRepository.findByCmmType(cmmType);
        // DTO List 변환
        List<CommonDTO> codeList = new ArrayList<CommonDTO>();

        for( CommonDomain domain : cmmCodeList ) {
            codeList.add(domain.toDTO());
        }

        return codeList;
    }

    /*
     * 단일 공통코드 조회
     * @param CommonDTO
     * @return
     * */
    public CommonDTO getCode(String cmmType, String cmmCd) {

        CommonDomain result = commonRepository.findByCmmTypeAndCmmCd(cmmType, cmmCd);

        return result.toDTO();
    }
    /*
     * 해시태그 리스트 출력
     * @param com_type
     * @return
     * */
    public List<ComHashTagDTO> getTags(String htNm) {
        return comHashTagRepository.findByHtNmLike("%" +htNm.toUpperCase() + "%");
    }

    /*
     * 해시태그 추가(사용자)
     * @param ComHashTagDTO
     * @return
     * */
    public ComHashTagDomain addTag(ComHashTagDTO dto) {

        ComHashTagDomain comHashTagDomain = dto.toEntity();

        ComHashTagDomain result = comHashTagRepository.save(comHashTagDomain);

        return result;
    }

    /*
     * 단일 해시태그 조회
     * @param long htNo
     * @return ComHashTagDTO
     * */
    public ComHashTagDTO getHashTag(long htNo) {
        ComHashTagDomain domain = comHashTagRepository.findByHtNo(htNo);

        return domain.toDTO();
    }

    /*
     * 해시태그 Map 저장
     * @param ComHashTagMapDTO
     * @return
     * */
    public ComHashTagMapDomain addTagMap(ComHashTagMapDTO dto) {

        ComHashTagMapDomain comHashTagMapDomain = dto.toEntity();

        ComHashTagMapDomain result = comHashTagMapRepository.save(comHashTagMapDomain);

        return result;
    }

    /*
     * 해시태그 Map Id 조회
     * @param String qaNo
     * @return
     * */
    public List<ComHashTagMapDTO> getTagMaps(String htmNo, int typeCd) {

        List<ComHashTagMapDomain> tagList = comHashTagMapRepository.findTagMapsList(Long.parseLong(htmNo), typeCd);

        List<ComHashTagMapDTO> tagsList = new ArrayList<ComHashTagMapDTO>();

        for (ComHashTagMapDomain domain : tagList) {
            tagsList.add(domain.toDTO());
        }

        return tagsList;
    }

    public List<ComHashTagMapDTO> getAllTags() {
        List<ComHashTagMapDomain> tagMaps = comHashTagMapRepository.findAll();

        List<ComHashTagMapDTO> tagsList = new ArrayList<ComHashTagMapDTO>();

        for (ComHashTagMapDomain domain : tagMaps) {
            tagsList.add(domain.toDTO());
        }

        return tagsList;
    }
}
