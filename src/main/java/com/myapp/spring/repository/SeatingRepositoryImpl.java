package com.myapp.spring.repository;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Seating;

@Repository
public class SeatingRepositoryImpl implements SeatingRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Seating saveProduct(Seating product) {

		Random rand = new Random();
		int seatno = rand.nextInt(61);

		jdbcTemplate.update("insert into seating values (?,?,?,?)", product.getFlightid(), product.getPassengername(),
				product.getPassengerid(), seatno);
		return product;
	}

}
