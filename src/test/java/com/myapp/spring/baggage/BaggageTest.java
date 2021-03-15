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
//@WebMvcTest
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
    
//	@BeforeEach
//	public void setup() {
//
//	}

	@Test
	public void testCreateUser() throws Exception {
//		int id = 1;
//		when(userService.findById(id)).thenReturn(getUserInfo());
		MvcResult result = mockMvc.perform(get("/passenger/checkin/1/boardingpass/seating/Baggages")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString().contains(
				"<html><body>" + "<h1> Here's Your Baggage Details " + getUserInfo().getPassenger_name() + " </h1><br> <h3>Your Baggage id :- "
						+ getUserInfo().getBaggageids() + "</body></html>"));

//				"<style>h1 {color: blue;}marquee {color: green;}h2 {color: Magenta}</style><center><h1>WELCOME TO HAPPY TRIP</h1> "
//						+ "<marquee><i>Your Registration is Sucessfull!!!</i></marquee>" + "<h2>PROFILE</h2>"
//						+ "<strong>User ID: </strong>" + getUserInfo().getId() + "<br><strong>Name: </strong>"
//						+ getUserInfo().getName() + "<br><strong>Age: </strong> " + getUserInfo().getAge()
//						+ "<br><strong>Gender: </strong>" + getUserInfo().getGender() + "<br><strong>Address: </strong>"
//						+ getUserInfo().getAddress() + "<br><strong>Country:</strong>" + getUserInfo().getCountry()
//						+ "<br><strong>Email-Id : </strong>" + getUserInfo().getEmailid()
//						+ "<br><strong>Contact : </strong>" + getUserInfo().getContact() + "</center>");
		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString().contains("<html><body>"
				+ "<h1>Baggage Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
				+ "</body></html>"));

	}

	private BaggagePassenger getUserInfo() {
		BaggagePassenger user = new BaggagePassenger();
		user.setBaggageids("89, 42, 94");
		user.setFlight_id(1);
		user.setPassengerid(12);
		user.setPassenger_name("Farhan");

		return user;
	}

//			assertEquals("saloni@gmail.com",user.getEmailid());
//	        assertEquals("saloni2021",user.getPassword());
//	        assertEquals("saloni",user.getName());
//	        assertEquals(21,user.getAge());
//	        assertEquals("Rajasthan",user.getAddress());
//	        assertEquals("India",user.getCountry());
//	        assertEquals(98765432,user.getContact());
//	        assertEquals("female",user.getGender());

	}

//	@Test
//	public void testCreateWelcome() throws Exception {
////		int id = 1;
////		when(userService.findById(id)).thenReturn(getUserInfo());
//
//		MvcResult result = mockMvc.perform(get("/passenger/checkin")).andExpect(status().isOk()).andReturn();
//		System.out.println(result.getResponse().getContentAsString());
//		assertTrue(result.getResponse().getContentAsString().contains(
//
//				"<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>We do check in for abc airlines</h3>"
//						+ "</body></html>"));
//
//		System.out.println(result.getResponse().getContentAsString());
//
//	}

