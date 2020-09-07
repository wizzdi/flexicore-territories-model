package com.flexicore.territories.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class AptNumberRef {

    @Id
    private String filterId;

    @FieldInfo(displayName = "string",description = "string filter",mandatory = true)
    private int id;
    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    private FilteringInformationHolder filteringInformationHolder;

    public AptNumberRef() {
    }

    //@ApiModelProperty("Id of the Baseclass")
    public int getId() {
        return id;
    }


    public AptNumberRef setId(int id) {
        this.id = id;
        return this;
    }

    public AptNumberRef(int id) {
        this.id = id;
    }

    @Id
    public String getFilterId() {
        return filterId;
    }

    public AptNumberRef setFilterId(String filterId) {
        this.filterId = filterId;
        return this;
    }

    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    public FilteringInformationHolder getFilteringInformationHolder() {
        return filteringInformationHolder;
    }

    public AptNumberRef setFilteringInformationHolder(FilteringInformationHolder filteringInformationHolder) {
        this.filteringInformationHolder = filteringInformationHolder;
        return this;
    }

    public void prepareForSave(FilteringInformationHolder filteringInformationHolder) {
        filterId = Baseclass.getBase64ID();
        this.filteringInformationHolder = filteringInformationHolder;

    }
}
