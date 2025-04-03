package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		try (SqlSession sqlSession = DataSource.getInstence().openSession(true)) {
			//Attribute
			// 1. session, context 저장가능
			// 2. String, Object, Array 다양한 데이터 입력가능
			// 3. setter, getter 둘다 존재
			//Parameter
			// 1. request 에만 저장가능
			// 2. String 만 사용가능
			// 3. setter 는 없고, getter 만 존재
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			BoardVO board = mapper.selectOne(Integer.parseInt(bno));
			req.setAttribute("board", board); //요청정보의 '속성' 전달
			req.setAttribute("page", page);
			//boardList.do -> jsp 출력 : 페이지 재지정.(요청 재지정)
			req.getRequestDispatcher("common/board.tiles").forward(req, resp);
			
			sqlSession.close();
		}
	}
}
