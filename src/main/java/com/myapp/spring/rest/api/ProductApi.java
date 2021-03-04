package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Integer productid) {

		// Product existingProduct =repository.findById(productid);
		if (productid == 1) {

			return "<html><body>" + "<h1>Checkin </h1><br> <h3>Your checin done</h3>" + "</body></html>";
		} else {
			// return Integer.toString(productid);
			return "<html><body>" + "<h1>Checkin </h1><br> <h3>Your checin not done</h3>" + "</body></html>";
		}
	}

	@GetMapping("/checkin")
	public String welcome() {
		return "<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>We do check in for abc airlines</h3>"
				+ "</body></html>";
	}

}