package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ABC_TeamD")
public class Boarding {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightid;
	private String passengername;
	private String flighttime;
	private String flightdate;
	private Integer seatno;
	private String departure;
	private String arrival;
	private Integer passengerseat;
	private Integer passengerid;

	public Boarding() {

	}
	public Boarding(Integer flightid, String passengername, String flighttime, String flightdate, Integer seatno,
			String departure, String arrival, Integer passengerseat, Integer passengerid) {
		this.flightid = flightid;
		this.passengername = passengername;
		this.flighttime = flighttime;
		this.flightdate = flightdate;
		this.seatno = seatno;
		this.departure = departure;
		this.arrival = arrival;
		this.passengerseat = passengerseat;
		this.passengerid = passengerid;
	}


	public Integer getflightid() {
		return flightid;
	}

	

	public String getpassengername() {
		return passengername;
	}

	public void setpassengername(String passengername) {
		this.passengername = passengername;
	}

	public String getflighttime() {
		return flighttime;
	}

	public void setflighttime(String flighttime) {
		this.flighttime = flighttime;
	}

	public String getflightdate() {
		return flightdate;
	}

	public void setflightdate(String flightdate) {
		this.flightdate = flightdate;
	}

	public Integer getseatno() {
		return seatno;
	}

	public void setseatno(Integer seatno) {
		this.seatno = seatno;
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

	public Integer getPassengerseat() {
		return passengerseat;
	}

	public void setPassengerseat(Integer passengerseat) {
		this.passengerseat = passengerseat;
	}

	public Integer getpassengerid() {
		return passengerid;
	}

	public void setpassengerid(Integer passengerid) {
		this.passengerid = passengerid;
	}

	public void setflightid(Integer flightid) {
		this.flightid = flightid;
	}

}
