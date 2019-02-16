package com.javalec.spring_pjt_board.command;

import com.javalec.spring_pjt_board.dto.TicketDto;

public interface ITicketCommand {

	public void execute(TicketDto ticketDto);
	
}
