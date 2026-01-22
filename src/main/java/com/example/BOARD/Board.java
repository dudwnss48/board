package com.example.board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // 기본 생성자
    public board() {}

    // 생성자, getter, setter 생략 (IDE 자동 생성 가능)
    // 아래 예시로 간단히
    public board(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
