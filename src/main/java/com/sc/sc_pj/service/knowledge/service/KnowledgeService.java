package com.sc.sc_pj.service.knowledge.service;

import com.sc.sc_pj.service.knowledge.domain.KnowledgeDomain;
import com.sc.sc_pj.service.knowledge.dto.KnowledgeDTO;
import com.sc.sc_pj.service.knowledge.repository.KnowledgeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    /*
     * 지식 리스트 검색 (keyword)
     * @param String searchKeyWord, Pageable
     * @return
     * */
    public Page<KnowledgeDTO> getKnowledgeSearch(String searchKeyWord, Pageable pageable) {
        return knowledgeRepository.findAll(searchKeyWord, pageable).map(item -> new KnowledgeDTO(item));
    }

    /*
     * 지식 리스트 검색 (keyword, topic)
     * @param String searchKeyWord, String searchTopic, Pageable
     * @return
     * */
    public Page<KnowledgeDTO> getKnowledgeSearch(String searchKeyWord, String searchTopic, Pageable pageable) {
        return knowledgeRepository.findAll(searchKeyWord, searchTopic, pageable).map(item -> new KnowledgeDTO(item));
    }

    /*
     * 지식 리스트 검색
     * @param Pageable
     * @return
     * */
    public Page<KnowledgeDTO> getKnowledgeList(Pageable pageable) {
        return knowledgeRepository.findAll(pageable).map(item -> new KnowledgeDTO(item));
    }

    /*
     * 지식 등록
     * @param KnowledgeDTO
     * @return
     * */
    public KnowledgeDomain addKnowledge(KnowledgeDTO dto) {
        return knowledgeRepository.save(dto.toEntity());
    }

    /*
     * 지식 단일 건 조회
     * @param Long knNo
     * @return
     * */
    public KnowledgeDTO getKnowledge(long knNo) {
        return knowledgeRepository.findByKnNo(knNo).toDTO();
    }

    /*
     * 지식 조회수 증가
     * @param Long knNo
     * @return
     * */
    @Transactional
    public int UpdateViews(Long knNo) {
        return knowledgeRepository.UpdateViews(knNo);
    }
}
