package com.biz.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.repository.ToDoListDao;

@Service("toServiceV2")
public class ToDoServiceV2 extends ToDoServiceV1{

	
	
	


	@Override
	public int update(ToDoList toDoList) {
		// TODO Auto-generated method stub
		
		
		
		
		return todoListDao.update(toDoList);
	}


	@Override
	public int delete(long td_seq) {
		// TODO Auto-generated method stub
		return todoListDao.delete(td_seq);
	}


	@Override
	public int complete(String strSeq, String tdComplete) {
	
		
		long tdSeq = Long.valueOf(strSeq);
		
		//tdComplete = tdComplete.equalsIgnoreCase("Y") ? "N" : "Y";
		
		return todoListDao.complete(tdSeq);
	}
	
	
	@Override
	public int alaram(String strSeq, String tdAlaram) {
	
		
		long tdSeq = Long.valueOf(strSeq);
		
		//tdAlaram = tdAlaram.equalsIgnoreCase("Y") ? "N" : "Y";
		
		return todoListDao.alaram(tdSeq);
	}

	
	
	
}
