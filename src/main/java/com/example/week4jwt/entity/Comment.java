package com.example.week4jwt.entity;


import com.example.week4jwt.dto.CommentRequestDto;
import com.example.week4jwt.dto.TestRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String writer;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Test testId;

    public Comment(String comment, String writer, Test testId) {
        this.comment = comment;
        this.writer = writer;
        this.testId = testId;
    }

    public void update(CommentRequestDto requestDto, Test testId) {
        this.comment = requestDto.getComment();
        this.testId = testId;
    }

}
