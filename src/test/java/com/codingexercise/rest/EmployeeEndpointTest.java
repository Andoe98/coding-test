package com.codingexercise.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.codingexercise.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class EmployeeEndpointTest {
	
	private MockMvc mockMvc;
	private String endpoint = "/employee/payslip";
	private ObjectMapper mapper = new ObjectMapper();
	private Employee employee = new Employee (	
			"Monica",
			"Tan",
			60050,
			2,
			0.09
		);
	
	@Test
	void testPaySlips() throws Exception {
		//TODO: amend test for JSON request array
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = ow.writeValueAsString(employee);
	    
	    mockMvc.perform(post(endpoint).contentType(MediaType.APPLICATION_JSON)
	    		.content(requestJson))
	    		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    		.andExpect(jsonPath("$.data.employee", is(employee)))
	            .andExpect(jsonPath("$.data.fromDate", is("01 March")))
	            .andExpect(jsonPath("$.data.toDate", is("31 March")))
	            .andExpect(jsonPath("$.data.grossIncome", is(5004)))
	            .andExpect(jsonPath("$.data.incomeTax", is(922)))
	            .andExpect(jsonPath("$.data.superannuation", is(450)))
	            .andExpect(jsonPath("$.data.netIncome", is(4082)));
	}
	
}
