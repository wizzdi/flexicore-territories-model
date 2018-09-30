package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Street extends Baseclass {

	static private Street s_Singleton = new Street();
	static public Street s() {
		return s_Singleton;
	}

	private String externalId;

	@OneToMany(targetEntity = ZipToStreet.class, mappedBy = "rightside")
	@JsonIgnore
	private List<ZipToStreet> zipToStreets = new ArrayList<>();
	@ManyToOne(targetEntity = City.class)
	private City city;
	@OneToMany(targetEntity = Address.class, mappedBy = "street")
	@JsonIgnore
	private List<Address> addresss = new ArrayList<>();


	@OneToMany(targetEntity = ZipToStreet.class, mappedBy = "rightside")
	@JsonIgnore
	public List<ZipToStreet> getZipToStreets() {
		return zipToStreets;
	}

	public void setZipToStreets(List<ZipToStreet> zipToStreets) {
		this.zipToStreets = zipToStreets;
	}

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