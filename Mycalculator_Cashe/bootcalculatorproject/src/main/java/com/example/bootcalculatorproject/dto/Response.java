package com.example.bootcalculatorproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	
	@JsonProperty("answer")
	private Double answer;

	@JsonProperty("detail")
	private String detail;

	public Double getAnswer() {
		return answer;
	}

	public void setAnswer(Double answer) {
		this.answer = answer;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Response [answer=" + answer + ", detail=" + detail + "]";
	}
	
	
	

}
