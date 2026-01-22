package com.example.board;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository repo;

    public BoardService(BoardRepository repo) {
        this.repo = repo;
    }

    public List<board> findAll() {
        return repo.findAll();
    }

    public board save(board board) {
        return repo.save(board);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public board findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));
    }
}
