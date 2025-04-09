package com.yedam.control.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class MainControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String logId = (String)session.getAttribute("logId");
		
		if (logId == null) {
			resp.sendRedirect("common/loginForm.tiles"); //로그인하세요 깡!
		} else {
			resp.sendRedirect("common/main.tiles"); //환영합니다 낮선자여.
		}
	}
}
