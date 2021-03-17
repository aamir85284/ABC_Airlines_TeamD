package com.myapp.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Passenger;

@Repository // It's a data Repository Class
public class ManageRepositoryImpl implements ManageRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Passenger updateProductCurrency(Passenger product) {

		jdbcTemplate.update("UPDATE reference_data SET currency=? WHERE passengerid=?", product.getCurrency(),
				product.getPassengerid());
		return product;
	}

	@Override
	public Passenger updateProductCity(Passenger product) {

		jdbcTemplate.update("UPDATE reference_data SET city=? WHERE passengerid=?", product.getCity(),
				product.getPassengerid());
		return product;
	}

	@Override
	public Passenger updateProductAircraft(Passenger product) {

		jdbcTemplate.update("UPDATE reference_data SET aircraft=? WHERE passengerid=?", product.getAircraft(),
				product.getPassengerid());
		return product;
	}

	@Override
	public Passenger updateProductArrival(Passenger product) {

		jdbcTemplate.update("UPDATE reference_data SET arrival=? WHERE passengerid=?", product.getArrival(),
				product.getPassengerid());
		return product;
	}

	@Override
	public Passenger updateProductDestination(Passenger product) {

		jdbcTemplate.update("UPDATE reference_data SET destination=? WHERE passengerid=?", product.getDestination(),
				product.getPassengerid());
		return product;
	}

	@Override
	public Passenger updateProductCountry(Passenger product) {

		jdbcTemplate.update("UPDATE reference_data SET country=? WHERE passengerid=?", product.getCountry(),
				product.getPassengerid());
		return product;
	}

	@Override
	public Passenger findById(Integer id) {

		return jdbcTemplate.queryForObject("select * from reference_data where passengerid=?",
				new BeanPropertyRowMapper<>(Passenger.class), id);

	}

}
