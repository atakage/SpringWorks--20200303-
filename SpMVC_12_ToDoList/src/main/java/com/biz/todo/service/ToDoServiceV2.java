package com.biz.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.repository.ToDoListDao;

@Service("toServiceV2")
public class ToDoServiceV2 extends ToDoServiceV1{

	
	
	@Override
	public int complete(String strSeq, String tdComplete) {
	
		
		long tdSeq = Long.valueOf(strSeq);
		
		tdComplete = tdComplete.equalsIgnoreCase("Y") ? "N" : "Y";
		
		return todoListDao.complete(tdSeq, tdComplete);
	}
	
	
	@Override
	public int alaram(String strSeq, String tdAlaram) {
	
		
		long tdSeq = Long.valueOf(strSeq);
		
		tdAlaram = tdAlaram.equalsIgnoreCase("Y") ? "N" : "Y";
		
		return todoListDao.alaram(tdSeq, tdAlaram);
	}

	
	
	
}
