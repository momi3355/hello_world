package com.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

//클라이언트 - 필터 - 서블릿.
//'boardList.do'
public class FilterOne implements Filter {
	public FilterOne() {
		System.out.println("FilterOne.construct()");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;

		// 요청페이지, 클라이언트 IP
		String ip = request.getRemoteHost();
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String reqPage = uri.substring(context.length());
		
		//맵에 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("page", reqPage); //요청한 페이지
		map.put("host", ip);     //접속중인 호스트
		
		//로그저장
		BoardService bsv = new BoardServiceImpl();
		if (!map.get("page").contains("images")) {
			bsv.logCreate(map);
		}
		
		if (ip.equals("192.168.0.38")) {
			//비난처 홈페이지.
			request.getRequestDispatcher("refuge.html").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
}
