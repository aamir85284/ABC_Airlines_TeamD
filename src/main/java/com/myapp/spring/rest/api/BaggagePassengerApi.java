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
	@Autowired
	private BaggageRepository repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostMapping("/Baggages/{id}/{bno}")
	public BaggagePassenger saveNewProduct(@RequestBody BaggagePassenger product, @PathVariable("bno") Integer bno) {
		return repository.saveProduct(product, bno);
	}

	@GetMapping("/{id}/baggages")
	public String findById(@PathVariable("id") Integer productid) {

		try {

			String query1 = "select passengername from abc_baggage where flightid=?";
			Object[] inputs1 = new Object[] { productid };
			String empName = jdbcTemplate.queryForObject(query1, String.class, inputs1);

			String query = "select baggages from abc_baggage where flightid=?";
			Object[] inputs = new Object[] { productid };
			String Baggageids = jdbcTemplate.queryForObject(query, String.class, inputs);

			return "<html><body>" + "<h1> Here's Your Baggage Details " + empName + " </h1><br> <h3>Your Baggage id :- "
					+ Baggageids + "</body></html>";

		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>Baggage Details</h1><br> <h3>Your BookingID is not present in our database.<br>Unfortunatly your checkIn is NOT DONE</h3>"
					+ "</body></html>";
		}

	}

}
