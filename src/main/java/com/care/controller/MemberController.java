package com.care.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.jdbc_service.jdbcContentServiceImpl;
import com.care.jdbc_service.jdbcDeleteServiceImpl;
import com.care.jdbc_service.jdbcModifySaveServiceImpl;
import com.care.jdbc_service.jdbcModifyServiceImpl;
import com.care.jdbc_service.jdbcSaveServiceImpl;
import com.care.jdbc_service.jdbcService;
import com.care.template.Constant;

@Controller
public class MemberController {
	private jdbcService jdbc;
	public MemberController() {
		System.out.println("자동으로 실행됩니다.");
		String config ="classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx=
				new GenericXmlApplicationContext(config);
		JdbcTemplate template=ctx.getBean("template",JdbcTemplate.class);
		Constant.template = template;

	
	}
		

	@RequestMapping("content")//데이터베이스에 있는 목록을 가져옴
	public String content(Model model) {
		jdbc = new jdbcContentServiceImpl();
		jdbc.execute(model);
		return "content";
	}
	
	@RequestMapping("save_view")
	public String save_view() {
		return "save_view";
	}
	@RequestMapping("save")
	public String save(Model model,HttpServletRequest request) {
		model.addAttribute("request",request);
		jdbc=new jdbcSaveServiceImpl();
		jdbc.execute(model);
		return "redirect:content"; 
	}
	@GetMapping("modify")
	public String modify(Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		jdbc=new jdbcModifyServiceImpl();
		jdbc.execute(model);;
		return "modify";
		}
	
	@GetMapping("modifySave")
	public String modifySave(Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		jdbc=new jdbcModifySaveServiceImpl();
		jdbc.execute(model);;
		
		return "redirect:content";
		}
	
	@GetMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		jdbc=new jdbcDeleteServiceImpl();
		jdbc.execute(model);;
		
		return "redirect:content";
		}
	
	
		
		
		
		
		
	}
	
	

	
	

