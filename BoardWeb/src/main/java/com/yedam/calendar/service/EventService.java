package com.yedam.calendar.service;

import java.util.List;
import java.util.Map;

import com.yedam.calendar.CalendarVO;

public interface EventService {
	boolean addEvent(CalendarVO cal);
	boolean removeEvent(CalendarVO cal);
	boolean existEvent(CalendarVO cal);
	List<Map<String, Object>> getEvent();
}
