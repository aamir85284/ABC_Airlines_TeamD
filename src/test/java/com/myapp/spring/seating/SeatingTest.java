package com.myapp.spring.seating;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Seating;
import com.myapp.spring.repository.SeatingRepository;

@SpringBootTest
//@WebMvcTest
@AutoConfigureMockMvc
public class SeatingTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private SeatingRepository userService;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Seatingdata.json").toFile();

	Seating flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, Seating[].class);

	}

//	@BeforeEach
//	public void setup() {
//
//	}

	@Test
	public void testCreateUser() throws Exception {
		// int id = 10;
		// when(userService.findById(id)).thenReturn(getUserInfo());

		MvcResult result = mockMvc.perform(get("/passenger/checkin/10/boardingpass/seating")).andExpect(status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString().contains(

				"<html><body>" + "<h1> Here's Your Seating Details " + getUserInfo().getPassenger_name()
						+ " </h1><br> <h3>Your Seat No is :- " + getUserInfo().getSeatno() + "</body></html>"));

		System.out.println(result.getResponse().getContentAsString());
//		assertFalse(result.getResponse().getContentAsString().contains("<html><body>"
//				+ "<h1>Checkin Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
//				+ "</body></html>"));

	}

	private Seating getUserInfo() {
		Seating user = new Seating();
		user.setFlight_id(10);
		user.setPassengerid(101);
		user.setPassenger_name("Pooja");
		user.setSeatno(46);

		return user;
	}

	@Test
	public void testAddNewFlight() throws Exception {

		// Prepare Mock Product
		Seating mockflight = new Seating();
		mockflight.setFlight_id(10);
		mockflight.setPassengerid(101);
		mockflight.setPassenger_name("Pooja");
		mockflight.setSeatno(46);
		doReturn(mockflight).when(userService).saveProduct(ArgumentMatchers.any());

		mockMvc.perform(post("/passenger").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockflight)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.flight_id", is(10)));

	}

}