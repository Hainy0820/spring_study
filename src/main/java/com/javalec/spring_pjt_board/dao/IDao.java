package com.javalec.spring_pjt_board.dao;

import java.util.List;

import com.javalec.spring_pjt_board.dto.BDto;

public interface IDao {
	
	public List<BDto> list();
	
	public BDto contentView(BDto bDto);
	
	public void write(BDto bDto);
	
	public void modify(BDto bDto);
	
	public void delete(BDto bDto);
	
	public BDto replyView(BDto bDto);
	
	public void reply(BDto bDto);
	
}
