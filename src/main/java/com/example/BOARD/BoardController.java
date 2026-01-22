package com.example.board;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 전체 게시글 조회
    @GetMapping
    public List<Board> getBoards() {
        return boardService.findAll();
    }

    // 새 게시글 등록
    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.save(board);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteById(id);
    }
}
