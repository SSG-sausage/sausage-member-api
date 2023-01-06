package com.ssg.sausageuserservice.example.repository;

import com.ssg.sausageuserservice.example.entity.Example;

public interface ExampleRepositoryCustom {

    Example findExampleById(Long id);
}
