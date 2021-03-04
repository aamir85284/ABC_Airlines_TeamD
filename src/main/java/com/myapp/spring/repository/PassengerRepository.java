package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Product;

public interface PassengerRepository {

	List<Product> findAll();

	Product findById(Integer id);

	// String welcome();

}
