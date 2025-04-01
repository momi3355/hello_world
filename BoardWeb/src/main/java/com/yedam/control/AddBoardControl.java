package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//url에 직접 입력, 링크 => get방식요청.
		if (req.getMethod().equals("GET"))
			// 요청 재지정.
			req.getRequestDispatcher("/WEB-INF/views/addForm.jsp").forward(req, resp);
		else if (req.getMethod().equals("POST")) { // post
			req.setCharacterEncoding("utf-8");
			//등록.
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			//셰션(mybaits를 활용해서 JDBC 처리.)
			try(SqlSession sqlSession = DataSource.getInstence().openSession()) {
				//.openSession(true); // 하면 자동커밋
				//System.out.println(req.get);
				BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
				BoardVO board = new BoardVO();
				//board.setTitle(title);
				//board.setWriter(writer+"("+req.getRemoteAddr()+")");
				board.setWriter(writer);
				board.setContent(content);
				int r = mapper.insertBoard(board);
				sqlSession.commit(); //커밋
				sqlSession.close();
				if (r > 0) {
					resp.sendRedirect("boardList.do"); //요청재지정.
					//매개변수 없을 때 사용.
				} else {
					System.out.println("에러발생");
				}
			} catch (Exception e) {
				System.out.println("에러발생");
			}
			
		}
	}
}
