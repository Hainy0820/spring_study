package com.javalec.spring_pjt_board.command;

import java.util.List;

import com.javalec.spring_pjt_board.dto.BDto;

public interface BService {
	public List<BDto> selectAll();
	
	public BDto selectOne(BDto bDto);
	
	public void insertContent(BDto bDto);
	
	public void updateContent(BDto bDto);
	
	public void delete(BDto bDto);
	
	public BDto replyView(BDto bDto);
	
	public void reply(BDto bDto);
}
