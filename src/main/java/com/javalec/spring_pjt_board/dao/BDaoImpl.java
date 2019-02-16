package com.javalec.spring_pjt_board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalec.spring_pjt_board.dto.BDto;

@Repository("boardDao")
public class BDaoImpl implements IDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BDto> list() {
		return sqlSession.selectList("Board.selectAll");
	}
	
	@Override
	public BDto contentView(BDto bDto) {
		upHit(bDto);
		return sqlSession.selectOne("Board.selectOne", bDto);
	}

	@Override
	public void write(BDto bDto) {
		sqlSession.insert("Board.insertContent", bDto);
	}

	@Override
	public void modify(BDto bDto) {
		sqlSession.update("Board.updateContent", bDto);
	}

	@Override
	public void delete(BDto bDto) {
		sqlSession.delete("Board.deleteContent", bDto);
	}

	@Override
	public BDto replyView(BDto bDto) {
		return sqlSession.selectOne("Board.replyView", bDto);
	}

	@Override
	public void reply(BDto bDto) {
		replyShape(bDto);
		sqlSession.insert("Board.reply", bDto);
	}
	
	private void replyShape(BDto bDto) {
		sqlSession.update("Board.replyShape", bDto);
	}

	private void upHit(BDto bDto) {
		sqlSession.update("Board.upHit", bDto);
	}

}
