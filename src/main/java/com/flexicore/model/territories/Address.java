package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@Entity
public class Address extends Baseclass {

	static private Address s_Singleton = new Address();
	private int floor;
	@ManyToOne(targetEntity = Street.class)
	private Street street;
	private int number;


	static public Address s() {
		return s_Singleton;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@ManyToOne(targetEntity = Street.class)
	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


}