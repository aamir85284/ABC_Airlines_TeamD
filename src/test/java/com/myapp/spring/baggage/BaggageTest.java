package com.myapp.spring.baggage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.BaggagePassenger;
import com.myapp.spring.repository.BaggageRepository;

@SpringBootTest

@AutoConfigureMockMvc
public class BaggageTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BaggageRepository userService;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "BaggageData.json").toFile();

	BaggagePassenger flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, BaggagePassenger[].class);

	}

	@Test
	public void testCreateUser() throws Exception {

		MvcResult result = mockMvc.perform(get("/passenger/1/baggages")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString()
				.contains("<html><body>" + "<h1> Here's Your Baggage Details " + getUserInfo().getPassengername()
						+ " </h1><br> <h3>Your Baggage id :- " + getUserInfo().getBaggages() + "</body></html>"));

		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString().contains("<html><body>"
				+ "<h1>Baggage Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
				+ "</body></html>"));

	}

	private BaggagePassenger getUserInfo() {
		BaggagePassenger user = new BaggagePassenger();
		user.setBaggages("89, 42, 94");
		user.setFlightid(1);
		user.setPassengerid(12);
		user.setPassengername("Farhan");

		return user;
	}

}
