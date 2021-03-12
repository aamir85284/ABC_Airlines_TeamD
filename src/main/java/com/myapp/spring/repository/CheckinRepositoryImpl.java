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
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from Check_In where flight_id=?",
				new BeanPropertyRowMapper<>(Checkin.class), id);
	}
}
