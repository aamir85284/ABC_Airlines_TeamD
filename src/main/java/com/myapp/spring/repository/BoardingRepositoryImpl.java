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

	@Override
	public Boarding findAll(Integer id) {

		return jdbcTemplate.queryForObject("select * from abc_teamd where passengerid=?",
				new BeanPropertyRowMapper<>(Boarding.class), id);
	}

	@Override
	public Boarding saveProduct(Boarding product) {

		jdbcTemplate.update("UPDATE FlightId SET FlightId=? WHERE passengerID=?", product.getflightid(),
				product.getpassengerid());
		return product;
	}

}
