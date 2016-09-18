/*
 * Copyright (C) 2016 Mohamed Boullouz.
 *
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of AppNH Project
 */
package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author mohamed
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;
    private String adresse;
    private String description;

    private Collection<LocationGroup> groupements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Collection<LocationGroup> getGroupements() {
        return groupements;
    }

    public void setGroupements(Collection<LocationGroup> groupements) {
        this.groupements = groupements;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinooxe.infra.model.Etablissement[ id=" + id + " ]";
    }

}
