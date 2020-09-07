package com.flexicore.territories.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.territories.Street;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AddressFiltering extends FilteringInformationHolder {

    @OneToMany(targetEntity = FloorIdRef.class, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "Floor Numbers", listType = FloorIdRef.class)
    private Set<FloorIdRef> floors;
    @OneToMany(targetEntity = StreetIdRef.class, mappedBy = "filteringInformationHolder")
    @IdRefFieldInfo(displayName = "Streets", refType = Street.class)
    private Set<StreetIdRef> streetsIds = new HashSet<>();
    @JsonIgnore
    @Transient
    private List<Street> streets;
    @OneToMany(targetEntity = AptNumberRef.class, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "House Numbers", listType = AptNumberRef.class)
    private Set<AptNumberRef> numbers;
    @OneToMany(targetEntity = ZipCodeIdRef.class, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "zip codes", listType = ZipCodeIdRef.class)
    private Set<ZipCodeIdRef> zipCodes;
    @OneToMany(targetEntity = AddressExternalIdRef.class, mappedBy = "filteringInformationHolder")
    @ListFieldInfo(displayName = "external ids", listType = AddressExternalIdRef.class)
    private Set<AddressExternalIdRef> externalIds = new HashSet<>();

    @OneToMany(targetEntity = FloorIdRef.class, mappedBy = "filteringInformationHolder")
    public Set<FloorIdRef> getFloors() {
        return floors;
    }

    public <T extends AddressFiltering> T setFloors(Set<FloorIdRef> floors) {
        this.floors = floors;
        return (T) this;
    }

    @OneToMany(targetEntity = StreetIdRef.class, mappedBy = "filteringInformationHolder")

    public Set<StreetIdRef> getStreetsIds() {
        return streetsIds;
    }

    public <T extends AddressFiltering> T setStreetsIds(Set<StreetIdRef> streetsIds) {
        this.streetsIds = streetsIds;
        return (T) this;
    }

    @JsonIgnore
    @Transient
    public List<Street> getStreets() {
        return streets;
    }

    public <T extends AddressFiltering> T setStreets(List<Street> streets) {
        this.streets = streets;
        return (T) this;
    }

    @OneToMany(targetEntity = AptNumberRef.class, mappedBy = "filteringInformationHolder")

    public Set<AptNumberRef> getNumbers() {
        return numbers;
    }

    public <T extends AddressFiltering> T setNumbers(Set<AptNumberRef> numbers) {
        this.numbers = numbers;
        return (T) this;
    }

    @OneToMany(targetEntity = ZipCodeIdRef.class, mappedBy = "filteringInformationHolder")

    public Set<ZipCodeIdRef> getZipCodes() {
        return zipCodes;
    }

    public <T extends AddressFiltering> T setZipCodes(Set<ZipCodeIdRef> zipCodes) {
        this.zipCodes = zipCodes;
        return (T) this;
    }

    @OneToMany(targetEntity = AddressExternalIdRef.class, mappedBy = "filteringInformationHolder")

    public Set<AddressExternalIdRef> getExternalIds() {
        return externalIds;
    }

    public <T extends AddressFiltering> T setExternalIds(Set<AddressExternalIdRef> externalIds) {
        this.externalIds = externalIds;
        return (T) this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if (floors != null) {
            for (FloorIdRef floor : floors) {
                floor.prepareForSave(this);
            }
        }
        if (numbers != null) {
            for (AptNumberRef numbersdRef : numbers) {
                numbersdRef.prepareForSave(this);
            }
        }
        if (streetsIds != null) {
            for (StreetIdRef streetIdRef : streetsIds) {
                streetIdRef.prepareForSave(this);
            }
        }
        if (zipCodes != null) {
            for (ZipCodeIdRef zipCodeIdRef : zipCodes) {
                zipCodeIdRef.prepareForSave(this);
            }
        }
        if (externalIds != null) {
            for (AddressExternalIdRef addressExternalIdRef : externalIds) {
                addressExternalIdRef.prepareForSave(this);
            }
        }

    }
}