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
 * @author mboullouz
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class AgentUser extends User implements Serializable {
    
    private Collection<CleanRequest> cleanRequests;

    public Collection<CleanRequest> getCleanRequests() {
        return cleanRequests;
    }

    public void setCleanRequests(Collection<CleanRequest> cleanRequests) {
        this.cleanRequests = cleanRequests;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentUser)) {
            return false;
        }
        AgentUser other = (AgentUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinooxe.models.AgentUser[ id=" + id + " ]";
    }
    
}
