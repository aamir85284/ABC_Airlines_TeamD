package com.myapp.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;

@RestController
@Repository
public class PassengerRepositoryImpl implements PassengerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public String welcome() {
		return "<html><body>" + "<h1>WELCOME</h1>" + "</body></html>";
	}

	@Override
	@GetMapping("/flight/{id}")
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from abcairlines_teamd where flight_id = ?",
				new BeanPropertyRowMapper<>(Product.class), id);

	}

}

//---------------------------------------------------------

//@RestController
//public class PassengerRepositoryImpl {
//	@Autowired
//	private PassengerRepository repo;
//
//	// Home Page
//	@GetMapping("/")
//	public String welcome() {
//		return "<html><body>" + "<h1>WELCOME</h1>" + "</body></html>";
//	}
//
//	@GetMapping("/passenger/{id}")
//	public Product getCompanyById(@PathVariable(value = "id") int id) {
//		return repo.findById(id);
//	}
//
//}