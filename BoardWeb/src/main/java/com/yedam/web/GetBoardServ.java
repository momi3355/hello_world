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

// form태크(jsp) -> 서블릿.
// 서블릿 -> jsp
@WebServlet("/getBoard")
public class GetBoardServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//Parameter는 get방식이랑 같다.
		// http://localhost/BoardWeb/getBoard?board_no=1
		String content = "<html><h3>상세조회</h3>";
		try {
			int board_no = Integer.parseInt(req.getParameter("board_no")+"");
			
			SqlSession sqlSession = DataSource.getInstence().openSession();
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			BoardVO board = mapper.selectOne(board_no);
			content += "<table border='2'>";
			content += "<tr><th>글제목</th><td>"+board.getTitle()+"</td></tr>";
			content += "<tr><th>작성자</th><td>"+board.getWriter()+"</td></tr>";
			content += "<tr><th>본문</th><td>"+board.getContent()+"</td></tr>";
			content += "<tr><th>작성날짜</th><td>"+board.getWriteDate()+"</td></tr>";
			content += "</table>";
			//sqlSession.commit();
			sqlSession.close();
		} catch (NumberFormatException e) {
			content += "<p>숫자를 입력하지 않았습니다.</p>";
		}
		content += "<a href='mainservlet'>목록으로</a>";
		content += "</html>";
		
		resp.getWriter().print(content);
	}
}
