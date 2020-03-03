package com.biz.rbooks.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.repository.BookDao;

import lombok.RequiredArgsConstructor;

/*
 *  private final로 설정된 필드 변수들의 생성자를 생성하고 자동 inject(@Autowired)를 수행해줌
 */
@RequiredArgsConstructor
@Service
public class BookService {

	
	
	private final BookDao bookDao;

	

	public List<BookVO> selectAll(){
		
		 List<BookVO> bookList= bookDao.selectAll();
		
		return bookList;
	}



	public void insert(BookVO bookVO) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		String b_code = rnd.nextGaussian()+ "";
		bookVO.setB_code(b_code);
		bookVO.setB_name("연습하기");
		bookVO.setB_auther("연습작가");
		
		bookDao.insert(bookVO);
		
	}



	public List<BookVO> searchfindByBNames(String strText) {
		// TODO Auto-generated method stub
		
		List<String> names = Arrays.asList(strText.split(" "));	// strText를 빈칸으로 분해하여 문자열 배열을 만들고 그 배열을 List<String>형으로 변환한 다음
																			// names List에 담기
		
		List<BookVO> bookList = bookDao.findByBNames(names);
		return bookList;
	}



	public BookVO findByBCode(String b_code) {
		
		BookVO bookVO = bookDao.findByBCode(b_code);
		// TODO Auto-generated method stub
		return bookVO;
	}
	
	
	
}