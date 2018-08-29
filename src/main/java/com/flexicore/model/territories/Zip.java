package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Zip extends Baseclass {

	static private Zip s_Singleton = new Zip();
	@OneToMany(targetEntity = ZipToStreet.class, mappedBy = "leftside")
	@JsonIgnore
	private List<ZipToStreet> zipToStreets = new ArrayList<>();

	static public Zip s() {
		return s_Singleton;
	}

	@OneToMany(targetEntity = ZipToStreet.class, mappedBy = "leftside")
	@JsonIgnore
	public List<ZipToStreet> getZipToStreets() {
		return zipToStreets;
	}

	public void setZipToStreets(List<ZipToStreet> zipToStreets) {
		this.zipToStreets = zipToStreets;
	}
}