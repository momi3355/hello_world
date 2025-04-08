package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 회원가입 화면. (GET) WEB-INF/views/signForm.jsp
		// 2. 회원가입 처리. (POST)
		if (req.getMethod().equalsIgnoreCase("GET")) { //회원가입 화면으로 이동
			req.getRequestDispatcher("common/signForm.tiles").forward(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) { //회원가입 처리
			HttpSession session = req.getSession();
			session.invalidate(); //일단 세션 제거
			
			//(파일업로드: images, DB등록)
			String saveDir = req.getServletContext().getRealPath("images"); //파일경로
			final int MAX_SIZE = 1024 << 10 * 5; //파일 최대크기(5 MB) 1024^2 * 5 와 같다.
			String enc = "UTF-8"; //파일 인코딩
			//com.oreilly.servlet.MultipartRequest.MultipartRequest (
			//	HttpServletRequest request,
			//	String saveDirectory, 
			//	int maxPostSize, 
			//	String encoding, 
			//	FileRenamePolicy policy
			//	) throws IOException
			//매개변수 : 1) 요청정보 2) 경로 3) 최대크기 4) 인코딩 5) 리네임정책
			MultipartRequest mr = new MultipartRequest(req,
										saveDir,
										MAX_SIZE,
										enc,
										new DefaultFileRenamePolicy()); //기본 이름정책

			String userId = mr.getParameter("userId");
			String userName = mr.getParameter("userName");
			String userPw = mr.getParameter("userPw");
			String userImg = mr.getFilesystemName("userImg");
			//파일이름이 같으면 파일명이 바뀌기 때문에 바뀐 파일명.
			//if (userImg == null)
			//	userImg = ""; //없으면 공백
			//mybatis-config.xml에서
			//<setting name="jdbcTypeForNull" value="true"/>를
			//해줬기 때문에 공백을 넣지 않아도 된다.
			
			MemberVO member = new MemberVO();
			member.setMemberId(userId);
			member.setMemberName(userName);
			member.setMemberPw(userPw);
			member.setImages(userImg);
			
			MemberService ms = new MemberServiceImpl();
			if (ms.addMember(member)) //정상적으로 입력이 되었으면
				resp.sendRedirect("boardList.do");
			else {
				System.out.println("처리오류");
			}
		}
	}
}
