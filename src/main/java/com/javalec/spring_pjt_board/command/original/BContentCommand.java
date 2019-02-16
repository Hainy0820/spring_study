package com.javalec.spring_pjt_board.command.original;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.IDao;
import com.javalec.spring_pjt_board.dto.BDto;

@Service("contentCommand")
public class BContentCommand implements BCommand {

	@Autowired
	private IDao boardDao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		/*
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);
		
		BDto bDto = boardDao.contentView(bId);
		model.addAttribute("content_view", bDto);*/
	}

}
