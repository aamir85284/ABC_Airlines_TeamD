package com.myapp.spring.bp;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.AbcAirlinesTeamDApplicationTests;
import com.myapp.spring.ServletInitializer;
import com.myapp.spring.model.Boarding;
import com.myapp.spring.repository.BoardingRepository;
import com.myapp.spring.repository.BoardingRepositoryImpl;

@SpringBootTest

@AutoConfigureMockMvc
public class BoardingTest extends AbcAirlinesTeamDApplicationTests {

	@MockBean
	private BoardingRepository service;

	@Autowired
	private MockMvc mockMvc;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Boarding.json").toFile();

	Boarding flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, Boarding[].class);

	}

	@Test

	public void testGetFlightById() throws Exception {

		Boarding mockFlight = new Boarding();
		mockFlight.setflightid(1);
		mockFlight.setpassengername("Pooja");
		mockFlight.setflighttime("six");
		mockFlight.setflightdate("March");
		mockFlight.setseatno(10);
		mockFlight.setdeparture("hyd");
		mockFlight.setarrival("banglore");
		mockFlight.setPassengerseat(1);
		mockFlight.setpassengerid(101);

		// prepared mock service method
		Boarding mockFlightcons = new Boarding();
		mockFlight.getpassengerid();
		ServletInitializer ab = new ServletInitializer();
		BoardingRepositoryImpl newrepo = new BoardingRepositoryImpl();

		doReturn(mockFlight).when(service).findAll(mockFlight.getpassengerid());

		mockMvc.perform(MockMvcRequestBuilders.get("/passenger/checkin/101/boardingpass", 101))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				.andExpect(jsonPath("$.flightid", is(1))).andExpect(jsonPath("$.passengerid", is(101)))
				.andExpect(jsonPath("$.passengername", is("Pooja")));

	}
}
