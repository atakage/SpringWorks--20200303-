package com.biz.esp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.ReferenceDTO;
import com.biz.esp.persistence.ReferenceDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ReferenceService {

	@Autowired
	SqlSession sqlSession;
	
	ReferenceDao refDao;
	
	@Autowired
	public void getRefDao() {
		this.refDao = sqlSession.getMapper(ReferenceDao.class);
	}
	// DB를 리스트 통째로 가져오기
	public List<ReferenceDTO> selectAll(long now){
		Map map = new HashMap();
		map.put("now", now);
		List<ReferenceDTO> rList = refDao.selectAll(map);
		
		return rList;
	}
	// PK로 가져오기
	public ReferenceDTO getSeq(long d_seq) {

		ReferenceDTO rDTO = refDao.findById(d_seq);
		return rDTO;
	}
	public int insert(ReferenceDTO referenceDTO) {

//		ReferenceDTO rDTO = referenceDTO;
//		String text= rDTO.getD_content();
//		text = text.replaceAll("\n\r|\r|\n","\n");
//		rDTO.setD_content(text);
//		
		return refDao.insert(referenceDTO);
	}
	public int update(ReferenceDTO referenceDTO) {
		// TODO Auto-generated method stub
		return refDao.update(referenceDTO);
	}
	
	public int delete(long d_seq) {
		// TODO Auto-generated method stub
		return refDao.delete(d_seq);
	}
	public List<ReferenceDTO> selectAllSearch(String searchField, String search) {

		ReferenceDTO referenceDTO = ReferenceDTO.builder()
								.d_title(search)
								.d_content(search)
								.build();
		return refDao.findByAll(referenceDTO);
	}
	public List<ReferenceDTO> selectTitle(String search) {
		ReferenceDTO referenceDTO = ReferenceDTO.builder()
								.d_title(search)
								.build();
		return refDao.findByTitle(referenceDTO);
	}
	public List<ReferenceDTO> selectContent(String search) {
		ReferenceDTO referenceDTO = ReferenceDTO.builder()
								.d_content(search)
								.build();
		return refDao.findByContent(referenceDTO);
	}
	public List<ReferenceDTO> selectFiveList() {

		return refDao.selectFiveList();
	}
}
