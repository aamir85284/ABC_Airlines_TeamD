CREATE TABLE abc_baggage (flightid int, baggages VARCHAR(40), passengerid int, passengername VARCHAR(40));
CREATE TABLE seating (flightid int, passengerid int, passengername VARCHAR(40), seatno int);
CREATE TABLE loyalty_points(passengerid int,flightid int, loyaltypoints int, passengername VARCHAR(40) );
CREATE TABLE abc_teamd (flightid int, arrival VARCHAR(40), departure VARCHAR(40), flightdate VARCHAR(40),flighttime VARCHAR(40), passengerid int, passengername VARCHAR(40), passengerseat int,seatno int);
CREATE TABLE reference_data(passengerid int, aircraft VARCHAR(40), arrival VARCHAR(40), city VARCHAR(40), country VARCHAR(40), currency VARCHAR(40), destination VARCHAR(40), passengername VARCHAR(40));
CREATE TABLE check_in(flightid int, passengerid int);