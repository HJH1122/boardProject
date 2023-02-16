package kr.co.boardProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.boardProject.dto.BoardDto;
import kr.co.boardProject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;

	public int save(BoardDto boardDto) {
		
		
		return boardRepository.save(boardDto);
	}

	public List<BoardDto> findAll() {
		
		return boardRepository.findAll();
	}

	public BoardDto findById(Long id) {
		
		return boardRepository.findById(id);
	}

	public void updateHits(Long id) {
		boardRepository.updateHits(id);
		
	}

	public void delete(Long id) {
		boardRepository.delete(id);
		
	}

	public void update(BoardDto boardDto) {
		boardRepository.update(boardDto);
		
	}

}
