package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 uname, psw
		String id = req.getParameter("uname");
		String pw = req.getParameter("psw");
		
		//서비스 객체를 통해서 처리.
		MemberService svc = new MemberServiceImpl();
		MemberVO mvo = svc.login(id, pw);
		if (mvo != null) {
			// 로그인 성공 => 성공한 로그인을 당신이.
			HttpSession session = req.getSession(); //톰캣세션을 가지고옴.
			//SQL세션과 다름. (SqlSession은 SQL(DB)에 접속하는 세션)
			session.setAttribute("logName", mvo.getMemberName()); //세션객체의 attr에 저장.
			session.setAttribute("logId", mvo.getMemberId()); //세션객체의 attr에 저장.
			session.setAttribute("responsibility", mvo.getResponsibility());
			if (mvo.getImages() != null) {
				session.setAttribute("img", mvo.getImages()); //이미지
			}
			
			// PHP
			//session_start();
			//$_SESSION["logId"] = id;
			if (mvo.getResponsibility().equalsIgnoreCase("user")) {
				resp.sendRedirect("boardList.do");
			} else if (mvo.getResponsibility().equalsIgnoreCase("admin")) {
				req.getRequestDispatcher("manager/main.tiles").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/views/loginForm.jsp").forward(req, resp);
		}
	}
}
