package kr.co.boardProject.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.boardProject.dto.CommentDto;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class CommentRepository {

	private final SqlSessionTemplate sql;
	
	public void save(CommentDto commentDto) {
		
		sql.insert("Comment.save", commentDto);
		
	}

	public List<CommentDto> findAll(Long boardId) {
		
		return sql.selectList("Comment.findAll", boardId);
	}

}
