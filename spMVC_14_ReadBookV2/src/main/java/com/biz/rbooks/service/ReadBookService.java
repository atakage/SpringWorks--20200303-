package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.RequiredArgsConstructor;
/*
 *
 * private final 변수에 대한 생성자를 자동으로 만들고 Autowired를 붙여서 주입할 수 있도록 설정
 * */
@RequiredArgsConstructor
@Service
public class ReadBookService {

	public final ReadBookDao readBookDao;

	public int insert(ReadBookVO rbookVO) {
		
		
		int ret = readBookDao.insert(rbookVO);
		// TODO Auto-generated method stub
		return ret;
	}

	public List<ReadBookVO> selectAll() {
		// TODO Auto-generated method stub
		
		
		List<ReadBookVO> readBookList = readBookDao.selectAll();
		return readBookList;
	}

	public ReadBookVO findBySeq(long rb_seq) {
		// TODO Auto-generated method stub
		
		ReadBookVO readBookVO = readBookDao.findBySeq(rb_seq);
		return readBookVO;
	}

	public int update(ReadBookVO rBookVO) {
		// TODO Auto-generated method stub
		
		int ret = readBookDao.update(rBookVO);
		return ret;
	}

	public int delete(String rb_seq) {
		// TODO Auto-generated method stub
		
		long longRb_seq = Long.valueOf(rb_seq);
		int ret = readBookDao.delete(longRb_seq);
		return ret;
	}

	public List<ReadBookVO> findByBCode(String b_code) {
		// TODO Auto-generated method stub
		
	
		
		return readBookDao.findByBCode(b_code);
	}
}
