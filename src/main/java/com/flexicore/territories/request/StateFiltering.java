package com.flexicore.territories.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.territories.Country;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class StateFiltering extends FilteringInformationHolder {

	@OneToMany(targetEntity = CountryIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Streets", refType = Country.class)
	private Set<CountryIdRef> countriesIds =new HashSet<>();
	@JsonIgnore
	@Transient
	private List<Country> countries;

	@OneToMany(targetEntity = CountryIdRef.class, mappedBy = "filteringInformationHolder")
	@IdRefFieldInfo(displayName = "Streets", refType = Country.class)
	public Set<CountryIdRef> getCountriesIds() {
		return countriesIds;
	}

	public <T extends StateFiltering> T setCountriesIds(Set<CountryIdRef> countryId) {
		this.countriesIds = countryId;
		return (T) this;
	}

	@JsonIgnore
	@Transient
	public List<Country> getCountries() {
		return countries;
	}

	public <T extends StateFiltering> T setCountries(List<Country> countries) {
		this.countries = countries;
		return (T) this;
	}
}