package com.care.jdbc_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.jdbc_dao.jdbcDAO;

public class jdbcSaveServiceImpl implements jdbcService {

	@Override
	public void execute(Model model) {
		Map<String,Object> map=model.asMap();
//MemberController에서 던져준 model값(id,name)을 받기 위해선 map형태로 받는다 
		HttpServletRequest request =
				(HttpServletRequest)map.get("request");
//map현태로 변환한값을 map.get을 통해 가져옴 request안에는 id와 name이 들어있다 
//key=request value=model에 있는 id값 id와 name		
		String id= request.getParameter("id");
		String name=request.getParameter("name");
//parameter를 통해  값을 가져오고 DAO에 던져준다
		jdbcDAO dao= new jdbcDAO();
		dao.save(id,name);
		
	}

}
