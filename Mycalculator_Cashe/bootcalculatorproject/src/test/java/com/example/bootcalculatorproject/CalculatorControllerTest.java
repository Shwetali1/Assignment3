package com.example.bootcalculatorproject;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.bootcalculatorproject.controller.CalculatorController;
import com.example.bootcalculatorproject.service.CalculatorService;

@SpringBootTest
public class CalculatorControllerTest {
	
	@InjectMocks
	private CalculatorController cal= new CalculatorController();
	
	@Mock
	CalculatorService calculatorService;
	
	@Test
	public void getAddition() throws IOException {
		assertNotNull(cal.getAddition(33.33, 7.0));
	}
	
	@Test
	public void getSubtraction() throws IOException {
		assertNotNull(cal.getSubstraction(33.33, 7.0));
	}

	@Test
	public void getMultiplication() throws IOException {
		assertNotNull(cal.getMultiplication(3.0, 7.0));
	}

	@Test
	public void getDivision() throws IOException {
		assertNotNull(cal.getdivision(15.0, 3.0));
	}

	@Test
	public void getSquare() throws IOException {
		assertNotNull(cal.square(4.0));
	}

	@Test
	public void getSquareRoot() throws IOException {
		assertNotNull(cal.squareRoot(144.0));
	}

	@Test
	public void getFactorial() throws IOException {
		assertNotNull(cal.factorial(5));
	}
	
	

}
