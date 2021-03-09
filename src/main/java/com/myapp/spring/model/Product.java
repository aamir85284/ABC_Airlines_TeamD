package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loyalty_points")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flight_id;

	private Integer passengerid;

	private String passenger_name;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param flight_id
	 * @param passengerid
	 * @param passenger_name
	 * @param seatno
	 */

	public Integer getFlight_id() {
		return flight_id;
	}

	/**
	 * @param flight_id
	 * @param passengerid
	 * @param passenger_name
	 * @param loyatly_points
	 */
	public Product(Integer flight_id, Integer passengerid, String passenger_name) {
		this.flight_id = flight_id;
		this.passengerid = passengerid;
		this.passenger_name = passenger_name;

	}

	public void setFlight_id(Integer flight_id) {
		this.flight_id = flight_id;
	}

	public Integer getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(Integer passengerid) {
		this.passengerid = passengerid;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

}
