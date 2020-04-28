package com.care.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.care.jdbc_dto.jdbcDTO;
import com.care.template.Constant;

public class jdbcDAO {
	/*
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@210.108.48.214:1521:xe";
	private String user="tjgowns",pwd="1234";
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	*/
	//위에 있는 값들은 template에서 생성했기 때문에 필요가 없다
	private JdbcTemplate template;
	public jdbcDAO() {
		this.template=Constant.template;
		
		/*try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		 */
		//위에 있는 값들은 template에서 생성했기 때문에 필요가 없다
	}
	
	public ArrayList<jdbcDTO> list(){
		String sql = "select * from test_jdbc";
		ArrayList<jdbcDTO> list=(ArrayList<jdbcDTO>)template.query(sql,new BeanPropertyRowMapper<jdbcDTO>(jdbcDTO.class));
		//mapper해당 하는 결과값을 가져옴
		
		
		return list;
	/*	ArrayList<jdbcDTO> list = new ArrayList<jdbcDTO>();
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
	*/
	}
	
	public void save(final String id,final String name) {
		String sql="insert into test_jdbc(id,name) values(?,?)";
		//값이 지정되지 않았을 경우 PreparedStatementSetter() 인터페이스를 가져와 ?표에 대한 값을 넣어준다. interface이기 때문에 람다식이 가능하다.
		
		/*
		template.update(sql,new PreparedStatementSetter(){
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
			ps.setString(1, id);ps.setString(2, name);	
			}
		});
		*/
template.update(sql,new PreparedStatementSetter(){
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
			ps.setString(1, id);
			ps.setString(2, name);	
			}
		});
		
		
		
		
		
		/*	
		try {
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/

	}
	
	
	public jdbcDTO modify(String id) {//회원의 번호와 이름을 가져옴
		//String sql="select * from test_jdbc where id=?";
		String sql="select * from test_jdbc where id="+id;		
		jdbcDTO dto=null;
		return template.queryForObject(sql, new BeanPropertyRowMapper<jdbcDTO>(jdbcDTO.class));
		//하나의 값을 가져올땐!!!!!!!!!!queryForObject를 쓴다
		
		
		/*
		try {
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto=new jdbcDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;	
		 */
	}
	public void modifySave(String id,String name) {
		//String sql="update test_jdbc set name=? where id=?";
		String sql="update test_jdbc set name='"+name+"' where id="+id;
		template.update(sql);
		
		/*
		try {
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			ps.setString(1, name);ps.setString(2, id);
			ps.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
		
		
	}
	public void delete(String id) {
		//String sql="delete from test_jdbc where id=?";
		String sql="delete from test_jdbc where id="+id;
		template.update(sql);
		/*
		try {
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
	}
	
	public int count() {
		String sql="select count(*) from test_jdbc";
		return template.queryForObject(sql, Integer.class);
		//글에 대한 개수를 인트타입으로 가져옴
		
	}
	
	
	
	
	
}

