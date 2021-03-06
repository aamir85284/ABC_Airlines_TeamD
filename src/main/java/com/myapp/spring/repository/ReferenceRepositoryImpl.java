package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.ReferenceProduct;

@Repository // It's a data Repository Class
public class ReferenceRepositoryImpl implements ReferenceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ReferenceProduct saveProduct(ReferenceProduct product) {

		jdbcTemplate.update("insert into reference_data values(?,?,?,?,?,?,?,?)", product.getPassengerid(),
				product.getAircraft(), product.getArrival(), product.getCity(), product.getCountry(),
				product.getCurrency(), product.getDestination(), product.getPassengername());
		return product;
	}

	@Override
	public List<ReferenceProduct> findAll() {

		return jdbcTemplate.query("select * from reference_data", new BeanPropertyRowMapper<>(ReferenceProduct.class));
	}

	@Override
	public ReferenceProduct findAll(Integer id) {

		return jdbcTemplate.queryForObject("select * from reference_data where passengerid= ?",
				new BeanPropertyRowMapper<>(ReferenceProduct.class), id);
	}

}
