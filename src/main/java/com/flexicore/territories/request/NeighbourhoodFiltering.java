package com.flexicore.territories.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.territories.City;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class NeighbourhoodFiltering extends FilteringInformationHolder {

	@OneToMany(targetEntity = NeighbourhoodExternalIdRef.class, mappedBy = "filteringInformationHolder")
	@ListFieldInfo(displayName = "external ids", listType = NeighbourhoodExternalIdRef.class)
	private Set<NeighbourhoodExternalIdRef> externalIds=new HashSet<>();
	@OneToMany(targetEntity = CityIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Cities", refType = City.class)
	private Set<CityIdRef> citiesIds=new HashSet<>();
	@JsonIgnore
	@Transient
	private List<City> cities;


	@OneToMany(targetEntity = NeighbourhoodExternalIdRef.class, mappedBy = "filteringInformationHolder")
	public Set<NeighbourhoodExternalIdRef> getExternalIds() {
		return externalIds;
	}

	public <T extends NeighbourhoodFiltering> T setExternalIds(Set<NeighbourhoodExternalIdRef> externalIds) {
		this.externalIds = externalIds;
		return (T) this;
	}

	@OneToMany(targetEntity = CityIdRef.class, mappedBy = "filteringInformationHolder")
	public Set<CityIdRef> getCitiesIds() {
		return citiesIds;
	}

	public <T extends NeighbourhoodFiltering> T setCitiesIds(Set<CityIdRef> citiesIds) {
		this.citiesIds = citiesIds;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<City> getCities() {
		return cities;
	}

	public <T extends NeighbourhoodFiltering> T setCities(List<City> cities) {
		this.cities = cities;
		return (T) this;
	}
}