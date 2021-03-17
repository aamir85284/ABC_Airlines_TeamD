package com.myapp.spring.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
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
import com.myapp.spring.model.PassengerLoyalty;
import com.myapp.spring.repository.PassengerLoyaltyRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PassengerLoyaltyApiTest {

	@MockBean
	private PassengerLoyaltyRepository service;

	@Autowired
	private MockMvc mockMvc;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "flightsLoyalty.json").toFile();

	PassengerLoyalty flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, PassengerLoyalty[].class);

	}

	@Test
	public void testGetFlightById() throws Exception {

		PassengerLoyalty mockFlight = new PassengerLoyalty();
		mockFlight.setFlightid(3);
		mockFlight.setLoyaltypoints(15);

		mockFlight.setPassengername("Alen");

		mockFlight.setPassengerid(113);

		PassengerLoyalty mockFlightcons = new PassengerLoyalty(3, 113, "Alen", 15);
		mockFlight.getFlightid();
		mockFlightcons.getFlightid();

		doReturn(mockFlight).when(service).updateProduct(mockFlight);

		doReturn(mockFlight).when(service).findById(mockFlight.getPassengerid());

		mockMvc.perform(MockMvcRequestBuilders.get("/passenger/loyaltypoints/113", 113)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				.andExpect(jsonPath("$.flightid", is(3))).andExpect(jsonPath("$.loyaltypoints", is(15)))
				.andExpect(jsonPath("$.passengerid", is(113))).andExpect(jsonPath("$.passengername", is("Alen")));

	}

	@Test

	public void testUpdateNewFlight() throws Exception {

		PassengerLoyalty mockFlight1 = new PassengerLoyalty();
		mockFlight1.setFlightid(2);

		mockFlight1.setPassengername("Alex");

		mockFlight1.setPassengerid(101);
		doReturn(mockFlight1).when(service).saveProduct(ArgumentMatchers.any());

		PassengerLoyalty flightToBeUpdated = new PassengerLoyalty();
		flightToBeUpdated.setFlightid(2);
		flightToBeUpdated.setPassengername("Alex");
		flightToBeUpdated.setLoyaltypoints(20);
		flightToBeUpdated.setPassengerid(101);
		doReturn(mockFlight1).when(service).findById(101);
		doReturn(mockFlight1).when(service).updateProduct(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/{id}", 101).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(flightToBeUpdated)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.loyaltypoints", is(20)));

	}

	@Test
	public void testAddNewFlight() throws Exception {

		PassengerLoyalty mockflight = new PassengerLoyalty();
		mockflight.setFlightid(2);
		mockflight.setPassengername("Alex");
		mockflight.setLoyaltypoints(20);
		mockflight.setPassengerid(101);

		doReturn(mockflight).when(service).saveProduct(ArgumentMatchers.any());

		mockMvc.perform(post("/passenger/loyalty_points/").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockflight)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.passengername", is("Alex")));

	}

}