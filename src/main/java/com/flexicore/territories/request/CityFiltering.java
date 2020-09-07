package com.flexicore.territories.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.territories.Country;
import com.flexicore.model.territories.State;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class CityFiltering extends FilteringInformationHolder {

	@OneToMany(targetEntity = CountryIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "countries", refType = Country.class)
	private Set<CountryIdRef> countriesIds =new HashSet<>();
	@JsonIgnore
	@Transient
	private List<Country> countries;

	@OneToMany(targetEntity = StateIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "states", refType = State.class)
	private Set<StateIdRef> statesIds =new HashSet<>();
	@JsonIgnore
	@Transient
	private List<State> states;


	@OneToMany(targetEntity = CountryIdRef.class, mappedBy = "filteringInformationHolder")

	public Set<CountryIdRef> getCountriesIds() {
		return countriesIds;
	}

	public <T extends CityFiltering> T setCountriesIds(Set<CountryIdRef> countriesIds) {
		this.countriesIds = countriesIds;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<Country> getCountries() {
		return countries;
	}

	public <T extends CityFiltering> T setCountries(List<Country> countries) {
		this.countries = countries;
		return (T) this;
	}

	@OneToMany(targetEntity = StateIdRef.class, mappedBy = "filteringInformationHolder")

	public Set<StateIdRef> getStatesIds() {
		return statesIds;
	}

	public <T extends CityFiltering> T setStatesIds(Set<StateIdRef> statesIds) {
		this.statesIds = statesIds;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<State> getStates() {
		return states;
	}

	public <T extends CityFiltering> T setStates(List<State> states) {
		this.states = states;
		return (T) this;
	}

	@Override
	public void prepareForSave() {
		super.prepareForSave();
		if(statesIds!=null){
			for (StateIdRef statesId : statesIds) {
				statesId.prepareForSave(this);
			}
		}
		if(countriesIds!=null){
			for (CountryIdRef countryIdRef : countriesIds) {
				countryIdRef.prepareForSave(this);
			}
		}
	}
}