package com.care.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.jdbc_service.jdbcContentServiceImpl;
import com.care.jdbc_service.jdbcService;

@Controller
public class MemberController {
	private jdbcService jdbc;
	@RequestMapping("content")//데이터베이스에 있는 목록을 가져옴
	public String content(Model model) {
		jdbc = new jdbcContentServiceImpl();
		jdbc.execute(model);
		return "content";
	}
}
