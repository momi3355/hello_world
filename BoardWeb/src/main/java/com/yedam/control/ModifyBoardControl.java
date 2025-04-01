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

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// bno=15&title=바뀐값&content=바뀐값... 수정 후 'BoardList.jsp'로 이동.
		try (SqlSession sqlSession = DataSource.getInstence().openSession()) {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			//수정할 값 저장.
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			int r = mapper.updateBoard(board);
			
			sqlSession.commit();
			sqlSession.close();
			if (r > 0) {
				resp.sendRedirect("boardList.do?page="+page); //요청재지정.
			} else {
				System.out.println("수정오류");
			}
		}
	}

}
