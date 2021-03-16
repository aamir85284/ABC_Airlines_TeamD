package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.BaggagePassenger;
import com.myapp.spring.repository.BaggageRepository;

@RestController
@RequestMapping("/passenger")

public class BaggagePassengerApi {
	@Autowired // ProductApi class has a dependency on ProductRepository interface
				// ProductApi is tightly coupled with ProductRepository
	private BaggageRepository repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// At runtime, it will search for the ProductRepository type object i.e, all
	// classes implementing this interface
	@PostMapping("/Baggages/{id}/{bno}")
	public BaggagePassenger saveNewProduct(@RequestBody BaggagePassenger product, @PathVariable("bno") Integer bno) {
		return repository.saveProduct(product, bno);
	}

	@GetMapping("/{id}/baggages")
	public String findById(@PathVariable("id") Integer productid) {

		// Product existingProduct =repository.findById(productid);
		// List flightIdList = [1, 2];

		try {

			String query1 = "select passenger_name from abc_baggage where flight_id=?";
			Object[] inputs1 = new Object[] { productid };
			String empName = jdbcTemplate.queryForObject(query1, String.class, inputs1);

			String query = "select baggages from abc_baggage where flight_id=?";
			Object[] inputs = new Object[] { productid };
			String Baggageids = jdbcTemplate.queryForObject(query, String.class, inputs);

			// return Integer.toString(empName);
			return "<html><body>" + "<h1> Here's Your Baggage Details " + empName + " </h1><br> <h3>Your Baggage id :- "
					+ Baggageids + "</body></html>";

		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>Baggage Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
					+ "</body></html>";
		}

	}

}
