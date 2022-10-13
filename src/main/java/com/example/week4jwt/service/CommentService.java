package com.example.week4jwt.service;

import com.example.week4jwt.dto.CommentRequestDto;
import com.example.week4jwt.entity.Comment;
import com.example.week4jwt.entity.Test;
import com.example.week4jwt.entity.exception.DBEmptyDataException;
import com.example.week4jwt.repository.CommentRepository;
import com.example.week4jwt.repository.TestRepository;
import com.example.week4jwt.response.CommentInfoResponseDto;
import com.example.week4jwt.response.TestInfoResponseDto;
import com.example.week4jwt.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TestRepository testRepository;


    public CommentInfoResponseDto getComment(Long id) {
        Comment getComment = commentRepository.findById(id).orElseThrow(() -> {
            throw new DBEmptyDataException("아이디에 해당하는 댓글이 없습니다.");
        });

        return new CommentInfoResponseDto(getComment);
    }

    public List<Comment> postComment(CommentRequestDto requestDto, Long id) {
        Test test = testRepository.findById(id).orElseThrow(() -> {
            throw new DBEmptyDataException("존재하지 않는 게시글입니다.");
        });
        Comment comment = new Comment(requestDto.getComment(), SecurityUtil.getCurrentUsername().get(), test);
        commentRepository.save(comment);
        return commentRepository.findAll();

    }

}