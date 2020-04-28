package com.care.jdbc_service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.care.jdbc_dao.jdbcDAO;
import com.care.jdbc_dto.jdbcDTO;

public class jdbcContentServiceImpl implements jdbcService {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		jdbcDAO dao = new jdbcDAO();
		ArrayList<jdbcDTO> list = dao.list();
		model.addAttribute("list",list);
		model.addAttribute("count",dao.count());
		
		
	}

}
