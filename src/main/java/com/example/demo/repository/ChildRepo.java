package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ChildModel;

public interface ChildRepo extends JpaRepository<ChildModel, Integer> {

	
}
