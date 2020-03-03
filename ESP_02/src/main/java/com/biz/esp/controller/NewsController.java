package com.biz.esp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.esp.domain.NewsDTO;
import com.biz.esp.domain.PageDTO;
import com.biz.esp.service.NewsService;
import com.biz.esp.service.PageService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("newsDTO")
@RequestMapping(value="/news")
@Slf4j
@Controller
public class NewsController {

	@ModelAttribute("newsDTO")
	public NewsDTO makeNewsDTO() {
		NewsDTO newsDTO = new NewsDTO();
		return newsDTO;
	}
////	소식 페이지
//	@RequestMapping(value="/news", method=RequestMethod.GET)
//	public String news(Model model) {
//		
//		return "/news/news";
//	}
//	@RequestMapping(value="/news/detail", method=RequestMethod.GET)
//	public String newsDetail(Model model) {
//		
//		return "/news/news_detail";
//	}	@ModelAttribute("referenceDTO")
//	public ReferenceDTO makeRefDTO() {
//		ReferenceDTO referenceDTO = new ReferenceDTO();
//		return referenceDTO;
//	}
	@Autowired
	NewsService nService;
	
	@Autowired
	PageService pService;
	// searchField는 카테고리로 전체, 제목, 내용으로 검색할 때 사용하는 부분
	@RequestMapping(value="/nlist",method=RequestMethod.GET)
	public String getNList(@RequestParam(value = "currentPageNo", required = false, defaultValue = "1") long currentPageNo, String searchField, String search, Model model) {
		log.debug("서치필드 값 : "+searchField);
		List<NewsDTO> newsList ;
		if(searchField.equalsIgnoreCase("allList")) {
			// 서비스에서 allList일 때 작동할거 만들어주기
			newsList = nService.selectAllSearch(searchField, search);
		} else if(searchField.equalsIgnoreCase("title")) {
			// 제목으로만 검색했을 때
			newsList = nService.selectTitle(search);
		} else if(searchField.equalsIgnoreCase("content")) {
			// 내용으로 검색했을 때
			newsList = nService.selectContent(search);
		} else if(search.trim() == null || search.isEmpty()) {
			newsList = nService.selectAll(currentPageNo);
		} else {
			newsList = nService.selectAllSearch(searchField, search);
		}
		
		PageDTO pageDTO = pService.makePagination(100, currentPageNo);
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("NLIST",newsList);
		return "/news/n-list";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String nview(@RequestParam("id") String n_seq, @ModelAttribute("newsDTO") NewsDTO newsDTO, Model model, SessionStatus sStatus) {

		long r_seq = 0;
		try {
			r_seq = Long.valueOf(n_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// memoDTO를 try 밖으로 보낸 이유는 저 안에서 오류나면 서비스에서 오류난걸 알 수 없음
		newsDTO = nService.getSeq(r_seq);
		model.addAttribute("nDTO",newsDTO);

		sStatus.setComplete();
		return "/news/n-view";

	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("newsDTO") NewsDTO newsDTO, Model model) {


		model.addAttribute("nDTO",newsDTO);
		return "/news/n-input";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("newsDTO") NewsDTO newsDTO, String search, Model model) {
		NewsDTO nDTO = newsDTO;
		
		if(nDTO.getN_title().isEmpty()) {
	         nDTO.setN_title("기본 제목 형식");
	      }
	      if(nDTO.getN_content().isEmpty()) {
	         nDTO.setN_content("기본 내용 형식");
	      }
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
		
		String dateD = sd.format(date);
		st.format(date);

		nDTO.setN_date(dateD);
		nDTO.setN_writer("관리자");
		int ret = nService.insert(newsDTO);
		return "redirect:/news/nlist?searchField=&search=";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id,  @ModelAttribute("newsDTO") NewsDTO newsDTO,Model model) {
		
		long n_seq = 0;

		try {
			n_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		newsDTO = nService.getSeq(n_seq);
		model.addAttribute("newsDTO",newsDTO);
		
		return "/news/n-input";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("newsDTO") NewsDTO newsDTO, Model model) {
		
		// Service의 update 메서드를 이용해서 memoDTO를 전달
//		ReferenceDTO rDTO = referenceDTO;	
//		Date date = new Date();
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
//		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
//		
//		String dateD = sd.format(date);
//		st.format(date);
//		long lSeq = rDTO.getD_seq();
//		log.debug("시퀀스 번호 : " + lSeq);
//		rDTO.setD_date(dateD);
//		rDTO.setD_writer("관리자");
		int ret = nService.update(newsDTO);
		return "redirect:/news/nlist?searchField=&search=";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	// public String delete(long m_seq) {	
	public String delete(@ModelAttribute NewsDTO newsDTO) {
		int ret = nService.delete(newsDTO.getN_seq());
		return "redirect:/news/nlist?searchField=&search=";
	}
}
