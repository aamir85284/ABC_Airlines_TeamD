package com.myapp.spring.repository;

import com.myapp.spring.model.Boarding;

public interface BoardingRepository {

	Boarding saveProduct(Boarding product);

	Boarding findAll(Integer id);

}
