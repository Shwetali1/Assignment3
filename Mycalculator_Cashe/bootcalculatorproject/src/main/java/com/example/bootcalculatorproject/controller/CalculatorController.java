package com.example.bootcalculatorproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootcalculatorproject.dto.Response;
import com.example.bootcalculatorproject.jpa.ResponseEntity;
import com.example.bootcalculatorproject.service.CalculatorService;
import com.example.bootcalculatorproject.service.CalculatorServiceForData;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/calculatorapi/v1/")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;
	
	@Autowired
	private CalculatorServiceForData calculatorServiceForData;
	
	public enum Operation {
		ADDITION("addition"),
		SUBTRACTION("subtraction"),
		MULTIPLICATION("multiplication"),
		DIVISION("division"),SQUARE("square"),
		SQUARE_ROOT("squareroot"),
		FACTORIAL("factorial"),
		MIN_MAX("min-max");
		
		 private String name;
		 
	    Operation(String name) {
	    	this.name = name;
		}

	    public String getName() {
	        return name;
	    }
	}
	
	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping("/Addition")
	public Response getAddition(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Response response = new Response();
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity= calculatorServiceForData.findByRequest((num1.toString()) + " + " + (num2.toString()));
		Double result = calculatorService.getAddition(num1, num2);
		Long t = System.currentTimeMillis();
		Double add = 0.0;
		response.setAnswer(result);
		response.setDetail(num1.toString() + " + " + (num2.toString()) + " = " + (add.toString()));
		responseEntity = setDataInRepo((num1.toString()) + " + " + (num2.toString()), (add.toString()),
				Operation.ADDITION.getName(), t);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		log.error("<< logs of getAddition method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping("/Substraction")
	public Response getSubstraction(@RequestParam double number1, @RequestParam double number2) {
		Response response = new Response();
		ResponseEntity responseEntity = new ResponseEntity();
		Double result = calculatorService.getSubstraction(number1, number2);
		Long t = System.currentTimeMillis();
		Double subtract = 0.0;
		response.setAnswer(result);
		response.setDetail(number1 + "-" + number2 + "=" + result);
		responseEntity = setDataInRepo((number1 + " - " + number2 ), (subtract.toString()),
				Operation.SUBTRACTION.getName(), t);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		log.error("<< logs of getSubstraction method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping("/Multiplication")
	public Response getMultiplication(@RequestParam double number1, @RequestParam double number2) {
		Response response = new Response();
		ResponseEntity responseEntity = new ResponseEntity();
		Double result = calculatorService.getMultiplication(number1, number2);
		Long t = System.currentTimeMillis();
		Double multiplication = 0.0;
		response.setAnswer(result);
		response.setDetail(number1 + "*" + number2 + "=" + result);
		responseEntity = setDataInRepo((number1 + " * " + number2 ), (multiplication.toString()),
				Operation.MULTIPLICATION.getName(), t);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		log.error("<< logs of getMultiplication method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping("/Division")
	public Response getdivision(@RequestParam double number1, @RequestParam double number2) {
		Response response = new Response();
		ResponseEntity responseEntity = new ResponseEntity();
		Double result = calculatorService.getdivision(number1, number2);
		Long t = System.currentTimeMillis();
		Double division = 0.0;
		response.setAnswer(result);
		response.setDetail(number1 + "/" + number2 + "=" + result);
		responseEntity = setDataInRepo((number1 + " / " + number2 ), (division.toString()),
				Operation.DIVISION.getName(), t);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		log.error("<< logs of getdivision method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping("/square/{number}")
	public Response square(@PathVariable double number) {
		Response response = new Response();
		ResponseEntity responseEntity = new ResponseEntity();
		Long t = System.currentTimeMillis();
		Double square = 0.0;
		Double result = calculatorService.square(number);
		responseEntity = setDataInRepo((number + " Square of " ), (square.toString()),
				Operation.SQUARE.getName(), t);
		response.setAnswer(result);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		log.error("<< logs of square method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping("/squareroot/{number}")
	public Response squareRoot(@PathVariable double number) {
		Response response = new Response();
		ResponseEntity responseEntity = new ResponseEntity();
		Long t = System.currentTimeMillis();
		Double squareroot = 0.0;
		Double result = calculatorService.squareRoot(number);
		response.setAnswer(result);
		responseEntity = setDataInRepo((number + " Square root of " ), (squareroot.toString()),
				Operation.SQUARE_ROOT.getName(), t);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		
		log.error("<< logs of squareRoot method >>" + response.toString());
		return response;
	}

	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@GetMapping("/factorial/{number}")
	public Response factorial(@PathVariable int number) {
		Response response = new Response();
		ResponseEntity responseEntity = new ResponseEntity();
		Long t = System.currentTimeMillis();
		Double resul = 0.0;
		Double result = calculatorService.factorial(number);
		responseEntity = setDataInRepo((number + " ! " ), (resul.toString()),
				Operation.FACTORIAL.getName(), t);
		response.setAnswer(result);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		log.error("<< logs of factorial method >>" + response.toString());
		return response;
	}
	
	@Cacheable(value = "requestResponseEntity", cacheManager = "requestResponseEntityManager")
	@PostMapping("/min-max")
	public String minmax(@RequestBody List<Integer> numbers){
		ResponseEntity responseEntity = new ResponseEntity();
		Long t = System.currentTimeMillis();
		Double minmax = 0.0;
		String result = calculatorService.minmax(numbers);
		responseEntity = setDataInRepo((numbers + " minmax " ), (minmax.toString()),
				Operation.MIN_MAX.getName(), t);
		calculatorServiceForData.saveRequstResponse(responseEntity);
		log.error("<< logs of minmax method >>" + result.toString());
		return result;
	}
	
	private ResponseEntity setDataInRepo(String request, String response, String operation, Long sqlTimestamp) {
		ResponseEntity ResponseEntity = new ResponseEntity();
		ResponseEntity.setRequest(request);
		ResponseEntity.setResponse(response);
		ResponseEntity.setOperation(operation);
		ResponseEntity.setSqlTimestamp(sqlTimestamp);
		return ResponseEntity;
	}
}
