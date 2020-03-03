package com.biz.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.respository.EmailDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MailService {

	private final EmailDao emsDao;
	
	
	public int insert(EmailVO emailVO) {
		
		emsDao.save(emailVO);
		
		return 0;
	}
	
	
	public List<EmailVO> selectAll(){
		
		List<EmailVO> mailList = (List<EmailVO>) emsDao.findAll();
		
		return mailList;
	}
	
	
	public EmailVO findBySeq(long ems_seq) {
		
		EmailVO emailVO = emsDao.findByEmsSeq(ems_seq);
		
		return emailVO;
	}
	
}
