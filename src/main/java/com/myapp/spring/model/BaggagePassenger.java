package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ABC_Baggage")
public class BaggagePassenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightid;
	private Integer passengerid;
	private String passengername;
	private String baggages;

	public BaggagePassenger() {
	}

	public BaggagePassenger(Integer flightid, Integer passengerid, String passengername, String baggages) {
		this.flightid = flightid;
		this.passengerid = passengerid;
		this.passengername = passengername;
		this.baggages = baggages;
	}

	public Integer getFlightid() {
		return flightid;
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

	public void addBaggageid(Integer id) {
		baggages += ", " + Integer.toString(id);
	}

	public void setBaggages(String str) {
		baggages = str;
	}

	public String getBaggages() {
		return baggages;
	}
}
