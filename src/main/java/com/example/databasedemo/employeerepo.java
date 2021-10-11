package com.example.databasedemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface employeerepo extends JpaRepository<employees , Long> {

}
