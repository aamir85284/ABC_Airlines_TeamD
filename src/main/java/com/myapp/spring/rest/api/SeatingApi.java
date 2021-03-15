package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Seating;
import com.myapp.spring.repository.SeatingRepository;

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

public class SeatingApi {

	@Autowired // ProductApi class has a dependency on ProductRepository interface
				// ProductApi is tightly coupled with ProductRepository

	private SeatingRepository repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// At runtime, it will search for the ProductRepository type object i.e, all
	// classes implementing this interface

	@PostMapping
	public Seating saveNewProduct(@RequestBody Seating product) {

		return repository.saveProduct(product);
	}

	@GetMapping("/checkin/{id}/boardingpass/seating")
	public String findById(@PathVariable("id") Integer productid) {

		// Product existingProduct =repository.findById(productid);
		// List flightIdList = [1, 2];

		try {
			String query = "select seatno from seating where flight_id=?";
			Object[] inputs = new Object[] { productid };
			Integer seatno = jdbcTemplate.queryForObject(query, Integer.class, inputs);

			String query1 = "select passenger_name from seating where flight_id=?";
			Object[] inputs1 = new Object[] { productid };
			String empName = jdbcTemplate.queryForObject(query1, String.class, inputs1);

			// return Integer.toString(empName);
			return "<html><body>" + "<h1> Here's Your Seating Details " + empName + " </h1><br> <h3>Your Seat No is :- "
					+ seatno + "</body></html>";

		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>Checkin Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
					+ "</body></html>";
		}

	}

}