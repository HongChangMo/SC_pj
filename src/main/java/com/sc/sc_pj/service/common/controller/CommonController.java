package com.sc.sc_pj.service.common.controller;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RequestMapping("/com")
@RestController
public class CommonController {
    @Autowired
    private CommonService commonService;

    @PostMapping("/hashtagList")
    public List<Map<String,Object>> getTagList(String htNm) {
        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();

        List<ComHashTagDTO> tagsList =  commonService.getTags(htNm);

        // Map에 태그 데이터 부여
        for (int i=0; i<tagsList.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", tagsList.get(i).getHtNo().toString() );
            map.put("name", tagsList.get(i).getHtNm());

            listMap.add(map);
        }

        return listMap;
    }

    @PostMapping("/hashtagAdd")
    public ComHashTagDomain addTag(ComHashTagDTO dto) {

        ComHashTagDomain result = commonService.addTag(dto);
        log.debug(result.toString());

        return result;
    }
}
