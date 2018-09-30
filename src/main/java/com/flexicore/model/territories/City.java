package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class City extends Baseclass {

	static private City s_Singleton = new City();
	@ManyToOne(targetEntity = Country.class)
	private Country country;
	@OneToMany(targetEntity = Street.class, mappedBy = "city")
	@JsonIgnore
	private List<Street> streets = new ArrayList<>();
	@OneToMany(targetEntity = Neighbourhood.class, mappedBy = "city")
	@JsonIgnore
	private List<Neighbourhood> neighbourhoods=new ArrayList<>();

	static public City s() {
		return s_Singleton;
	}

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
}