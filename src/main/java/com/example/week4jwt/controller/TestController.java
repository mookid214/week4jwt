package com.example.week4jwt.controller;


import com.example.week4jwt.dto.TestRequestDto;
import com.example.week4jwt.entity.Test;
import com.example.week4jwt.response.CommonResponse;
import com.example.week4jwt.response.TestInfoResponseDto;
import com.example.week4jwt.service.TestService;
import com.example.week4jwt.service.UserService;
import com.example.week4jwt.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;


    @GetMapping("/test")
    public CommonResponse.ofList getTest() {
        List<TestInfoResponseDto> testInfoResponseDtoList = testService.getTest();
        return new CommonResponse.ofList(testInfoResponseDtoList);
    }

    @GetMapping("/test/{id}")
    public CommonResponse getTest(@PathVariable Long id) {
        TestInfoResponseDto testInfoResponseDto = testService.getTest(id);
        return new CommonResponse(testInfoResponseDto);
    }

    @GetMapping("/test/desc")
    public List<Test> getTestDesc() {
        return testService.getTestDesc();
    }

    @PostMapping("/test")
    public List<Test> postTest(@RequestBody TestRequestDto requestDto) {

        return testService.postTest(requestDto);
    }

    @PutMapping("/test/{id}")
    public List<Test> putTest(@PathVariable Long id,
                              @RequestBody TestRequestDto requestDto){
        return testService.putTest(id, requestDto);
    }

    @PutMapping("/test/{id}/{password}")
    public List<Test> putTest(@PathVariable Long id,
                              @PathVariable String password ,
                              @RequestBody TestRequestDto requestDto){
        return testService.putTest(id, password ,requestDto);
    }

    @DeleteMapping("/test/{id}")
    public List<Test> deleteTest(@PathVariable Long id)  {
        return testService.deleteTest(id);
    }

}
