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
public class Country extends Basic {

	public Country() {
	}

	private String countryCode;
	@ManyToOne(targetEntity = Baseclass.class)
	private Baseclass security;




	@OneToMany(targetEntity = City.class, mappedBy = "country")
	@JsonIgnore
	private List<City> citys = new ArrayList<>();

	@OneToMany(targetEntity = State.class, mappedBy = "country")
	@JsonIgnore
	private List<State> states = new ArrayList<>();

	@OneToMany(targetEntity = City.class, mappedBy = "country")
	@JsonIgnore
	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public <T extends Country> T setCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return (T) this;
	}

	@OneToMany(targetEntity = State.class, mappedBy = "country")
	@JsonIgnore
	public List<State> getStates() {
		return states;
	}

	public <T extends Country> T setStates(List<State> states) {
		this.states = states;
		return (T) this;
	}

	@ManyToOne(targetEntity = Baseclass.class)
	public Baseclass getSecurity() {
		return security;
	}

	public <T extends Country> T setSecurity(Baseclass security) {
		this.security = security;
		return (T) this;
	}
}