package com.yedam.calendar.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.calendar.CalendarVO;
import com.yedam.calendar.service.EventService;
import com.yedam.calendar.service.EventServiceImpl;
import com.yedam.common.Control;

public class ExistEventControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		CalendarVO cvo = new CalendarVO();
		cvo.setTitle(title);
		cvo.setStartDate(start);
		cvo.setEndDate(end);

		Map<String, Object> map = new HashMap<String, Object>();
		EventService esv = new EventServiceImpl();
		if (esv.existEvent(cvo)) {
			map.put("retCode", "exist");
		} else {
			map.put("retCode", "no");
		}
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(map));
	}
}
