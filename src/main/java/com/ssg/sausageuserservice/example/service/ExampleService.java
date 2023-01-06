package com.ssg.sausageuserservice.example.service;

import com.ssg.sausageuserservice.example.dto.request.ExampleRequest;
import com.ssg.sausageuserservice.example.dto.response.ExampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService {

    public ExampleResponse create(ExampleRequest request) {
        return ExampleResponse.of();
    }
}
