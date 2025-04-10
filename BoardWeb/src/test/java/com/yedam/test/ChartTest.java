package com.yedam.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;


public class ChartTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstence().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		List<Map<String, Object>> list = mapper.selectWriter();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		System.out.println(json);
	}
}
