package com.yedam.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;

public class DTTast {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstence().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		List<Map<String, Object>> list = mapper.selectListForDT(100);
		List<Collection<Object>> dataTable = new ArrayList<Collection<Object>>();
//		for (int i = 0; i < list.size(); i++) {
//			dataTable.add(list.get(i).values());
//		}
		for (int i = 0; i < list.size(); i++) {
			List<Object> ilist = new ArrayList<Object>();
			ilist.add(list.get(i).get("REPLY_NO"));
			ilist.add(list.get(i).get("REPLY"));
			ilist.add(list.get(i).get("REPLYER"));
			dataTable.add(ilist);
		}
		
		// { "data": [ [], [], [], ... ] }
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", dataTable);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		
		System.out.println(json);
	}
}
