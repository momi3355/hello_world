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
import com.yedam.mapper.MemberMapper;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class AddBoardControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//url에 직접 입력, 링크 => get방식요청.
		if (req.getMethod().equals("GET"))
			// 요청 재지정.
			req.getRequestDispatcher("common/addForm.tiles").forward(req, resp);
		else if (req.getMethod().equals("POST")) { // post
			req.setCharacterEncoding("utf-8");
			HttpSession session = req.getSession();
			//등록.
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			String logId = (String)session.getAttribute("logId");
			
			//셰션(mybaits를 활용해서 JDBC 처리.)
			try(SqlSession sqlSession = DataSource.getInstence().openSession()) {
				//.openSession(true); // 하면 자동커밋
				//System.out.println(req.get);
				BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
				String address = req.getRemoteAddr();
				if (address.equals("0:0:0:0:0:0:0:1")) {
					address = "localHost";
				}
				
				BoardVO board = new BoardVO();
				board.setTitle(title);
				board.setContent(content+"\n("+address+")");
				
				if (logId == null) { //익명확인
					board.setWriter("ㅇㅇ");
				} else {
					//회원이 있는지 확인
					MemberService ms = new MemberServiceImpl();
					if (ms.isMember(logId))
						board.setWriter(logId);
					else board.setWriter("ㅇㅇ");
				}
				int r = mapper.insertBoard(board);
				sqlSession.commit(); //커밋
				sqlSession.close();
				if (r > 0) {
					resp.sendRedirect("boardList.do"); //요청재지정.
					//매개변수 없을 때 사용.
				} else {
					System.out.println("에러발생:r = 0");
				}
			} catch (Exception e) {
				System.out.println("에러발생");
				e.printStackTrace();
			}
			
		}
	}
}
