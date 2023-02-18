package kr.co.boardProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.boardProject.dto.BoardDto;
import kr.co.boardProject.dto.CommentDto;
import kr.co.boardProject.dto.PageDto;
import kr.co.boardProject.service.BoardService;
import kr.co.boardProject.service.CommentService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	private final CommentService commentService;
	
	@GetMapping("/save")
	public String saveForm() {
		return "save";
	}

	
	@PostMapping("/save")
	public String save(@ModelAttribute BoardDto boardDto) {
		int saveResult = boardService.save(boardDto);
		
		if(saveResult > 0) {
			return "redirect:/board/paging";
		}
		else {
			return "save";
		}
		
	}
	
	@GetMapping("/")
	public String findAll(Model model) {
		List<BoardDto> boardDtoList = boardService.findAll();
		model.addAttribute("boardList", boardDtoList);
		return "list";
	}
	
	@GetMapping
	public String findById(@RequestParam("id") Long id, @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
		
		boardService.updateHits(id);
		
		BoardDto boardDto = boardService.findById(id);
		model.addAttribute("board", boardDto);
		model.addAttribute("page", page);
		
		List<CommentDto> commentDtoList = commentService.findAll(id);
        model.addAttribute("commentList", commentDtoList);
		
		return "detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		
		boardService.delete(id);
		
		return "redirect:/board/";
	}
	
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") Long id, Model model) {
		
		BoardDto boardDto = boardService.findById(id);
		model.addAttribute("board", boardDto);
		
		return "update";
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto boardDto, Model model) {
		
		boardService.update(boardDto);
		BoardDto dto = boardService.findById(boardDto.getId());
		model.addAttribute("board",dto);
		
		return "detail";
		
	}
	
	// /board/paging?page=2
	// 처음 페이지 요청은 1페이지를 보여줌
	@GetMapping("/paging")
	public String paging(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		
		System.out.println("page=" + page);
		//해당 페이지에서 보여줄 글 목록
		List<BoardDto> pagingList = boardService.pagingList(page);
		System.out.println("pagingList=" + pagingList);
		PageDto pageDto = boardService.pagingParam(page);
		model.addAttribute("boardList",pagingList);
		model.addAttribute("paging",pageDto);
		
		return "paging";
	}
	
	
	
	
}
