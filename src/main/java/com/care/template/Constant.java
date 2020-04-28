package com.care.template;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	public static JdbcTemplate template;
	//static으로 만들면 객체 생성이 필요없다. Constant.template로 선언가능.
}
