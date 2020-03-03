package com.biz.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.service.FriendService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/friend")
@Controller
public class FriendController {

	
	@Autowired
	FriendService fService;
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		
		FriendVO friendVO = new FriendVO();
		
		
		
		String fr_code = fService.codeCreate();  // 데이터 없으면 코드값 1부터
		
		 
		log.debug("코드가져오기전" + fr_code);
		
		model.addAttribute("INCLUDEPAGE", "insert");
		model.addAttribute("friendVO", friendVO);
		model.addAttribute("fr_code", fr_code);
		
		return "home";
		
		
	}
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute FriendVO friendVO) {
		
		
		
		
		
		
		fService.insert(friendVO);
		
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET )
	public String update(@RequestParam("fr_code") String fr_code, Model model) {
		
		
		 FriendVO friendVO = fService.selectByCode(fr_code);
		
		model.addAttribute("friendVO", friendVO );
		model.addAttribute("INCLUDEPAGE", "update");
		
		return "home";
	}
	
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute FriendVO friendVO) {
		
		
		log.debug("업데이트VO체크:" + friendVO);
		int ret = fService.update(friendVO);
		
		
		return "redirect:/";
		
	}
	
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@RequestParam("optionVal") String optionVal, @RequestParam("searchVal") String searchVal, Model model) {
		
		if(optionVal == "fr_number") {
			
			int searchValI = Integer.valueOf(searchVal);
			
			
			
		}
		
		
		List<FriendVO> friendList = fService.search(optionVal, searchVal);
		
		
		model.addAttribute("INCLUDEPAGE", "mainList");
		model.addAttribute("FRIENDLIST", friendList);
		
		return "home";
	}
	
	
	
}
