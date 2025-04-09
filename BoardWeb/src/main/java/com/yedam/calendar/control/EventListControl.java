package com.yedam.calendar.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.calendar.service.EventService;
import com.yedam.calendar.service.EventServiceImpl;
import com.yedam.common.Control;

public class EventListControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		EventService esv = new EventServiceImpl();
		List<Map<String, Object>> list = esv.getEvent();
		if (!list.isEmpty()) {
			Gson gson = new GsonBuilder().create();
			resp.getWriter().print(gson.toJson(list));
		}
	}
}
