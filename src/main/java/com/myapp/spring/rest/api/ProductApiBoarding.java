package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//python -

// import flask
//app=flask.Flask(__name__)
//@app.get("url",Method)
//def getProducts():

//Nodejs

//const express = require("Express")
//const app = express()
//app.get('',()=>{})

//resource
//any resource having the url ="http://localhost:4002/products"

@RestController
@RequestMapping("/passenger")

public class ProductApiBoarding {

	// ProductApi class has a dependency on ProductRepository
	// interface
	// ProductApi is tightly coupled with ProductRepository
//	@Autowired
//	 private PassengerRepository repository;
	// At runtime, it will search for the ProductRepository type object i.e, all
	// classes implementing this interface
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@GetMapping
//	public List<Product> getAll() {
//		return repository.findAll();
//	}

//	@GetMapping("/{id}")
//	public Product findById(@PathVariable("id") Integer productid) {
//
//		// Product existingProduct =repository.findById(productid);
//
//		return repository.findById(productid);
//
//	}
	@GetMapping("/checkin/{id}/boardingpass")
	public String findByIdPass(@PathVariable("id") Integer productid) {

		// Product existingProduct =repository.findById(productid);
		// List flightIdList = [1, 2];

		try {
			String query = "select arrival from abc_teamd where flight_id=?";
			Object[] inputs = new Object[] { productid };
			String arrival = jdbcTemplate.queryForObject(query, String.class, inputs);

			String query1 = "select departure from abc_teamd where flight_id=?";
			Object[] inputs1 = new Object[] { productid };
			String departure = jdbcTemplate.queryForObject(query1, String.class, inputs1);

			String query2 = "select flight_date from abc_teamd where flight_id=?";
			Object[] inputs2 = new Object[] { productid };
			String flight_date = jdbcTemplate.queryForObject(query2, String.class, inputs2);

			String query3 = "select flight_time from abc_teamd where flight_id=?";
			Object[] inputs3 = new Object[] { productid };
			String flight_time = jdbcTemplate.queryForObject(query3, String.class, inputs3);

			String query4 = "select passengerid from abc_teamd where flight_id=?";
			Object[] inputs4 = new Object[] { productid };
			String passenger_id = jdbcTemplate.queryForObject(query4, String.class, inputs4);

			String query5 = "select passenger_name from abc_teamd where flight_id=?";
			Object[] inputs5 = new Object[] { productid };
			String passenger_name = jdbcTemplate.queryForObject(query5, String.class, inputs5);

			String query6 = "select passenger_seat from abc_teamd where flight_id=?";
			Object[] inputs6 = new Object[] { productid };
			String passenger_seat = jdbcTemplate.queryForObject(query6, String.class, inputs6);
			// return Integer.toString(empName);
			return "<html><body>" + "<h1>Here's your boarding Pass " + passenger_name
					+ "</h1><br> <h3> Your Passenger ID is :- " + passenger_id + "<br>Your arrival is :- " + arrival
					+ "<br> Your departure is :- " + departure + "<br> Your Flight Date is :- " + flight_date
					+ "<br> Your Flight time is :- " + flight_time + "<br> Your Seat Assigned is :- " + passenger_seat
					+ "</h3>" + "</body></html>";

			// return Integer.toString(productid);

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

	@GetMapping("/error")
	public String error() {
		return "<html><body>" + "<h1>Checkin </h1><br> <h3>Your checin not done</h3>" + "</body></html>";
	}

}