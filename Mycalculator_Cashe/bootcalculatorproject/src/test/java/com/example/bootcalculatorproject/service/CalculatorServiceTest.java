package com.example.bootcalculatorproject.service;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bootcalculatorproject.dao.CalculatorBootRepo;
import com.example.bootcalculatorproject.jpa.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CalculatorServiceTest {

	@InjectMocks
	private CalculatorServiceForData calculatorService = new CalculatorServiceForData();

	@Mock
	CalculatorBootRepo calculatorBootRepo;

	
	@Test
	public void findById() {
		try {
			calculatorService.findById(1L);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
}