package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.PassengerLoyalty;

@Repository // It's a data Repository Class
public class PassengerLoyaltyRepositoryImpl implements PassengerLoyaltyRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PassengerLoyalty saveProduct(PassengerLoyalty product) {
		// TODO Auto-generated method stub
		// return null;

		jdbcTemplate.update("insert into loyalty_points(flightid, passengername, passengerid) values (?,?,?)",
				product.getFlightid(), product.getPassengername(), product.getPassengerid());
		return product;
	}

	@Override
	public List<PassengerLoyalty> findAll(String product) {
		// TODO Auto-generated method stub
		// return null;
		return jdbcTemplate.query("select passengername from loyalty_points where passengername = ?",
				new BeanPropertyRowMapper<>(PassengerLoyalty.class), product);
	}

	@Override
	public PassengerLoyalty updateProduct(PassengerLoyalty product) {
		// TODO Auto-generated method stub
		// return null;
		jdbcTemplate.update("UPDATE loyalty_points SET loyaltypoints=? WHERE passengerid=?", product.getLoyaltypoints(),
				product.getPassengerid());
		return product;
	}

	@Override
	public PassengerLoyalty findById(Integer id) {
		// TODO Auto-generated method stub

		return jdbcTemplate.queryForObject("select * from loyalty_points where passengerid=?",
				new BeanPropertyRowMapper<>(PassengerLoyalty.class), id);

	}

}
