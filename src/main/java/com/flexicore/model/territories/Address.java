package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Address extends Basic {



	private int floorForAddress;
	@ManyToOne(targetEntity = Street.class)
	private Street street;

	@ManyToOne(targetEntity = Neighbourhood.class)
	private Neighbourhood neighbourhood;
	private String zipCode;
	private int number;
	private String externalId;
	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;

	public Address() {
	}

	public int getFloorForAddress() {
		return floorForAddress;
	}

	public void setFloorForAddress(int floorForAddress) {
		this.floorForAddress = floorForAddress;
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

	@ManyToOne(targetEntity = Neighbourhood.class)
	public Neighbourhood getNeighbourhood() {
		return neighbourhood;
	}

	public Address setNeighbourhood(Neighbourhood neighbourhood) {
		this.neighbourhood = neighbourhood;
		return this;
	}

	public String getExternalId() {
		return externalId;
	}

	public <T extends Address> T setExternalId(String externalId) {
		this.externalId = externalId;
		return (T) this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public <T extends Address> T setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return (T) this;
	}

	@ManyToOne(targetEntity = Baseclass.class)
	public Baseclass getSecurity() {
		return security;
	}

	public <T extends Address> T setSecurity(Baseclass security) {
		this.security = security;
		return (T) this;
	}
}