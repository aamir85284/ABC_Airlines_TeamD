package com.myapp.spring.repository;

import com.myapp.spring.model.BaggagePassenger;

public interface BaggageRepository {

	BaggagePassenger saveProduct(BaggagePassenger product, Integer bno);

}
