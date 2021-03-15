package com.myapp.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Boarding;

@Repository // It's a data Repository Class
public class BoardingRepositoryImpl implements BoardingRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Home Page
	@Override
	public Boarding findAll(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from abc_teamd where passengerid=?",
				new BeanPropertyRowMapper<>(Boarding.class), id);
	}

//	@Override
//	public Product updateProduct(Product product) {
//		// TODO Auto-generated method stub
//		// return null;
//		jdbcTemplate.update("UPDATE FlightId SET FlightId=? WHERE passengerID=?", product.getflight_id(),
//				product.getpassengerid());
//		return product;
//	}

	@Override
	public Boarding saveProduct(Boarding product) {
		// TODO Auto-generated method stub
		// return null;
		jdbcTemplate.update("UPDATE FlightId SET FlightId=? WHERE passengerID=?", product.getflight_id(),
				product.getpassengerid());
		return product;
	}

}
