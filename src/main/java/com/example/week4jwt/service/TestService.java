package com.example.week4jwt.service;


import com.example.week4jwt.dto.TestRequestDto;
import com.example.week4jwt.entity.Test;
import com.example.week4jwt.entity.exception.DBEmptyDataException;
import com.example.week4jwt.repository.TestRepository;
import com.example.week4jwt.response.TestInfoResponseDto;
import com.example.week4jwt.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;



    public List<TestInfoResponseDto> getTest() {
        try {
            List<Test> testList = testRepository.findAll();

            List<TestInfoResponseDto> testInfoResponseDtoList = testList.stream()
                    .map(TestInfoResponseDto::new).collect(
                            Collectors.toList());
            return testInfoResponseDtoList;
        } catch (Exception e) {
            throw new DBEmptyDataException("회원 목록 조회 실패");
        }
    }

    public TestInfoResponseDto getTest(Long id) {
        Test test = testRepository.findById(id).orElseThrow(() -> {
            throw new DBEmptyDataException("회원 상세 조회 실패");
        });
        TestInfoResponseDto testInfoResponseDto = new TestInfoResponseDto(test);
        return testInfoResponseDto;
    }


    public List<Test> getTestDesc() {
        return testRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Test> postTest(TestRequestDto requestDto) {
        Test test = new Test();
        requestDto.setWriter(SecurityUtil.getCurrentUsername().get());
        test.update(requestDto);
        testRepository.save(test);
        return testRepository.findAll();

    }


    public List<Test> putTest(Long id, TestRequestDto requestDto) {
        Test test = testRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );

        return testRepository.findAll();
    }

    @Transactional
    public List<Test> putTest(Long id,String password , TestRequestDto requestDto) {
        Test test = testRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if(!test.getPassword().equals(password)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
        if(!test.getWriter().equals(SecurityUtil.getCurrentUsername().get())){
            throw new IllegalArgumentException("계정이 일치하지 않습니다.");
        }
        test.update(requestDto);
        return testRepository.findAll();
    }

    public List<Test> deleteTest(Long id) {
        Test test = testRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if(!test.getWriter().equals(SecurityUtil.getCurrentUsername().get())){
            throw new IllegalArgumentException("계정이 일치하지 않습니다.");
        }
        testRepository.deleteById(id);
        return testRepository.findAll();
    }

}
