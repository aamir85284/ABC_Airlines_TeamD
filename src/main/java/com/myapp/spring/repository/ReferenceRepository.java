package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.ReferenceProduct;

public interface ReferenceRepository {

	List<ReferenceProduct> findAll();

	ReferenceProduct findAll(Integer product);

	ReferenceProduct saveProduct(ReferenceProduct product);

}