package com.care.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.care.jdbc_dto.jdbcDTO;

public class jdbcDAO {
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@210.108.48.214:1521:xe";
	private String user="tjgowns",pwd="1234";
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	public jdbcDAO() {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<jdbcDTO> list(){
		String sql = "select * from test_jdbc";
		ArrayList<jdbcDTO> list = new ArrayList<jdbcDTO>();
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				jdbcDTO dto = new jdbcDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				list.add(dto);
			}
		} catch (SQLException e) {	e.printStackTrace(); }
		return list;
	}
}

