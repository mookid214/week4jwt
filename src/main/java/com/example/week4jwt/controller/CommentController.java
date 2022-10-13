package com.example.week4jwt.controller;

import com.example.week4jwt.dto.CommentRequestDto;
import com.example.week4jwt.dto.TestRequestDto;
import com.example.week4jwt.entity.Comment;
import com.example.week4jwt.entity.Test;
import com.example.week4jwt.response.CommentInfoResponseDto;
import com.example.week4jwt.response.CommonResponse;
import com.example.week4jwt.response.TestInfoResponseDto;
import com.example.week4jwt.service.CommentService;
import com.example.week4jwt.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/comment/{id}")
    public CommonResponse getComment(@PathVariable Long id) {
        CommentInfoResponseDto commentInfoResponseDto = commentService.getComment(id);
        return new CommonResponse(commentInfoResponseDto);
    }

    @PostMapping("/test/{id}/comment")
    public List<Comment> postComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id) {

        return commentService.postComment(requestDto, id);
    }
}