package com.flexicore.model.territories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Neighbourhood extends Basic {


	public Neighbourhood() {
	}


	private String externalId;
	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;

	@OneToMany(targetEntity = Address.class, mappedBy = "neighbourhood", cascade = {
			CascadeType.MERGE, CascadeType.PERSIST})
	@JsonIgnore
	private List<Address> addresses = new ArrayList<>();

	@ManyToOne(targetEntity = City.class)
	private City city;

	@ManyToOne(targetEntity = City.class)
	public City getCity() {
		return city;
	}

	public Neighbourhood setCity(City city) {
		this.city = city;
		return this;
	}

	@OneToMany(targetEntity = Address.class, mappedBy = "neighbourhood", cascade = {
			CascadeType.MERGE, CascadeType.PERSIST})
	@JsonIgnore
	public List<Address> getAddresses() {
		return addresses;
	}

	public Neighbourhood setAddresses(List<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public String getExternalId() {
		return externalId;
	}

	public Neighbourhood setExternalId(String externalId) {
		this.externalId = externalId;
		return this;
	}

	@ManyToOne(targetEntity = Baseclass.class)
	public Baseclass getSecurity() {
		return security;
	}

	public <T extends Neighbourhood> T setSecurity(Baseclass security) {
		this.security = security;
		return (T) this;
	}
}