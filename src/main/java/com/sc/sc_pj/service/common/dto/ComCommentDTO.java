package com.sc.sc_pj.service.common.dto;

import com.sc.sc_pj.service.common.domain.ComCommentDomain;
import com.sc.sc_pj.service.login.dto.UserDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComCommentDTO {
    // 댓글 번호
    private Long cNo;
    // 게시판 번호
    private int cBoardNo;
    // 게시판 유형
    private int cType;
    // 작성자
    private String cWriter;
    // 내용
    private String cContent;
    //작성일자
    private String cWriteDt;
    //수정일자
    private String cUpdateDt;

    private UserDTO userDTO;

    public ComCommentDomain toEntity() {
        return new ComCommentDomain(cBoardNo, cType, cWriter, cContent);
    }

    public ComCommentDTO(ComCommentDomain commentDomain) {
        this.cNo = commentDomain.getCNo();
        this.cBoardNo = commentDomain.getCBoardNo();
        this.cType = commentDomain.getCType();
        this.cWriter = commentDomain.getCWriter();
        this.cContent = commentDomain.getCContent();
        this.cWriteDt = commentDomain.getCWriteDt().toString();
        this.cUpdateDt = commentDomain.getCUpdateDt().toString();
        this.userDTO = commentDomain.getUserDomain().toDTO();
    }


}
