package com.example.databasedemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface projectsrepo extends JpaRepository<projects,Long> {

    List<projects> findByPM(String projectmanager);

}
