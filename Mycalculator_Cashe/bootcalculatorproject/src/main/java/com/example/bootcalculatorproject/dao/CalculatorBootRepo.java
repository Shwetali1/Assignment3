package com.example.bootcalculatorproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bootcalculatorproject.jpa.ResponseEntity;


	@Repository
	public interface CalculatorBootRepo extends JpaRepository<ResponseEntity, Long> {
		public List<ResponseEntity> findByRequest(String request);
	}


