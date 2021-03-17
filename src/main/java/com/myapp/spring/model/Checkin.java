package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Check_In")
public class Checkin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightid;
	private Integer passengerid;

	public Checkin() {

	}

	public Checkin(Integer flightid, Integer passengerid) {
		this.flightid = flightid;
		this.passengerid = passengerid;
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

}