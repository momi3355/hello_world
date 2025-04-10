package com.yedam.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map<String, Object>> cntPerWriter();
	void logCreate(Map<String, String> map);
}
