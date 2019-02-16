package com.javalec.spring_pjt_board.command.original;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.IDao;
import com.javalec.spring_pjt_board.dto.BDto;

@Service("listCommand")
public class BListCommand implements BCommand {

	@Autowired
	private IDao boardDao;

	@Override
	public void execute(Model model) {
		/*BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);*/
		
		List<BDto> dtos = boardDao.list();
		model.addAttribute("list", dtos);
	}
}
