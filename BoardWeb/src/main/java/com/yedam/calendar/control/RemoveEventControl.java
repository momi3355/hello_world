package com.yedam.calendar.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.calendar.CalendarDate;
import com.yedam.calendar.CalendarVO;
import com.yedam.calendar.service.EventService;
import com.yedam.calendar.service.EventServiceImpl;
import com.yedam.common.Control;

public class RemoveEventControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		SimpleDateFormat sd = CalendarDate.simpleDate;
		SimpleDateFormat dd = CalendarDate.defaultDate;
		String title = req.getParameter("title");
		
		try {
			String startDate = sd.format(dd.parse(req.getParameter("start")
					.replace(" (한국 표준시)", "")
					.replace("GMT ", "GMT+")));
			String endDate = sd.format(dd.parse(req.getParameter("end")
					.replace(" (한국 표준시)", "")
					.replace("GMT ", "GMT+")));
		
			CalendarVO cvo = new CalendarVO();
			cvo.setTitle(title);
			cvo.setStartDate(startDate);
			cvo.setEndDate(endDate);

			Map<String, Object> map = new HashMap<String, Object>();
			EventService esv = new EventServiceImpl();
			if (esv.removeEvent(cvo)) {
				map.put("retCode", "OK");
			} else {
				map.put("retCode", "NG");
			}
			Gson gson = new GsonBuilder().create();
			resp.getWriter().print(gson.toJson(map));
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
