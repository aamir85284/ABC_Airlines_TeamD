//package com.myapp.spring.demo;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.myapp.spring.AbcAirlinesTeamDApplication;
//import com.myapp.spring.model.Product;
//import com.myapp.spring.repository.PassengerRepository;
//
////@SpringBootTest
//@WebMvcTest
//class PassengerApiTest extends AbcAirlinesTeamDApplication {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private PassengerRepository passengerRepository;
//
//	@Test
//	public void testGetProducts() throws Exception {
//		Product products = new Product();
//
//		Product product1 = new Product();
//		product1.setFlight_id(3);
//		product1.setLoyalty_points(15);
//		;
//		product1.setPassenger_name("Alen");
//		;
//		product1.setPassengerid(113);
//		;
//
//		Mockito.when(passengerRepository.findById(3)).thenReturn(products);
//		mockMvc.perform(get("/passenger/3")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
//				.andExpect(jsonPath("$[1].passengerid", Matchers.equalTo(113)));
//
//	}
//}

//-------------------------------------------------

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

// spring context
// environment
// loading the beans
// start the embeded tomcat server
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
	// @DisplayName("Test Flight with id successfully - GET /passenger/113")
	public void testGetFlightById() throws Exception {

		// Prepared mock flight
		PassengerLoyalty mockFlight = new PassengerLoyalty();
		mockFlight.setFlight_id(3);
		mockFlight.setLoyalty_points(15);

		mockFlight.setPassenger_name("Alen");

		mockFlight.setPassengerid(113);

		// prepared mock service method
		PassengerLoyalty mockFlightcons = new PassengerLoyalty(3, 113, "Alen", 15);
		mockFlight.getFlight_id();
		mockFlightcons.getFlight_id();

		doReturn(mockFlight).when(service).updateProduct(mockFlight);

		doReturn(mockFlight).when(service).findById(mockFlight.getPassengerid());

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("/passenger/113", 113)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$.flight_id", is(3))).andExpect(jsonPath("$.loyalty_points", is(15)))
				.andExpect(jsonPath("$.passengerid", is(113))).andExpect(jsonPath("$.passenger_name", is("Alen")));

	}

	@Test
	// @DisplayName("Update an existing Flight -PUT /flights")
	public void testUpdateNewFlight() throws Exception {

		// Prepare Mock Product
		PassengerLoyalty mockFlight1 = new PassengerLoyalty();
		mockFlight1.setFlight_id(2);
		// mockFlight1.setLoyalty_points(20);

		mockFlight1.setPassenger_name("Alex");

		mockFlight1.setPassengerid(101);
		doReturn(mockFlight1).when(service).saveProduct(ArgumentMatchers.any());

		PassengerLoyalty flightToBeUpdated = new PassengerLoyalty();
		flightToBeUpdated.setFlight_id(2);
		flightToBeUpdated.setPassenger_name("Alex");
		flightToBeUpdated.setLoyalty_points(20);
		flightToBeUpdated.setPassengerid(101);
		doReturn(mockFlight1).when(service).findById(101);
		doReturn(mockFlight1).when(service).updateProduct(ArgumentMatchers.any());

		mockMvc.perform(put("/passenger/{id}", 101).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(flightToBeUpdated)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.loyalty_points", is(20)));

	}

	@Test
	// @DisplayName("Add New Flight -POST /flights")
	public void testAddNewFlight() throws Exception {

		// Prepare Mock Product
		PassengerLoyalty mockflight = new PassengerLoyalty();
		mockflight.setFlight_id(2);
		mockflight.setPassenger_name("Alex");
		mockflight.setLoyalty_points(20);
		mockflight.setPassengerid(101);

		doReturn(mockflight).when(service).saveProduct(ArgumentMatchers.any());

		mockMvc.perform(post("/passenger/loyalty_points/").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockflight)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.passenger_name", is("Alex")));

	}

}