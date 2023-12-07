package com.example.bootcalculatorproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bootcalculatorproject.jpa.ResponseEntity;

@Service
public class CalculatorService {
	
	String response;
	double Result;
	String answer = "answer : ";
	String detail = "detail : ";
	
	@GetMapping("/Addition")
	public Double getAddition(@RequestParam double number1, @RequestParam double number2) {
		Result = number1 + number2;
		return Result;
	}
	
	@GetMapping("/Substraction")
	public Double getSubstraction(@RequestParam double number1, @RequestParam double number2) {
		Result = number1 - number2;
		return Result;
	}
	
	@GetMapping("/Multiplication")
	public Double getMultiplication(@RequestParam double number1, @RequestParam double number2) {
		Result = number1 * number2;
		return Result;
	}
	
	@GetMapping("/Division")
	public Double getdivision(@RequestParam double number1, @RequestParam double number2) {
		Result = number1 / number2;
		return Result;
	}
	
	@GetMapping("/square/{number}")
	public Double square(@PathVariable double number) {
		Result = number * number;
		return Result;
	}
	
	@GetMapping("/squareroot/{number}")
	public Double squareRoot(@PathVariable double number) {
		Result =Math.sqrt(number);
		return Result;
	}
	
	
	@GetMapping("/factorial/{number}")
	public Double factorial(@PathVariable int number) {

		Result = 1;

		for (int i = 1; i <= number; i++) {
			Result *= i;
		}

		return Result;
	}
	
	@PostMapping("/min-max")
	public String minmax(@RequestBody List<Integer> numbers) {

		int minNum = numbers.get(0);
		int maxNum = numbers.get(0);
		int i;

		for (i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) > maxNum) {
				maxNum = numbers.get(i);
			}
			if (numbers.get(i) < minNum) {
				minNum = numbers.get(i);
			}
		}

		
		return "min"+":"+minNum+" "+"max :"+maxNum;
	}

	



}
