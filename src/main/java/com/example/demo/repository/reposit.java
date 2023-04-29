package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.model;

public interface reposit extends JpaRepository<model, Integer> {
	model findByuname(String name);
}
