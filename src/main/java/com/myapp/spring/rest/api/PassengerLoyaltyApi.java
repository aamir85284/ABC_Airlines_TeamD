package com.myapp.spring.rest.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.PassengerLoyalty;
import com.myapp.spring.repository.PassengerLoyaltyRepository;

@RestController
@RequestMapping("/passenger")

public class PassengerLoyaltyApi {

	@Autowired

	private PassengerLoyaltyRepository repository;

	@PostMapping("/loyalty_points")
	public PassengerLoyalty saveNewProduct(@RequestBody PassengerLoyalty product) {

		return repository.saveProduct(product);

	}

	@PutMapping("/{id}")
	public PassengerLoyalty updateProduct(@PathVariable("id") Integer productid,
			@RequestBody PassengerLoyalty product) {

		PassengerLoyalty existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.updateProduct(product);
	}

	@GetMapping("/loyaltypoints/{id}")
	public PassengerLoyalty findById(@PathVariable("id") Integer productid) {

		// Product existingProduct =repository.findById(productid);
		return repository.findById(productid);

	}

}