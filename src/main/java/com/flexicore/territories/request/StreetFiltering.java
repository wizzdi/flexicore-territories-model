package com.flexicore.territories.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.territories.City;
import com.flexicore.model.territories.Country;
import com.flexicore.model.territories.Neighbourhood;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class StreetFiltering extends FilteringInformationHolder {

	@OneToMany(targetEntity = StreetIdRef.class, mappedBy = "filteringInformationHolder")
	@ListFieldInfo(displayName = "external ids", listType = StreetIdRef.class)
	private Set<StreetIdRef> externalIds=new HashSet<>();

	@OneToMany(targetEntity = CityIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Cities",refType = City.class)
	private Set<CityIdRef> citiesIds=new HashSet<>();
	@JsonIgnore
	@Transient
	private List<City> cities;

	@OneToMany(targetEntity = NeighbourhoodIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Neighbourhoods",refType = Neighbourhood.class)
	private Set<NeighbourhoodIdRef> neighbourhoodsIds=new HashSet<>();
	@JsonIgnore
	@Transient
	private List<Neighbourhood> neighbourhoods;

	@OneToMany(targetEntity = CountryIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Countries",refType = Country.class)
	private Set<CountryIdRef> countriesIds=new HashSet<>();

	@JsonIgnore
	@Transient
	private List<Country> countries;


	@OneToMany(targetEntity = StreetIdRef.class, mappedBy = "filteringInformationHolder")
	@ListFieldInfo(displayName = "external ids", listType = StreetIdRef.class)
	public Set<StreetIdRef> getExternalIds() {
		return externalIds;
	}

	public <T extends StreetFiltering> T setExternalIds(Set<StreetIdRef> externalIds) {
		this.externalIds = externalIds;
		return (T) this;
	}

	@OneToMany(targetEntity = CityIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Cities",refType = City.class)
	public Set<CityIdRef> getCitiesIds() {
		return citiesIds;
	}

	public <T extends StreetFiltering> T setCitiesIds(Set<CityIdRef> citiesIds) {
		this.citiesIds = citiesIds;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<City> getCities() {
		return cities;
	}

	public <T extends StreetFiltering> T setCities(List<City> cities) {
		this.cities = cities;
		return (T) this;
	}

	@OneToMany(targetEntity = NeighbourhoodIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Neighbourhoods",refType = Neighbourhood.class)
	public Set<NeighbourhoodIdRef> getNeighbourhoodsIds() {
		return neighbourhoodsIds;
	}

	public <T extends StreetFiltering> T setNeighbourhoodsIds(Set<NeighbourhoodIdRef> neighbourhoodsIds) {
		this.neighbourhoodsIds = neighbourhoodsIds;
		return (T) this;
	}

	public List<Neighbourhood> getNeighbourhoods() {
		return neighbourhoods;
	}

	public <T extends StreetFiltering> T setNeighbourhoods(List<Neighbourhood> neighbourhoods) {
		this.neighbourhoods = neighbourhoods;
		return (T) this;
	}

	@OneToMany(targetEntity = CountryIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Countries",refType = Country.class)
	public Set<CountryIdRef> getCountriesIds() {
		return countriesIds;
	}


	public <T extends StreetFiltering> T setCountriesIds(Set<CountryIdRef> countriesIds) {
		this.countriesIds = countriesIds;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<Country> getCountries() {
		return countries;
	}

	public <T extends StreetFiltering> T setCountries(List<Country> countries) {
		this.countries = countries;
		return (T) this;
	}
}