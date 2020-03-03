package com.biz.craw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.craw.domain.NaverMovieVO;
import com.biz.craw.service.MovieCrawlService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RequestMapping(value="/naver")
@RestController // json?
public class NaverMovieCrawlController {

	
	private final MovieCrawlService mcService;
	
	
	
	
	
	@RequestMapping(value="/rank", method=RequestMethod.GET)
	public List<NaverMovieVO> rank() {
		
		List<NaverMovieVO> naverList = mcService.selectAll();
		
		
		
		return naverList;
		
	}
	
	
}
