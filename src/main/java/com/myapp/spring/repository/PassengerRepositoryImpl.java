package com.myapp.spring.repository;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

@Repository // It's a data Repository Class
public class PassengerRepositoryImpl implements PassengerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		// return null;
		Random rand = new Random();
		int seatno = rand.nextInt(61);

		jdbcTemplate.update("insert into seating values (?,?,?,?)", product.getFlight_id(), product.getPassengerid(),
				product.getPassenger_name(), seatno);
		return product;
	}

}
