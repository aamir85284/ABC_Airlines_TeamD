package com.myapp.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Product;

@Repository // It's a data Repository Class
public class PassengerRepositoryImpl implements PassengerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Home Page
	@Override
	public Product findAll(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from abc_teamd where passengerid=?",
				new BeanPropertyRowMapper<>(Product.class), id);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		// return null;
		jdbcTemplate.update("UPDATE FlightId SET FlightId=? WHERE passengerID=?", product.getflight_id(),
				product.getpassengerid());
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		// return null;
		jdbcTemplate.update("UPDATE FlightId SET FlightId=? WHERE passengerID=?", product.getflight_id(),
				product.getpassengerid());
		return product;
	}

//	@Override
//	public String welcome() {
//		return "<html><body>" + "<h1>WELCOME</h1>" + "</body></html>";
//	}

}