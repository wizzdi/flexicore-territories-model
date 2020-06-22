package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Street extends Baseclass {

	static private Street s_Singleton = new Street();
	static public Street s() {
		return s_Singleton;
	}

	public Street() {
	}

	public Street(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	private String externalId;

	@ManyToOne(targetEntity = City.class)
	private City city;
	@OneToMany(targetEntity = Address.class, mappedBy = "street")
	@JsonIgnore
	private List<Address> addresss = new ArrayList<>();

	@ManyToOne(targetEntity = City.class)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@OneToMany(targetEntity = Address.class, mappedBy = "street")
	@JsonIgnore
	public List<Address> getAddresss() {
		return addresss;
	}

	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}

	public String getExternalId() {
		return externalId;
	}

	public Street setExternalId(String externalId) {
		this.externalId = externalId;
		return this;
	}
}