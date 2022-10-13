package com.example.week4jwt.response;

import com.example.week4jwt.entity.Comment;
import com.example.week4jwt.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TestInfoResponseDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private String password;
    private List<Comment> commentList;

    public TestInfoResponseDto(Test test) {
        this.id = test.getId();
        this.title = test.getTitle();
        this.writer = test.getWriter();
        this.content = test.getContent();
        this.password = test.getPassword();
        this.commentList = test.getCommentList();
    }
}
