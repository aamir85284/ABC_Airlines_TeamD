package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

		jdbcTemplate.update("insert into loyalty_points values (?,?,?)", product.getFlight_id(),
				product.getPassenger_name(), product.getPassengerid());
		return product;
	}

	@Override
	public List<Product> findAll(String product) {
		// TODO Auto-generated method stub
		// return null;
		return jdbcTemplate.query("select passenger_name from loyalty_points where passenger_name = ?",
				new BeanPropertyRowMapper<>(Product.class), product);
	}

}
