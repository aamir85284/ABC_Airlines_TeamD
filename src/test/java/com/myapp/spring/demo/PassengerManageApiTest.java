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
import com.myapp.spring.model.Passenger;
import com.myapp.spring.repository.ManageRepository;

@SpringBootTest

// spring context
// environment
// loading the beans
// start the embeded tomcat server
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
	// @DisplayName("Test Flight with id successfully - GET /passenger/113")
	public void testGetFlightById() throws Exception {

		// Prepared mock flight
		Passenger mockFlight = new Passenger();
		mockFlight.setPassengerid(11);
		;
		mockFlight.setAircraft("spice jet");

		mockFlight.setArrival("mumbai");
		;

		mockFlight.setCity("banglore");

		mockFlight.setCountry("india");
		mockFlight.setCurrency("yen");
		mockFlight.setDestination("kolkata");
		mockFlight.setPassenger_name("Aamir");

		// prepared mock service method
		Passenger mockFlightcons = new Passenger(11, "spice jet", "mumbai", "banglore", "india", "yen", "kolkata",
				"Aamir");
		mockFlight.getPassengerid();
		mockFlightcons.getPassengerid();

		doReturn(mockFlight).when(service).updateProductCurrency(mockFlight);
		doReturn(mockFlight).when(service).updateProductCity(mockFlight);
		doReturn(mockFlight).when(service).findById(mockFlight.getPassengerid());

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("/passenger/{id}", 11)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$.passengerid", is(11))).andExpect(jsonPath("$.currency", is("yen")))
				.andExpect(jsonPath("$.city", is("banglore"))).andExpect(jsonPath("$.arrival", is("mumbai")))
				.andExpect(jsonPath("$.country", is("india"))).andExpect(jsonPath("$.passenger_name", is("Aamir")));

	}

}