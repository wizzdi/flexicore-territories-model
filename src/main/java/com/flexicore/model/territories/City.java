package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Basic;

import java.util.ArrayList;
import java.util.List;

@Entity
public class City extends Basic {

	public City() {
	}


	private String externalId;

	@ManyToOne(targetEntity = Country.class)
	private Country country;
	@ManyToOne
	private State state;
	@OneToMany(targetEntity = Street.class, mappedBy = "city")
	@JsonIgnore
	private List<Street> streets = new ArrayList<>();
	@OneToMany(targetEntity = Neighbourhood.class, mappedBy = "city")
	@JsonIgnore
	private List<Neighbourhood> neighbourhoods = new ArrayList<>();
	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;

	@ManyToOne(targetEntity = Country.class)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@OneToMany(targetEntity = Street.class, mappedBy = "city")
	@JsonIgnore
	public List<Street> getStreets() {
		return streets;
	}

	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}

	@OneToMany(targetEntity = Neighbourhood.class, mappedBy = "city")
	@JsonIgnore
	public List<Neighbourhood> getNeighbourhoods() {
		return neighbourhoods;
	}

	public City setNeighbourhoods(List<Neighbourhood> neighbourhoods) {
		this.neighbourhoods = neighbourhoods;
		return this;
	}

	public String getExternalId() {
		return externalId;
	}

	public City setExternalId(String externalId) {
		this.externalId = externalId;
		return this;
	}

	@ManyToOne(targetEntity = State.class)
	public State getState() {
		return state;
	}

	public <T extends City> T setState(State state) {
		this.state = state;
		return (T) this;
	}

	@ManyToOne(targetEntity = Baseclass.class)
	public Baseclass getSecurity() {
		return security;
	}

	public <T extends City> T setSecurity(Baseclass security) {
		this.security = security;
		return (T) this;
	}
}