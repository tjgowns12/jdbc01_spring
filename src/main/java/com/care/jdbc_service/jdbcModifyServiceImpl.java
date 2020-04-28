package com.care.jdbc_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.jdbc_dao.jdbcDAO;

public class jdbcModifyServiceImpl implements jdbcService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map= model.asMap();
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String id=request.getParameter("id");
		jdbcDAO dao =new jdbcDAO();
		model.addAttribute("list",dao.modify(id));
		
	}

}
