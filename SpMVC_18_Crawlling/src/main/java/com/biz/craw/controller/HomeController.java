package com.biz.craw.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.craw.domain.NaverMovieVO;
import com.biz.craw.service.MovieCrawlService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final MovieCrawlService mcService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<NaverMovieVO> naverList = mcService.selectAll();
		
		
		model.addAttribute("NAVER_LIST", naverList);
		
		
		
		
		return "home";
	}
	
}
