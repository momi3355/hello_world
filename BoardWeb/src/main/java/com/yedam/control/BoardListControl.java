package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boardList.do?page=1
		String page = req.getParameter("page");
		if (page == null) page = "1";
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		//if (kw == null) kw = "%";
		
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		search.setPage(Integer.parseInt(page));
		
		//글목록정보 -> jsp
		try (SqlSession sqlSession = DataSource.getInstence().openSession(true)) {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			List<BoardVO> list = mapper.selectBoard(search);
			req.setAttribute("blist", list); //요청정보의 '속성' 전달
			
			//페이징 계산.
			int totalCnt = mapper.selectTotal(search);
			PageDTO pageDTO = new PageDTO(totalCnt, search.getPage());
			req.setAttribute("paging", pageDTO); //페이지 정보
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			//boardList.do -> jsp 출력 : 페이지 재지정.
			sqlSession.close();
			//req.getRequestDispatcher("common/boardList.tiles").forward(req, resp);
			req.getRequestDispatcher("common/boardList2.tiles").forward(req, resp);
		}
	}
}
