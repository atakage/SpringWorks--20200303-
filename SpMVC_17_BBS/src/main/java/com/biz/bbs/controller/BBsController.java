package com.biz.bbs.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.domain.CommentVO;
import com.biz.bbs.service.BBsService;
import com.biz.bbs.service.CommentService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SessionAttributes("bbsVO")
@RequestMapping(value="/bbs")
@Controller
public class BBsController {

	
	
	
	private final BBsService bService;
	private final CommentService cmmService;

	@Autowired
	public BBsController(@Qualifier("bServiceV1") BBsService bService, CommentService cmmService) {
		super();
		this.bService = bService;
		this.cmmService = cmmService;
	}
	
	
	@ModelAttribute("bbsVO")
	public BBsVO makeBBsVO() {
		
		return new BBsVO();
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String selectAll(Model model) {
		
		List<BBsVO> bbsList = bService.selectAll();
		
		model.addAttribute("BBS_LIST", bbsList);
		model.addAttribute("BODY", "BBS_LIST");
		
		return "home";
		
		
	}
	
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(Model model) {
		
		// java 1.8 이상의 새로운 날짜 시간 클래스
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		
		
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		
		Date date = new Date();
		
		
		
		
		BBsVO bbsVO = BBsVO.builder().bbs_date(ld.toString()).bbs_time(lt.format(dt)).build();
		
		model.addAttribute("bbsVO", bbsVO);
		model.addAttribute("BODY", "BBS_INPUT");
		
		return "home";
		
	}
	
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute BBsVO bbsVO) {
		
		bService.save(bbsVO);
		
		return "redirect:/bbs/list";
	}
	
	
	/*
	 * 
	 * 
	 * @ModelAttribute로 설정된 bbs_id는 sessionAttribute에 설정이 되어 있기 때문에
	 * 
	 * model.addAttribute로 만드는 순간 서버 session 메모리에 데이터가 통째로 저장되어 있어서 다른 method에서 그 값을 참조가능
	 * 
	 */
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@ModelAttribute("bbs_id") String bbs_id, Model model) {
		
		
		log.debug("아이디값"+ bbs_id);
		
		
		
		
		long bbs_idL = Long.valueOf(bbs_id);
		
		BBsVO bbsVO = bService.view(bbs_idL);
		
		
		
		
		
		
		
		
		model.addAttribute("bbsVO", bbsVO);
		model.addAttribute("BODY", "BBS_VIEW");
		
		
		
		return "home";
	}
	
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String reply(@ModelAttribute("bbsVO")BBsVO bbsVO, Model model) {
		
		System.out.println("으악" + bbsVO.toString());
		
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter ld = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter lt = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		bbsVO.setBbs_date(ldt.format(ld));
		bbsVO.setBbs_time(ldt.format(lt));
		
		
		
		
		
		bbsVO = bService.reply(bbsVO);
		
		return "redirect:/bbs/list";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/comment/write", method=RequestMethod.POST)
	public String comment(CommentVO cmmVO, Model model) {
		
		log.debug("오오" + cmmVO.toString());
		
		
		int ret = cmmService.insert(cmmVO);
		
		List<CommentVO> cmmList = cmmService.selectAll(cmmVO.getCmt_p_id());
		
		
		model.addAttribute("CMT_LIST", cmmList);
		
		return "include/bbs_comment";
	}
	
	
	@RequestMapping(value="/cmt_list", method=RequestMethod.POST )
	public String cmm_list(String cmt_p_id, Model model) {
		
		long p_id = Long.valueOf(cmt_p_id);
		
		List<CommentVO> cmtList = cmmService.selectAll(p_id);
		
		model.addAttribute("CMT_LIST", cmtList);
		
		return "include/bbs_comment";
	}
	
}
