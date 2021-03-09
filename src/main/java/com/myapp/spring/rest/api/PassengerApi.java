package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.PassengerRepository;

@RestController
@RequestMapping("/passenger")

public class PassengerApi {

	@Autowired

	private PassengerRepository repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostMapping("/loyalty_points")
	public Product saveNewProduct(@RequestBody Product product) {

		return repository.saveProduct(product);

	}

	@GetMapping("loyalty_points/{name}")
	public String getAll(@PathVariable("name") String product) {
		List<Product> a = repository.findAll(product);
		int num = a.size();
		return "<html><body>" + "<h1>Here's Your Loyalty Points details " + product
				+ "</h1><br> <h3>As you have travelled with our airlines " + num
				+ " times.you have total loyalty points of  " + num * 5 + "</h3>" + "</body></html>";
	}

	@GetMapping("/checkin")
	public String welcome() {
		return "<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>We do check in for abc airlines</h3>"
				+ "</body></html>";
	}

}