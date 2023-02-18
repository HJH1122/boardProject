package kr.co.boardProject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDto {
	private int page;  //현재 페이지
	
	private int maxPage; // 전체 필요한 페이지 갯수
	
	private int startPage; // 현재 페이지 기준 시작페이지 값
	
	private int endPage; // 현재 페이지 기준 마지막페이지 값

}
