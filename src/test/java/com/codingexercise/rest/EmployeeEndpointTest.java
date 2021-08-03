package com.codingexercise.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.codingexercise.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeEndpointTest {
	
	@Autowired
	private MockMvc mockMvc;
	private String endpoint = "/employee/payslip";
	private ObjectMapper mapper = new ObjectMapper();
	private static List<Employee> employees = new ArrayList<>();
	
	@BeforeAll
	static void beforeAll() {
		employees.add(
			new Employee (	
				"Monica",
				"Tan",
				60050,
				2,
				0.09
			)
		);
		employees.add(
			new Employee (	
				"Brend",
				"Tulu",
				120000,
				1,
				0.1
			)
		);
	}
	
	@Test
	void testPaySlips() throws Exception {
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = ow.writeValueAsString(employees);
	    
	    mockMvc.perform(post(endpoint).contentType(MediaType.APPLICATION_JSON)
	    		.content(requestJson))
	    		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    		.andExpect(jsonPath("$.data[0].employee", notNullValue()))
	            .andExpect(jsonPath("$.data[0].fromDate", is("01 March")))
	            .andExpect(jsonPath("$.data[0].toDate", is("31 March")))
	            .andExpect(jsonPath("$.data[0].grossIncome", is(5004)))
	            .andExpect(jsonPath("$.data[0].incomeTax", is(922)))
	            .andExpect(jsonPath("$.data[0].superannuation", is(450)))
	            .andExpect(jsonPath("$.data[0].netIncome", is(4082)))
	            .andExpect(jsonPath("$.data[1].employee", notNullValue()))
	            .andExpect(jsonPath("$.data[1].fromDate", is("01 February")))
	            .andExpect(jsonPath("$.data[1].toDate", is("28 February")))
	            .andExpect(jsonPath("$.data[1].grossIncome", is(10000)))
	            .andExpect(jsonPath("$.data[1].incomeTax", is(2669)))
	            .andExpect(jsonPath("$.data[1].superannuation", is(1000)))
	            .andExpect(jsonPath("$.data[1].netIncome", is(7331)));	    
	    
	}
	
}
