package com.biz.esp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.NewsDTO;
import com.biz.esp.persistence.NewsDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewsService {

	@Autowired
	SqlSession sqlSession;
	
	NewsDao newsDao;
	
	@Autowired
	public void getNewsDao() {
		this.newsDao = sqlSession.getMapper(NewsDao.class);
	}
	
	public List<NewsDTO> selectAll(long now){
		Map map = new HashMap();
		map.put("now", now);
		
		List<NewsDTO> nList = newsDao.selectAll(map);
		
		return nList;
	}
	
	// PK로 가져오기
	public NewsDTO getSeq(long n_seq) {

		NewsDTO nDTO = newsDao.findById(n_seq);
		return nDTO;
	}
	public int insert(NewsDTO newsDTO) {

		
		
		return newsDao.insert(newsDTO);
	}
	public int update(NewsDTO newsDTO) {
		// TODO Auto-generated method stub
		return newsDao.update(newsDTO);
	}
	
	public int delete(long n_seq) {
		// TODO Auto-generated method stub
		return newsDao.delete(n_seq);
	}
	public List<NewsDTO> selectAllSearch(String searchField, String search) {

		NewsDTO newsDTO = NewsDTO.builder()
								.n_title(search)
								.n_content(search)
								.build();
		return newsDao.findByAll(newsDTO);
	}
	public List<NewsDTO> selectTitle(String search) {
		NewsDTO newsDTO = NewsDTO.builder()
								.n_title(search)
								.build();
		return newsDao.findByTitle(newsDTO);
	}
	public List<NewsDTO> selectContent(String search) {
		NewsDTO newsDTO = NewsDTO.builder()
								.n_content(search)
								.build();
		return newsDao.findByContent(newsDTO);
	}

	public List<NewsDTO> selectFiveList() {
		
		return newsDao.selectFiveList();
	}

	
}
