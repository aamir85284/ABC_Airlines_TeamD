package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Boarding;
import com.myapp.spring.repository.BoardingRepository;

@RestController
@RequestMapping("/passenger")

public class ProductApiBoarding {
	@Autowired
	private BoardingRepository repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/checkin/{id}/boardingpass")
	public Boarding getProductById(@PathVariable(value = "id") Integer id) {
		return repository.findAll(id);
	}
}
