package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reference_data")
public class ReferenceProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer passengerid;
	private String currency;
	private String city;
	private String aircraft;
	private String arrival;
	private String destination;
	private String country;

	private String passengername;

	public ReferenceProduct() {

	}
public ReferenceProduct(Integer passengerid, String currency, String city, String aircraft, String arrival,
			String destination, String country, String passengername) {
		this.passengerid = passengerid;
		this.currency = currency;
		this.city = city;
		this.aircraft = aircraft;
		this.arrival = arrival;
		this.destination = destination;
		this.country = country;
		this.passengername = passengername;
	}
	

	public Integer getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(Integer passengerid) {
		this.passengerid = passengerid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

}
