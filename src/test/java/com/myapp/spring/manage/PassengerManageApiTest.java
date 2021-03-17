package com.myapp.spring.manage;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
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
import com.myapp.spring.model.Passenger;
import com.myapp.spring.repository.ManageRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PassengerManageApiTest {

	@MockBean
	private ManageRepository service;

	@Autowired
	private MockMvc mockMvc;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "flightsManage.json").toFile();

	Passenger flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, Passenger[].class);

	}

	@Test
	public void testGetFlightById() throws Exception {
		Passenger mockFlight = new Passenger();
		mockFlight.setPassengerid(11);
		mockFlight.setAircraft("spice jet");

		mockFlight.setArrival("mumbai");

		mockFlight.setCity("banglore");

		mockFlight.setCountry("india");
		mockFlight.setCurrency("yen");
		mockFlight.setDestination("kolkata");
		mockFlight.setPassengername("Aamir");

		Passenger mockFlightcons = new Passenger(11, "spice jet", "mumbai", "banglore", "india", "yen", "kolkata");
		mockFlight.getPassengerid();
		mockFlightcons.getPassengerid();

		doReturn(mockFlight).when(service).updateProductCurrency(mockFlight);
		doReturn(mockFlight).when(service).updateProductCity(mockFlight);
		doReturn(mockFlight).when(service).findById(mockFlight.getPassengerid());

		mockMvc.perform(MockMvcRequestBuilders.get("/passenger/{id}", 11)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				.andExpect(jsonPath("$.passengerid", is(11))).andExpect(jsonPath("$.currency", is("yen")))
				.andExpect(jsonPath("$.city", is("banglore"))).andExpect(jsonPath("$.arrival", is("mumbai")))
				.andExpect(jsonPath("$.country", is("india"))).andExpect(jsonPath("$.passengername", is("Aamir")));

	}

	@Test
	public void testUpdateNewFlight() throws Exception {

		// Passenger mockFlight1 = new Passenger();
		Passenger mockFlight = new Passenger();
		mockFlight.setPassengerid(11);
		mockFlight.setAircraft("spice jet");

		mockFlight.setArrival("mumbai");

		mockFlight.setCity("banglore");

		mockFlight.setCountry("india");
		mockFlight.setCurrency("yen");
		mockFlight.setDestination("kolkata");
		mockFlight.setPassengername("Aamir");

		Passenger mockFlightupdates = new Passenger();
		mockFlightupdates.setPassengerid(11);
		mockFlightupdates.setAircraft("Air india");

		mockFlightupdates.setArrival("delhi");

		mockFlightupdates.setCity("panaji");

		mockFlightupdates.setCountry("sri lanka");
		mockFlightupdates.setCurrency("riyal");
		mockFlightupdates.setDestination("kerala");
		mockFlightupdates.setPassengername("Aamir");

		doReturn(mockFlight).when(service).findById(11);
		doReturn(mockFlight).when(service).updateProductAircraft(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/aircraft/{id}", 11).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlightupdates)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.aircraft", is("Air india")));
		// ---------------------------------------------------------

		doReturn(mockFlight).when(service).findById(11);
		doReturn(mockFlight).when(service).updateProductArrival(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/arrival/{id}", 11).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlightupdates)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.arrival", is("delhi")));

		doReturn(mockFlight).when(service).findById(11);
		doReturn(mockFlight).when(service).updateProductCity(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/city/{id}", 11).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlightupdates)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.city", is("panaji")));

		// -------------------------------------------------------------------------

		doReturn(mockFlight).when(service).findById(11);
		doReturn(mockFlight).when(service).updateProductCurrency(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/currency/{id}", 11).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlightupdates)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.currency", is("riyal")));

		doReturn(mockFlight).when(service).findById(11);
		doReturn(mockFlight).when(service).updateProductCountry(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/country/{id}", 11).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlightupdates)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.country", is("sri lanka")));

		doReturn(mockFlight).when(service).findById(11);
		doReturn(mockFlight).when(service).updateProductDestination(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/destination/{id}", 11).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlightupdates)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.destination", is("kerala")));

	}

}
