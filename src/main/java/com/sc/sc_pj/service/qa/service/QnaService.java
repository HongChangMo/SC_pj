package com.sc.sc_pj.service.qa.service;

import com.sc.sc_pj.service.qa.domain.QnaDomain;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import com.sc.sc_pj.service.qa.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaRepository qnaRepository;

    /*
     * q&a 리스트 검색 시
     * @param String searchKeyWord, Pageable
     * @return
     * */
    public Page<QnaDTO> getQnaSearch(String searchKeyWord, Pageable pageable) {
        return qnaRepository.findAll(searchKeyWord, pageable).map(item -> new QnaDTO(item));
    }

    /*
     * q&a 리스트 조회
     * @param Pageable
     * @return
     * */
    public Page<QnaDTO> getQnaList(Pageable pageable) {
        return qnaRepository.findAll(pageable).map(item -> new QnaDTO(item));
    }

    /*
     * q&a 등록
     * @param QnaDTO
     * @return
     * */

    public QnaDomain addQna(QnaDTO dto) {

        QnaDomain qnaDomain = dto.toEntity();

        QnaDomain result = qnaRepository.save(qnaDomain);

        return result;
    }

    public QnaDTO getQna(String qaNo) {
        QnaDomain result = qnaRepository.findByQaNo(Long.parseLong(qaNo));

        return result.toDTO();
    }

    @Transactional
    public int UpdateViews(Long qaNo) {
        return qnaRepository.UpdateViews(qaNo);
    }
}
