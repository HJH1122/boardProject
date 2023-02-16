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
import kr.co.boardProject.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/save")
	public String saveForm() {
		return "save";
	}

	
	@PostMapping("/save")
	public String save(@ModelAttribute BoardDto boardDto) {
		int saveResult = boardService.save(boardDto);
		
		if(saveResult > 0) {
			return "redirect:/board/";
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
	public String findById(@RequestParam("id") Long id, Model model) {
		
		boardService.updateHits(id);
		
		BoardDto boardDto = boardService.findById(id);
		model.addAttribute("board", boardDto);
		
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
	
	
	
}
