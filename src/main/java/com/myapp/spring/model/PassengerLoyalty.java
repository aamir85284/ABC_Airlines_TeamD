package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loyalty_points")
public class PassengerLoyalty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer passengerid;
	private Integer flightid;

	private String passengername;
	private Integer loyaltypoints;

	public PassengerLoyalty() {

	}
	public PassengerLoyalty(Integer flightid, Integer passengerid, String passengername, Integer loyaltypoints) {
		this.flightid = flightid;
		this.passengerid = passengerid;
		this.passengername = passengername;
		this.loyaltypoints = loyaltypoints;
	}
	public Integer getFlightid() {
		return flightid;
	}

	public Integer getLoyaltypoints() {
		return loyaltypoints;
	}

	

	public void setLoyaltypoints(Integer loyaltypoints) {
		this.loyaltypoints = loyaltypoints;
	}

	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}

	public Integer getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(Integer passengerid) {
		this.passengerid = passengerid;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

}
