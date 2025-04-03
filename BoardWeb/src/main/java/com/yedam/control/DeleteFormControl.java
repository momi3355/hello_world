package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class DeleteFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		// 삭제화면(deleteForm.jsp) 상세정보 + '삭제'하시겠습니까?
		try (SqlSession sqlSession = DataSource.getInstence().openSession()) {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			BoardVO board = mapper.selectOne(Integer.parseInt(bno));
			sqlSession.close();
			
			req.setAttribute("page", page);
			req.setAttribute("board", board);
			//권한 체크.
			HttpSession session = req.getSession();
			String logId = (String)session.getAttribute("logId");
			if (logId != null && logId.equals(board.getWriter())) {
				req.getRequestDispatcher("common/deleteBoard.tiles").forward(req, resp);
			} else {
				req.setAttribute("msg", "다른사람의 글을 삭제할 수 없습니다.");
				req.getRequestDispatcher("board.do").forward(req, resp);
			}
		}
	}

}
