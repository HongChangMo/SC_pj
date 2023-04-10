package com.sc.sc_pj;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.service.CommonService;
import com.sc.sc_pj.service.qa.domain.QnaDomain;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import com.sc.sc_pj.service.qa.service.QnaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HcmPjApplicationTests {

	@Autowired
	private QnaService qnaService;

	@Autowired
	private CommonService commonService;

	@Test
	void contextLoads() {
	}

	@Test
	// qna 등록 테스트
	public void qaAdd() {

		QnaDTO dto = new QnaDTO();

		String qaTopic = "01";
		String qaContents = "contents";
		String qaTitle = "title";
		String qaWriter = "writer";
		String[] hashtags = {"1","4","5"};

		dto.setQaTopic(qaTopic);
		dto.setQaWriter(qaWriter);
		dto.setQaContents(qaContents);
		dto.setQaTitle(qaTitle);
		dto.setHashtags(hashtags);

		QnaDomain result = qnaService.addQna(dto);

		//System.out.println("result.getQaNo(); : " + result.getQaNo());

		if( dto.getHashtags() != null ) {
			for( String s : dto.getHashtags() ) {
				//log.info(s);
				ComHashTagMapDTO comHashTagMapDTO = new ComHashTagMapDTO(result.getQaNo(), Long.parseLong(s), 1);

				ComHashTagMapDomain result2 = commonService.addTagMap(comHashTagMapDTO);

			}
		}


	}

}
