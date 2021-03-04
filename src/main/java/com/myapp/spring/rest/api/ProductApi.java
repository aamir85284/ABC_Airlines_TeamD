package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.PassengerRepository;

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

public class ProductApi {

	@Autowired // ProductApi class has a dependency on ProductRepository interface
				// ProductApi is tightly coupled with ProductRepository

	private PassengerRepository repository;
	// At runtime, it will search for the ProductRepository type object i.e, all
	// classes implementing this interface
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping
	public List<Product> getAll() {
		return repository.findAll();
	}

//	@GetMapping("/{id}")
//	public Product findById(@PathVariable("id") Integer productid) {
//
//		// Product existingProduct =repository.findById(productid);
//
//		return repository.findById(productid);
//
//	}
	@GetMapping("/checkin/{id}")
	public String findById(@PathVariable("id") Integer productid) {

		// Product existingProduct =repository.findById(productid);
		// List flightIdList = [1, 2];

		try {
			String query = "select flight_id from abc_teamd where flight_id=?";
			Object[] inputs = new Object[] { productid };
			Integer empName = jdbcTemplate.queryForObject(query, Integer.class, inputs);
			if (productid == empName) {
				// return Integer.toString(empName);
				return "<html><body>" + "<h1>Checkin Details</h1><br> <h3>Your BookingID :- " + empName
						+ " is present in our database.<br>Congratulations your checkIn is DONE!</h3>"
						+ "</body></html>";
			} else {
				// return Integer.toString(productid);
				return "<html><body>" + "<h1>Checkin </h1><br> <h3>Your checin not done</h3>" + "</body></html>";
			}
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