package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

@WebServlet("/addBoard")
public class AddBoardServ extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// addForm.jsp -> 3개값(title, writer, content)
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		//셰션(mybaits를 활용해서 JDBC 처리.)
		try(SqlSession sqlSession = DataSource.getInstence().openSession()) {
			//.openSession(true); // 하면 자동커밋
			
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			
			int r = mapper.insertBoard(board);
			
			sqlSession.commit(); //커밋
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().print(r + "건 처리.");
		}
	}
}
