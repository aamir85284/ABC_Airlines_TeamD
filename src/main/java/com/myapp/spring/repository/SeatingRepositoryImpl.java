package com.myapp.spring.repository;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Seating;

@Repository // It's a data Repository Class
public class SeatingRepositoryImpl implements SeatingRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Seating saveProduct(Seating product) {
		// TODO Auto-generated method stub
		// return null;
		Random rand = new Random();
		int seatno = rand.nextInt(61);

		jdbcTemplate.update("insert into seating values (?,?,?,?)", product.getFlight_id(), product.getPassenger_name(),
				product.getPassengerid(), seatno);
		return product;
	}

	@Override
	public Seating findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
