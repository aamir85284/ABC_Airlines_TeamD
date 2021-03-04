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
//} ------------------------------------------------------------------

//@RestController
//@Repository
//public class PassengerRepositoryImpl {
//	// @Autowired
//	private PassengerRepository passengerService;
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@GetMapping("/")
//	public String welcome() {
//		return "<html><body>" + "<h1>WELCOME</h1>" + "</body></html>";
//	}
//
//	@GetMapping("/{passenger-id}")
//	public @ResponseBody Product findById(@PathVariable("passenger-id") String passengerId) {
//		return passengerService.findById(passengerId);
//	}
//
//}
//-------------------------------------------------------

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

	// Home Page

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		// return null;
		return jdbcTemplate.query("select * from abc_teamd", new BeanPropertyRowMapper<>(Product.class));
	}

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
