package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")

public class CheckinApi {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/checkin/{id}")
	public String findById(@PathVariable("id") Integer productid) {

		try {
			String query = "select flightid from Check_In where flightid=?";
			Object[] inputs = new Object[] { productid };
			Integer empName = jdbcTemplate.queryForObject(query, Integer.class, inputs);

			return "<html><body>" + "<h1>Checkin Details</h1><br> <h3>Your BookingID :- " + empName
					+ " is present in our database.<br>Congratulations your checkIn is DONE!</h3>" + "</body></html>";

		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>Checkin Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
					+ "</body></html>";
		}

	}

	@GetMapping("/checkin")
	public String welcome() {
		return "<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>We do check in for abc airlines</h3>"
				+ "</body></html>";
	}

}