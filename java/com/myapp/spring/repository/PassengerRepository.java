package com.myapp.spring.repository;

import com.myapp.spring.model.Product;

public interface PassengerRepository {

	// List<Product> findAll();

	// List<Product> findAll();

	// List<Product> findAll();

	Product updateProduct(Product product);

	Product saveProduct(Product product);

	Product findAll(Integer id);

	// String welcome();

}