package com.yedam.control.form;

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

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		// bno = '15' 단건조회 후, modifyBoard.jsp로 이동.
		try (SqlSession sqlSession = DataSource.getInstence().openSession()) {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			BoardVO board = mapper.selectOne(Integer.parseInt(bno));
			sqlSession.close();
			
			req.setAttribute("board", board); //속성 전달
			req.setAttribute("page", page);
			//권한 체크.
			HttpSession session = req.getSession();
			String logId = (String)session.getAttribute("logId");
			if (logId != null && logId.equals(board.getWriter())) {
				req.getRequestDispatcher("common/modifyBoard.tiles").forward(req, resp);
			} else {
				req.setAttribute("msg", "다른사람의 글을 수정할 수 없습니다.");
				req.getRequestDispatcher("common/board.tiles").forward(req, resp);
			}
		}
	}

}
