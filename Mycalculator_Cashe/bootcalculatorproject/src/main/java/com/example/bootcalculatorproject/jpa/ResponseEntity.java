package com.example.bootcalculatorproject.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResponseEntity implements  Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ResponseEntity(){};
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String request;
		private String response;
		private String operation;
		private Long sqlTimestamp;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRequest() {
			return request;
		}
		public void setRequest(String request) {
			this.request = request;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public String getOperation() {
			return operation;
		}
		public void setOperation(String operation) {
			this.operation = operation;
		}
		public Long getSqlTimestamp() {
			return sqlTimestamp;
		}
		public void setSqlTimestamp(Long sqlTimestamp) {
			this.sqlTimestamp = sqlTimestamp;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ResponseEntity [id=");
			builder.append(id);
			builder.append(", request=");
			builder.append(request);
			builder.append(", response=");
			builder.append(response);
			builder.append(", operation=");
			builder.append(operation);
			builder.append(", sqlTimestamp=");
			builder.append(sqlTimestamp);
			builder.append("]");
			return builder.toString();
		}
		
		public ResponseEntity(Long id, String request, String response, String operation, Long sqlTimestamp) {
			super();
			this.id = id;
			this.request = request;
			this.response = response;
			this.operation = operation;
			this.sqlTimestamp = sqlTimestamp;
		}

	}

