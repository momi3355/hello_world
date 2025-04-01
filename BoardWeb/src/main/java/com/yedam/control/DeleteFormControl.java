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
			req.getRequestDispatcher("/WEB-INF/views/deleteBoard.jsp").forward(req, resp);
		}
	}

}
