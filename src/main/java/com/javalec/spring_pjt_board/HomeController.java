package com.javalec.spring_pjt_board;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_pjt_board.command.ITicketCommand;
import com.javalec.spring_pjt_board.dto.TicketDto;

@Controller
public class HomeController {
	
	private ITicketCommand ticketCommand;
	
	@Autowired
	public void setTicketCommand(ITicketCommand ticketCommand) {
		this.ticketCommand = ticketCommand;
	}	
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
		
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model) {
		System.out.println( "buy_ticket_card" );
		System.out.println( "ticketDto : " + ticketDto.getConsumerId() );
		System.out.println( "ticketDto : " + ticketDto.getAmount() );
			
		ticketCommand.execute(ticketDto);
		
		model.addAttribute("ticketInfo", ticketDto);
		
		return "buy_ticket_end";
	}	
	
	@RequestMapping("/login.html")
	public String login(Locale locale, Model model) {
		
		return "security/login";
	}
	
	@RequestMapping("/welcome.html")
	public String welcome(Locale locale, Model model) {
		
		return "security/welcome";
	}
	
	@RequestMapping("/loginForm.html")
	public String loginForm(Locale locale, Model model) {
		
		return "security/loginForm";
	}
	
}
