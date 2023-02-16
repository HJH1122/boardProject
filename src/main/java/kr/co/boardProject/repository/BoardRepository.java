package kr.co.boardProject.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.boardProject.dto.BoardDto;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

	private final SqlSessionTemplate sql;
	
	public int save(BoardDto boardDto) {
		
		return sql.insert("Board.save", boardDto);
	}

	public List<BoardDto> findAll() {
		
		return sql.selectList("Board.findAll");
	}

	public BoardDto findById(Long id) {
		
		return sql.selectOne("Board.findById", id);
	}

	public void updateHits(Long id) {
		
		sql.update("Board.updateHits", id);
		
	}

	public void delete(Long id) {
		
		sql.delete("Board.delete", id);
		
	}

	public void update(BoardDto boardDto) {
		
		sql.update("Board.update",boardDto);
		
	}

	
}
