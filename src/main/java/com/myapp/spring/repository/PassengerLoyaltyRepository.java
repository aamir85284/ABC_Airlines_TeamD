package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.PassengerLoyalty;

public interface PassengerLoyaltyRepository {

	PassengerLoyalty saveProduct(PassengerLoyalty product);

	List<PassengerLoyalty> findAll(String product);

	PassengerLoyalty updateProduct(PassengerLoyalty product);

	PassengerLoyalty findById(Integer id);
}
