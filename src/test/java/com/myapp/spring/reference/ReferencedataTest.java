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
//import com.myapp.spring.AbcairlinesApplicationTests;
import com.myapp.spring.ServletInitializer;
import com.myapp.spring.model.ReferenceProduct;
import com.myapp.spring.repository.ReferenceRepository;
import com.myapp.spring.repository.ReferenceRepositoryImpl;

@SpringBootTest

// spring context
// environment
// loading the beans
// start the embeded tomcat server
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
	// @DisplayName("Test Flight with id successfully - GET /passenger/113")
	public void testGetFlightById() throws Exception {

		// Prepared mock flight
		ReferenceProduct mockFlight = new ReferenceProduct();
		mockFlight.setPassengerid(2021001);
		mockFlight.setAircraft("Indigo");
		mockFlight.setArrival("Pune");
		mockFlight.setCity("Mumbai");
		mockFlight.setCountry("India");
		mockFlight.setCurrency("rupee");
		mockFlight.setDestination("Hyderabad");
		mockFlight.setPassenger_name("spandana");
		// prepared mock service method
		ReferenceProduct mockFlightcons = new ReferenceProduct(2021001, "Indigo", "Pune", "Mumbai", "India", "rupee",
				"Hyderabad", "spandana");
		mockFlight.getPassengerid();
		ServletInitializer ab = new ServletInitializer();
		ReferenceRepositoryImpl newrepo = new ReferenceRepositoryImpl();
		// newrepo.findById(113);
		// newrepo.saveProduct(mockFlightcons);
		doReturn(mockFlight).when(service).findAll(mockFlight.getPassengerid());

//		mockMvc.perform(MockMvcRequestBuilders.put("/passenger/101", 101)).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(jsonPath("$.passengerid", is(101))).andExpect(jsonPath("$.loyalty_points", is(20)));

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("/referencedata/2021001", 2021001)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}
				.andExpect(jsonPath("$.aircraft", is("Indigo"))).andExpect(jsonPath("$.arrival", is("Pune")))
				.andExpect(jsonPath("$.city", is("Mumbai"))).andExpect(jsonPath("$.country", is("India")))
				.andExpect(jsonPath("$.currency", is("rupee"))).andExpect(jsonPath("$.destination", is("Hyderabad")))
				.andExpect(jsonPath("$.passenger_name", is("spandana")));
//				.andExpect(jsonPath("$[0].flightId", is(1))).andExpect(jsonPath("$.flightTime", is("six")))
//				.andExpect(jsonPath("$.passengerID", is(101))).andExpect(jsonPath("$.passengerName", is("Pooja")));

	}

	@Test
	// @DisplayName("Add New Flight -POST /flights")
	public void testAddNewFlight() throws Exception {

		// Prepare Mock Product
		ReferenceProduct mockflight = new ReferenceProduct();
		mockflight.setPassengerid(2021001);
		mockflight.setAircraft("Indigo");
		mockflight.setArrival("Pune");
		mockflight.setCity("Mumbai");
		mockflight.setCountry("India");
		mockflight.setCurrency("rupee");
		mockflight.setDestination("Hyderabad");
		mockflight.setPassenger_name("spandana");

		doReturn(mockflight).when(service).saveProduct(ArgumentMatchers.any());

		mockMvc.perform(post("/referencedata").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockflight)))
				.andExpect(jsonPath("$.aircraft", is("Indigo"))).andExpect(jsonPath("$.arrival", is("Pune")))
				.andExpect(jsonPath("$.city", is("Mumbai"))).andExpect(jsonPath("$.country", is("India")))
				.andExpect(jsonPath("$.currency", is("rupee"))).andExpect(jsonPath("$.destination", is("Hyderabad")))
				.andExpect(jsonPath("$.passenger_name", is("spandana")));
	}

	@Test
	@DisplayName("when get request for all flights are made using GET /flights ")
	public void testFindAllFlights() throws Exception {

		doReturn(Arrays.asList(flights)).when(service).findAll();

		mockMvc.perform(MockMvcRequestBuilders.get("/referencedata")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.*", isA(ArrayList.class)))

				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$[*].passengerid", hasItems(2021001, 2021002, 2021003, 2021004, 2021005)))
				.andExpect(
						jsonPath("$[*].passenger_name", hasItems("spandana", "Pooja", "Sanjana", "Aamir", "Farhan")));
//				.andExpect(jsonPath("$[*].distance", hasItems(478, 378, 378, 978)));

	}

}
