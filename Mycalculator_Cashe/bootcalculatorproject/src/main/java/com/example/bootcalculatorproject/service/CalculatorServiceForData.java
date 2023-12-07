package com.example.bootcalculatorproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootcalculatorproject.dao.CalculatorBootRepo;
import com.example.bootcalculatorproject.jpa.ResponseEntity;

@Service
public class CalculatorServiceForData {
	@Autowired
	CalculatorBootRepo calculatorBootRepo;

	public void saveRequstResponse(ResponseEntity responseEntity) {
		calculatorBootRepo.save(responseEntity);
	}

	public ResponseEntity findById(Long id) {
		return calculatorBootRepo.findById(id).get();
	}

	public ResponseEntity findByRequest(String request) {
		List<ResponseEntity> responseEntityList = calculatorBootRepo.findByRequest(request);
		if (!responseEntityList.isEmpty())
			return responseEntityList.get(0);
		else
			return null;
	}

}
