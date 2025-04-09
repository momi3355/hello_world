package com.yedam.calendar.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.calendar.CalendarVO;
import com.yedam.calendar.mapper.CalendarMapper;
import com.yedam.common.DataSource;

public class EventServiceImpl implements EventService {
	SqlSession sqlSession = DataSource.getInstence().openSession(true);
	CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
	
	@Override
	public boolean addEvent(CalendarVO cal) {
		return mapper.insertEvent(cal) > 0;
	}

	@Override
	public boolean removeEvent(CalendarVO cal) {
		return mapper.deleteEvent(cal) > 0;
	}

	@Override
	public List<Map<String, Object>> getEvent() {
		return mapper.selectEvent();
	}
	
	@Override
	public boolean existEvent(CalendarVO cal) {
		return !mapper.existEvent(cal).isEmpty();
	}
}
