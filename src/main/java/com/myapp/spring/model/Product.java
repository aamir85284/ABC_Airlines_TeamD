package com.myapp.spring.model;

public class Product {

	private Integer flight_id;

	private Integer passengerid;

	private String passenger_name;

	private Integer seatno;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param flight_id
	 * @param passengerid
	 * @param passenger_name
	 * @param seatno
	 */
	public Product(Integer flight_id, Integer passengerid, String passenger_name, Integer seatno) {
		this.flight_id = flight_id;
		this.passengerid = passengerid;
		this.passenger_name = passenger_name;
		this.seatno = seatno;
	}

	public Integer getFlight_id() {
		return flight_id;
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

	public Integer getSeatno() {
		return seatno;
	}

	public void setSeatno(Integer seatno) {
		this.seatno = seatno;
	}

}
