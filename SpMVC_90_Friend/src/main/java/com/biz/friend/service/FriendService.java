package com.biz.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.persistence.FriendDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FriendService {

	@Autowired
	FriendDao fDao;
	
	
	public String codeCreate() {
		// TODO Auto-generated method stub
		
		String fr_code = null;
		String rawMaxCode = fDao.createCode();
		
		log.debug("로맥스" + rawMaxCode);
		
		if(rawMaxCode == null) {
			
			fr_code = "F0001";
			return fr_code;
			
		}
		
		
		
		
		
		 int rawMaxCodeInt = Integer.valueOf(rawMaxCode.substring(1));
		 rawMaxCodeInt += 1;
		 
		  fr_code = String.format("F%04d", rawMaxCodeInt);
		 
		  
		  return fr_code;
		 
		
		
	}


	public int insert(FriendVO friendVO) {
		// TODO Auto-generated method stub
		
		
		return fDao.insert(friendVO);
		
	}


	public List<FriendVO> selectAll() {
		// TODO Auto-generated method stub
		return fDao.selectAll();
	}


	public FriendVO selectByCode(String fr_code) {
		// TODO Auto-generated method stub
		return fDao.selectByCode(fr_code);
	}


	public int update(FriendVO friendVO) {
		// TODO Auto-generated method stub
		
		return fDao.update(friendVO);
		
	}


	public List<FriendVO> search(String optionVal, String searchVal) {
		// TODO Auto-generated method stub
		
		
		
		
		
		return fDao.search(optionVal, searchVal);
	}

	
	
	
}
