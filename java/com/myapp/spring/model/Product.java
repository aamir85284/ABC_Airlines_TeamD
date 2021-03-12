package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ABC_TeamD")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flight_id;
	private String passenger_name;
	private String flight_time;
	private String flight_date;
	private Integer seat_no;
	private String departure;
	private String arrival;
	private Integer passenger_seat;
	private Integer passengerid;

	public Product() {

	}

	/**
	 * @param productName
	 * @param price
	 * @param description
	 */

	public Integer getflight_id() {
		return flight_id;
	}

	/**
	 * @param flightId
	 * @param passengerName
	 * @param flightTime
	 * @param flightDate
	 * @param seatNo
	 * @param departure
	 * @param arrival
	 * @param seatAvailable
	 * @param passengerSeat
	 * @param baggageId
	 * @param loyaltypoints
	 * @param passengerID
	 */
	public Product(Integer flight_id, String passenger_name, String flight_time, String flight_date, Integer seat_no,
			String departure, String arrival, Integer passenger_seat, Integer passengerid) {
		this.flight_id = flight_id;
		this.passenger_name = passenger_name;
		this.flight_time = flight_time;
		this.flight_date = flight_date;
		this.seat_no = seat_no;
		this.departure = departure;
		this.arrival = arrival;
		this.passenger_seat = passenger_seat;
		this.passengerid = passengerid;
	}

	public String getpassenger_name() {
		return passenger_name;
	}

	public void setpassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public String getflight_time() {
		return flight_time;
	}

	public void setflight_time(String flight_time) {
		this.flight_time = flight_time;
	}

	public String getflight_date() {
		return flight_date;
	}

	public void setflight_date(String flight_date) {
		this.flight_date = flight_date;
	}

	public Integer getseat_no() {
		return seat_no;
	}

	public void setseat_no(Integer seat_no) {
		this.seat_no = seat_no;
	}

	public String getdeparture() {
		return departure;
	}

	public void setdeparture(String departure) {
		this.departure = departure;
	}

	public String getarrival() {
		return arrival;
	}

	public void setarrival(String arrival) {
		this.arrival = arrival;
	}

	public Integer getPassenger_seat() {
		return passenger_seat;
	}

	public void setPassenger_seat(Integer passenger_seat) {
		this.passenger_seat = passenger_seat;
	}

	public Integer getpassengerid() {
		return passengerid;
	}

	public void setpassengerid(Integer passengerid) {
		this.passengerid = passengerid;
	}

	public void setflight_id(Integer flight_id) {
		this.flight_id = flight_id;
	}

}