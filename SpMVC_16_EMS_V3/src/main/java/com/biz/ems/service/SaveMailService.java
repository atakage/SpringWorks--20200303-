package com.biz.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.respository.EmailDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaveMailService {

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
		
		Optional<EmailVO> emailVO = emsDao.findById(ems_seq);
		
		//EmailVO emailVO = emsDao.findByEmsSeq(ems_seq);
		
		return (EmailVO) emailVO.get();
	}


	public void update(EmailVO emailVO) {
		// TODO Auto-generated method stub
		
		emsDao.save(emailVO);
		
	}


	public void delete(String ems_seq) {
		// TODO Auto-generated method stub
		
		long ems_seqL = Long.valueOf(ems_seq);
		
		emsDao.deleteById(ems_seqL);
		
	}
	
}
