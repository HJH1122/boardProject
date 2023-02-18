package kr.co.boardProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.boardProject.dto.CommentDto;
import kr.co.boardProject.service.CommentService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService commentService;
	
	@PostMapping("/save")
	public @ResponseBody List<CommentDto> save(@ModelAttribute CommentDto commentDto){
		commentService.save(commentDto);
		List<CommentDto> commentDtoList = commentService.findAll(commentDto.getBoardId());
		
		return commentDtoList;
		
	}

}
