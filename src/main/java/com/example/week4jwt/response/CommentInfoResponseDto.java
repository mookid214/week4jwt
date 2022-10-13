package com.example.week4jwt.response;

import com.example.week4jwt.entity.Comment;
import com.example.week4jwt.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CommentInfoResponseDto {
    private Long id;
    private String writer;
    private String comment;
    private Test testId;

    public CommentInfoResponseDto(Comment comment) {
        this.id = comment.getId();
        this.writer = comment.getWriter();
        this.comment = comment.getComment();
        this.testId = comment.getTestId();
    }
}