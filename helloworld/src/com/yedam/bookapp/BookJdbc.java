package com.yedam.bookapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * ojdbc 를 사용.
 */
public class BookJdbc {
	private static final String TABLE_NAME = "tbl_book";
	
	//Connection 생성.
	private Connection getConnect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		return DriverManager.getConnection(url, userId, userPw);
	}
	
	//추가
	public boolean insert(Book book) {
		String sql = "";
		Connection conn = null;
		try {
			conn = getConnect();
//			sql = "SELECT book_code"
//				+ "FROM   tbl"
//			int c = stmt.executeQuery(sql)

			//Statement stmt = conn.createStatement();
//			sql = "INSERT INTO "+TABLE_NAME+"(book_code, book_title, author, publisher, price)"
//				+ "       VALUES(book_seq.nextval, "
//						  + "'"+ book.getTitle()+"', "
//						  + "'"+ book.getAuthor()+"', "
//						  + "'"+ book.getPublisher()+"', "
//						       + book.getPrice()+")";
			//int r = stmt.executeUpdate(sql);
			
			sql = "INSERT INTO "+TABLE_NAME+"(book_code, book_title, author, publisher, price)"
				+ "       VALUES(book_seq.nextval, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getPublisher());
			stmt.setInt(4, book.getPrice());
			int r = stmt.executeUpdate();
			//문자열이기 때문에 '콤마 
			return r > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse(conn);
		}
		return false;
	}
	//수정
	public boolean update(String bookCode, Book book) {
		String sql = "";
		Connection conn = null;
		try {
			conn = getConnect();
			sql = "UPDATE "+TABLE_NAME
				+ "   SET book_title = nvl(?, book_title), "
					   + "author     = nvl(?, author), "
					   + "publisher  = nvl(?, publisher), "
					   + "price      = ? "
				+ "WHERE book_code   = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());
			psmt.setInt(4, book.getPrice());
			psmt.setString(5, bookCode);
			int r = psmt.executeUpdate();
			return r > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse(conn);
		}
		return false;
	}
	//삭제
	public boolean delete(String bookCode) {
		String sql = "";
		Connection conn = null;
		try {
			conn = getConnect();
			Statement stmt = conn.createStatement();
			sql = "DELETE FROM "+TABLE_NAME
				+ " WHERE  book_code = '"+bookCode+"'";
			int r = stmt.executeUpdate(sql);
			return r > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse(conn);
		}
		return false;
	}
	//목록
	public List<Book> list() {
		return list("");
	}
	public List<Book> list(String publisher) {
		List<Book> list = new ArrayList<>();
		String sql = "";
		Connection conn = null;
		try {
			conn = getConnect();
			sql = "SELECT book_code, book_title, author, publisher, price"
				+" FROM   "+TABLE_NAME
				+" WHERE publisher = nvl(?, publisher)"
				+" ORDER BY book_code";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, publisher);
			ResultSet rs = psmt.executeQuery(); //조회
			while (rs.next()) {
				Book book = new BookBuilder(rs.getString("book_title"))
						.setAuthor(rs.getString("author"))
						.setPublisher(rs.getString("publisher"))
						.setPrice(rs.getInt("price"))
						.setBookCode(rs.getString("book_code")).build();
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse(conn);
		}
		return list;
	}
	
	public Book select(String bookCode) {
		String sql = "";
		Connection conn = null;
		try {
			conn = getConnect();
			sql = "SELECT book_code, book_title, author, publisher, price"
				+" FROM   "+TABLE_NAME
				+" WHERE  book_code = ?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			ResultSet rs = psmt.executeQuery(); //조회
			if (rs.next()) { //하나만 있기 때문에 if 만 해도 된다.
				Book book = new BookBuilder(rs.getString("book_title"))
						.setAuthor(rs.getString("author"))
						.setPublisher(rs.getString("publisher"))
						.setPrice(rs.getInt("price")).build();
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse(conn);
		}
		return null;
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
