package com.myapp.spring.rest.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Passenger;
import com.myapp.spring.repository.ManageRepository;

@RestController
@RequestMapping("/passenger")

public class PassengerManageApi {

	@Autowired

	private ManageRepository repository;

	@PutMapping("/currency/{id}")
	public Passenger updateProductCurrency(@PathVariable("id") Integer productid, @RequestBody Passenger product) {

		Passenger existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.updateProductCurrency(product);
	}

	@PutMapping("/city/{id}")
	public Passenger updateProductCity(@PathVariable("id") Integer productid, @RequestBody Passenger product) {

		Passenger existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.updateProductCity(product);
	}

	@PutMapping("/aircraft/{id}")
	public Passenger updateProductAircraft(@PathVariable("id") Integer productid, @RequestBody Passenger product) {

		Passenger existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.updateProductAircraft(product);
	}

	@PutMapping("/arrival/{id}")
	public Passenger updateProductArrival(@PathVariable("id") Integer productid, @RequestBody Passenger product) {

		Passenger existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.updateProductArrival(product);
	}

	@PutMapping("/destination/{id}")
	public Passenger updateProductDestination(@PathVariable("id") Integer productid, @RequestBody Passenger product) {

		Passenger existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.updateProductDestination(product);
	}

	@PutMapping("/country/{id}")
	public Passenger updateProductCountry(@PathVariable("id") Integer productid, @RequestBody Passenger product) {

		Passenger existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.updateProductCountry(product);
	}

	@GetMapping("/{id}")
	public Passenger findById(@PathVariable("id") Integer productid) {

		// Product existingProduct =repository.findById(productid);
		return repository.findById(productid);

	}

}