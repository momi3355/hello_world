package com.yedam.calendar.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.calendar.CalendarVO;

public interface CalendarMapper {
	int insertEvent(CalendarVO cal);
	int deleteEvent(CalendarVO cal);
	List<CalendarVO> existEvent(CalendarVO cal);
	List<Map<String, Object>> selectEvent();
}
