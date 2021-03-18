
package com.myapp.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Checkin;

@Repository // It's a data Repository Class
public class CheckinRepositoryImpl implements CheckinRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Checkin findById(Integer id) {

		return jdbcTemplate.queryForObject("select * from check_in where flightid=?",
				new BeanPropertyRowMapper<>(Checkin.class), id);
	}
}
