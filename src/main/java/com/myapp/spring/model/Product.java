package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ABCAirlines_TeamD")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightId;
	private String passengerName;
	private String flightTime;
	private String flightDate;
	private Integer seatNo;
	private String departure;
	private String arrival;
	private Integer seatAvailable;
	private Integer passengerSeat;
	private Integer baggageId;
	private Integer loyaltypoints;
	private Integer passengerID;

	public Product() {

	}

	/**
	 * @param productName
	 * @param price
	 * @param description
	 */

	public Integer getFlightId() {
		return flightId;
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
	public Product(Integer flightId, String passengerName, String flightTime, String flightDate, Integer seatNo,
			String departure, String arrival, Integer seatAvailable, Integer passengerSeat, Integer baggageId,
			Integer loyaltypoints, Integer passengerID) {
		this.flightId = flightId;
		this.passengerName = passengerName;
		this.flightTime = flightTime;
		this.flightDate = flightDate;
		this.seatNo = seatNo;
		this.departure = departure;
		this.arrival = arrival;
		this.seatAvailable = seatAvailable;
		this.passengerSeat = passengerSeat;
		this.baggageId = baggageId;
		this.loyaltypoints = loyaltypoints;
		this.passengerID = passengerID;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Integer getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(Integer seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public Integer getPassengerSeat() {
		return passengerSeat;
	}

	public void setPassengerSeat(Integer passengerSeat) {
		this.passengerSeat = passengerSeat;
	}

	public Integer getBaggageId() {
		return baggageId;
	}

	public void setBaggageId(Integer baggageId) {
		this.baggageId = baggageId;
	}

	public Integer getLoyaltypoints() {
		return loyaltypoints;
	}

	public void setLoyaltypoints(Integer loyaltypoints) {
		this.loyaltypoints = loyaltypoints;
	}

	public Integer getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(Integer passengerID) {
		this.passengerID = passengerID;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

}
