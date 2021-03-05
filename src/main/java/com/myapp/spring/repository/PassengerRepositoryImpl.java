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
//	@Override
//	public List<Product> findAll() {
//		// TODO Auto-generated method stub
//		// return null;
//		return jdbcTemplate.query("select * from abc_teamd", new BeanPropertyRowMapper<>(Product.class));
//	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from abc_teamd where flight_id=?",
				new BeanPropertyRowMapper<>(Product.class), id);
	}

//	@Override
//	public String welcome() {
//		return "<html><body>" + "<h1>WELCOME</h1>" + "</body></html>";
//	}

}