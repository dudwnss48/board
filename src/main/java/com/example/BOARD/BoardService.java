package com.example.BOARD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

import java.time.LocalDateTime;

@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 새 글 저장
    public void saveBoard(Board board) {
        board.setCreatedAt(LocalDateTime.now());// 작성일 자동 입력
        boardRepository.save(board);
    }

    // 🔹 글 목록 조회
    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}