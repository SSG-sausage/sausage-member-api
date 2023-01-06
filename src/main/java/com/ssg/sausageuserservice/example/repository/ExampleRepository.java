package com.ssg.sausageuserservice.example.repository;

import com.ssg.sausageuserservice.example.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Long>, ExampleRepositoryCustom {

}
