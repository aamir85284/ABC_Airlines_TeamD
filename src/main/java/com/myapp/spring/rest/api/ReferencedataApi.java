package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.ReferenceProduct;
import com.myapp.spring.repository.ReferenceRepository;

@RestController
@RequestMapping("/referencedata")

public class ReferencedataApi {

	@Autowired

	private ReferenceRepository repository;

	@PostMapping
	public ReferenceProduct saveNewProduct(@RequestBody ReferenceProduct product) {

		return repository.saveProduct(product);

	}

	@GetMapping
	public List<ReferenceProduct> getAll() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ReferenceProduct getProductById(@PathVariable(value = "id") Integer id) {
		return repository.findAll(id);
	}

}
