package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. ojdbc 데이터베이스 연결, 쿼리, 실행결과.
 * 2. Connection 객체(db session)를 통해서 작업.
 * 3. Statement(PrepardStatement) 쿼리실행.
 * 4. ResultSet(조회 결과), int(입력, 수정, 삭제)
 */
public class DaoExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		String sql = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno "
				   + "FROM   emp "
				   + "ORDER BY empno";
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			System.out.println("성공적으로 연결했습니다.");
			
			Statement stmt = conn.createStatement();
			//자동으로 커밋 설정
			conn.setAutoCommit(false);
			
//			int r = stmt.executeUpdate("DELETE FROM emp WHERE empno = 9999");
//			if (r > 0) {
//				System.out.println("삭제 성공.");
//				conn.commit();
//			}
			ResultSet rs = stmt.executeQuery(sql); //쿼리작성 -> 실행
			
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+", "+rs.getString("ename")+", "+rs.getString("job"));
			}
			System.out.println("-- end of data --");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("데이터베이스 연결에 실패했습니다.");
		}
	}
}
