package com.yedam.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//게시글 검색의 파라미터 선언.
@Getter
@Setter
@ToString
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
