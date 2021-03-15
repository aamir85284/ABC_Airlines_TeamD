package com.myapp.spring.repository;

import com.myapp.spring.model.Boarding;

public interface BoardingRepository {

	// List<Product> findAll();

//	Product updateProduct(Product product);

	Boarding saveProduct(Boarding product);

	Boarding findAll(Integer id);

	// String welcome();

}
