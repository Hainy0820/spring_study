package com.javalec.spring_pjt_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_pjt_board.command.BService;
import com.javalec.spring_pjt_board.dto.BDto;

@Controller
public class BController {
	
	@Autowired
	private BService bService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		model.addAttribute("list", bService.selectAll());
		
		return "list";
	}
	
	@RequestMapping("content_view")
	public String content_view(BDto bDto, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("content_view", bService.selectOne(bDto));
		
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BDto bDto) {
		System.out.println("write()");
		
		bService.insertContent(bDto);
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(BDto bDto) {
		System.out.println("modify()");
		
		bService.updateContent(bDto);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(BDto bDto) {
		System.out.println("delete()");
		
		bService.delete(bDto);
		
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(BDto bDto, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("reply_view", bService.replyView(bDto));
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BDto bDto) {
		System.out.println("reply()");
		
		bService.reply(bDto);
		
		return "redirect:list";
	}
	
	/*
	BCommand command;

	@Autowired
	private BCommand listCommand;
	@Autowired
	private BCommand contentCommand;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		listCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		//command = new BContentCommand();
		contentCommand.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		
		return "redirect:list";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	*/
}
