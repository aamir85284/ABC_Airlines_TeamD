package com.myapp.spring.reference;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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
import com.myapp.spring.ServletInitializer;
import com.myapp.spring.model.ReferenceProduct;
import com.myapp.spring.repository.ReferenceRepository;
import com.myapp.spring.repository.ReferenceRepositoryImpl;

@SpringBootTest

@AutoConfigureMockMvc
public class ReferencedataTest {

	@MockBean
	private ReferenceRepository service;

	@Autowired
	private MockMvc mockMvc;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Referencedata.json").toFile();

	ReferenceProduct flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, ReferenceProduct[].class);

	}

	@Test

	public void testGetFlightById() throws Exception {

		ReferenceProduct mockFlight = new ReferenceProduct();
		mockFlight.setPassengerid(2021001);
		mockFlight.setAircraft("Indigo");
		mockFlight.setArrival("Pune");
		mockFlight.setCity("Mumbai");
		mockFlight.setCountry("India");
		mockFlight.setCurrency("rupee");
		mockFlight.setDestination("Hyderabad");
		mockFlight.setPassengername("spandana");

		ReferenceProduct mockFlightcons = new ReferenceProduct();
		mockFlight.getPassengerid();
		ServletInitializer ab = new ServletInitializer();
		ReferenceRepositoryImpl newrepo = new ReferenceRepositoryImpl();

		doReturn(mockFlight).when(service).findAll(mockFlight.getPassengerid());

		mockMvc.perform(MockMvcRequestBuilders.get("/referencedata/2021001", 2021001)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				.andExpect(jsonPath("$.aircraft", is("Indigo"))).andExpect(jsonPath("$.arrival", is("Pune")))
				.andExpect(jsonPath("$.city", is("Mumbai"))).andExpect(jsonPath("$.country", is("India")))
				.andExpect(jsonPath("$.currency", is("rupee"))).andExpect(jsonPath("$.destination", is("Hyderabad")))
				.andExpect(jsonPath("$.passengername", is("spandana")));

	}

	@Test

	public void testAddNewFlight() throws Exception {

		ReferenceProduct mockflight = new ReferenceProduct();
		mockflight.setPassengerid(2021001);
		mockflight.setAircraft("Indigo");
		mockflight.setArrival("Pune");
		mockflight.setCity("Mumbai");
		mockflight.setCountry("India");
		mockflight.setCurrency("rupee");
		mockflight.setDestination("Hyderabad");
		mockflight.setPassengername("spandana");

		doReturn(mockflight).when(service).saveProduct(ArgumentMatchers.any());

		mockMvc.perform(post("/referencedata").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockflight)))
				.andExpect(jsonPath("$.aircraft", is("Indigo"))).andExpect(jsonPath("$.arrival", is("Pune")))
				.andExpect(jsonPath("$.city", is("Mumbai"))).andExpect(jsonPath("$.country", is("India")))
				.andExpect(jsonPath("$.currency", is("rupee"))).andExpect(jsonPath("$.destination", is("Hyderabad")))
				.andExpect(jsonPath("$.passengername", is("spandana")));
	}

	@Test
	@DisplayName("when get request for all flights are made using GET /flights ")
	public void testFindAllFlights() throws Exception {

		doReturn(Arrays.asList(flights)).when(service).findAll();

		mockMvc.perform(MockMvcRequestBuilders.get("/referencedata")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.*", isA(ArrayList.class)))

				.andExpect(jsonPath("$[*].passengerid", hasItems(2021001, 2021002, 2021003, 2021004, 2021005)))
				.andExpect(jsonPath("$[*].passengername", hasItems("spandana", "Pooja", "Sanjana", "Aamir", "Farhan")));

	}

}
