package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    // 게시글 목록 화면
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("boards", service.findAll());
        return "list";
    }

    // 새 글 작성 폼
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("board", new board());
        return "form";
    }

    // 게시글 등록
    @PostMapping("/save")
    public String save(board board) {
        service.save(board);
        return "redirect:/";
    }

    // 게시글 삭제
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }

    // 게시글 수정 폼
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        board board = service.findById(id);
        model.addAttribute("board", board);
        return "form";
    }

    // 게시글 수정
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, board updatedBoard) {
    // updatedBoard.setId(id);
        service.save(updatedBoard);
        return "redirect:/";
    }
}
