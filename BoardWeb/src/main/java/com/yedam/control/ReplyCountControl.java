package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class ReplyCountControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		//계시글 번호에 대한 댓글 수 를 반환.
		String bno = req.getParameter("bno");
		
		//건수.
		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.getTotalCnt(Integer.parseInt(bno));
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("totalCnt", cnt);
		
		Gson gson = new GsonBuilder().create();
		// { "totalCnt": 25 };
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
	}
}
