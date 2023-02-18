package kr.co.boardProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.boardProject.dto.CommentDto;
import kr.co.boardProject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	
	public void save(CommentDto commentDto) {
		commentRepository.save(commentDto);
	}

	public List<CommentDto> findAll(Long boardId) {
		
		
		return commentRepository.findAll(boardId);
	}

}
