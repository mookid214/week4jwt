package com.example.week4jwt.entity;


import com.example.week4jwt.dto.TestRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Test extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column
    private String title;
    @Column
    private String writer;
    @Column
    private String content;
    @Column
    private String password;

    @OneToMany(mappedBy="testId")
    private List<Comment> commentList;

    public void update(TestRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
