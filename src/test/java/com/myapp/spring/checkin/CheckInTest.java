package com.myapp.spring.checkin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Checkin;
import com.myapp.spring.repository.CheckinRepository;

@SpringBootTest

@AutoConfigureMockMvc
public class CheckInTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CheckinRepository userService;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Checkindata.json").toFile();

	Checkin flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, Checkin[].class);

	}

	//@Test
	public void testCreateUser() throws Exception {
		int id = 1;
		String a = "<html><body>";
		when(userService.findById(id)).thenReturn(getUserInfo());

		MvcResult result = mockMvc.perform(get("/passenger/checkin/1")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString().contains(

				a + "<h1>Checkin Details</h1><br> <h3>Your BookingID :- " + getUserInfo().getFlightid()
						+ " is present in our database.<br>Congratulations your checkIn is DONE!</h3>" + a));

		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString().contains(a
				+ "<h1>Checkin Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
				+ a));

	}

	private Checkin getUserInfo() {
		Checkin user = new Checkin();
		user.setFlightid(1);
		user.setPassengerid(100);

		return user;

	}

	@Test
	public void testCreateWelcome() throws Exception {
		String a = "<html><body>";
		MvcResult result = mockMvc.perform(get("/passenger/checkin")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString().contains(

				a + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>We do check in for abc airlines</h3>" + a));

		System.out.println(result.getResponse().getContentAsString());

	}

}
