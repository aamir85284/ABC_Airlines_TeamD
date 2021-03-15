package com.myapp.spring.repository;

import com.myapp.spring.model.Passenger;

public interface ManageRepository {

	Passenger updateProductCurrency(Passenger product);

	Passenger updateProductCity(Passenger product);

	Passenger updateProductAircraft(Passenger product);

	Passenger updateProductArrival(Passenger product);

	Passenger updateProductDestination(Passenger product);

	Passenger updateProductCountry(Passenger product);

	Passenger findById(Integer id);
}