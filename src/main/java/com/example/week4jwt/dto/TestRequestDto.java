package com.example.week4jwt.dto;

import com.example.week4jwt.entity.Test;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class TestRequestDto {

    private String title;
    private String writer;
    private String content;
    private String password;

    public TestRequestDto(Test test) {
        this.title = test.getTitle();
        this.writer = test.getWriter();
        this.content = test.getContent();
        this.password = test.getPassword();
    }
}
