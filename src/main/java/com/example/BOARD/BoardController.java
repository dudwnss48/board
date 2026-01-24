package com.example.BOARD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 🔹 글 목록 페이지
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "list";
    }

    // 새 글 작성 폼을 보여주는 메서드
    @GetMapping("/new")
    public String newBoard(Model model) {
        model.addAttribute("board", new Board());
        return "new"; // Thymeleaf 템플릿 이름 (HTML 파일명)
    }

    // 글 저장 처리 메서드
    @PostMapping("/save")
    public String saveBoard(@ModelAttribute Board board) {
        System.out.println(board.getTitle());
        boardService.saveBoard(board);
        return "redirect:/"; // 저장 후 목록으로 리다이렉트
    }
}