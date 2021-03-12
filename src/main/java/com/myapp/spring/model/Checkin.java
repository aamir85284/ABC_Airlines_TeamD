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
	private Integer flightId;
	private Integer passengerID;

	public Checkin() {

	}

	public Checkin(Integer flightId, Integer passengerID) {
		this.flightId = flightId;
		this.passengerID = passengerID;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public Integer getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(Integer passengerID) {
		this.passengerID = passengerID;
	}

}