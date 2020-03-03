package com.biz.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.service.FriendService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	
	@Autowired
	 FriendService fService;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		List<FriendVO> friendList = fService.selectAll();
		
		
		model.addAttribute("INCLUDEPAGE", "mainList");
		model.addAttribute("FRIENDLIST", friendList);
		
		return "home";
	}
	
}
