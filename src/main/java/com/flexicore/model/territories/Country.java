package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Country extends Baseclass {

	static private Country s_Singleton = new Country();
	static public Country s() {
		return s_Singleton;
	}

	public Country() {
	}

	public Country(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = City.class, mappedBy = "country")
	@JsonIgnore
	private List<City> citys = new ArrayList<>();


	@OneToMany(targetEntity = City.class, mappedBy = "country")
	@JsonIgnore
	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
}