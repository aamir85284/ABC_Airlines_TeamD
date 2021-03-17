package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seating")

public class Seating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer flightid;

	private Integer passengerid;

	private String passengername;

	private Integer seatno;

	public Seating() {
		
	}
public Seating(Integer flightid, Integer passengerid, String passengername, Integer seatno) {
		this.flightid = flightid;
		this.passengerid = passengerid;
		this.passengername = passengername;
		this.seatno = seatno;
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

	public Integer getSeatno() {
		return seatno;
	}

	public void setSeatno(Integer seatno) {
		this.seatno = seatno;
	}

}
