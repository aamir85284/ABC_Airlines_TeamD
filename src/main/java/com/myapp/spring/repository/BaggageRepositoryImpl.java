package com.myapp.spring.repository;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.BaggagePassenger;

@Repository // It's a data Repository Class
public class BaggageRepositoryImpl implements BaggageRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BaggagePassenger saveProduct(BaggagePassenger product, Integer count) {
		// TODO Auto-generated method stub
		// return null;
		Random rand = new Random();
		for(int i=0;i<count;i++) {
			product.addBaggageid(rand.nextInt(100));
		}

		if(product.getBaggageids().contains("null, ")) {
			product.setBaggageids(product.getBaggageids().replace("null, ", ""));
    	}
		jdbcTemplate.update("insert into abc_baggage values (?,?,?,?)", product.getFlight_id(), product.getBaggageids(), 
				product.getPassenger_name(), product.getPassengerid());
		return product;
	}

}
