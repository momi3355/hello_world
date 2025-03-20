package com.yedam.bookapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberJdbc {
	private static final String TABLE_NAME = "tbl_member";
	
	//Connection 생성.
	private Connection getConnect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		return DriverManager.getConnection(url, userId, userPw);
	}
	
	public String login(String id, String pw) {
		//id, pw 조회 후 결과가 있으면 로그인 성공, 실패
		Map<String, String> map = new HashMap<String,String>();
		String sql = "";
		Connection conn = null;
		
		String userData = "user_name";
		try {
			conn = getConnect();
			sql = "SELECT user_name"
				+" FROM   "+TABLE_NAME
				+" WHERE user_id  = ?"
				+"   AND password = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) { //하나만 있기 때문에 if 만 해도 된다.
				map.put(userData, rs.getString(userData));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse(conn);
		}
		
		if (map.isEmpty()) return "";
		else return map.get(userData);
	}
	
	public List<Map<String, String>> memberList() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		String sql = "";
		Connection conn = null;
		
		String[] userData = { "user_id", "user_name", "password" };
		try {
			conn = getConnect();
			sql = "SELECT user_id, user_name, password "
				+ "FROM   "+TABLE_NAME;
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				for (String data : userData)
					map.put(data, rs.getString(data));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse(conn);
		}
		
		return list;
	}
	
	private void colse(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("정상적인 종료을 하지 못했습니다.");
			}
		}
	}
}
