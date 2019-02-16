package com.javalec.spring_pjt_board.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.spring_pjt_board.dao.IDao;
import com.javalec.spring_pjt_board.dto.BDto;

@Service("bService")
public class BServiceImpl implements BService {

	@Autowired
	private IDao boardDao;
	
	@Override
	public List<BDto> selectAll() {
		return boardDao.list();
	}

	@Override
	public BDto selectOne(BDto bDto) {
		return boardDao.contentView(bDto);
	}
	
	@Override
	public void insertContent(BDto bDto) {
		boardDao.write(bDto);
	}

	@Override
	public void updateContent(BDto bDto) {
		boardDao.modify(bDto);
		
	}

	@Override
	public void delete(BDto bDto) {
		boardDao.delete(bDto);
	}

	@Override
	public BDto replyView(BDto bDto) {
		return boardDao.replyView(bDto);
	}
	
	@Override
	public void reply(BDto bDto) {
		boardDao.reply(bDto);
	}

}
