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

import java.sql.Date;
import java.util.Collection;


/**
 *
 * @author mohamed
 */

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CleanRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date startAt;
    private  Date deadlineDate;
    private Date doneAt;

    private String instructions;

    private String status;

    private AgentUser agent;

    private ManagerUser manager;

    private Collection<CleanTask> cleanTasks;

    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  Date getStartAt() {
        return startAt;
    }

    public void setStartAt( Date startAt) {
        this.startAt = startAt;
    }

    public  Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate( Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public Date getDoneAt() {
        return doneAt;
    }

    public void setDoneAt( Date  doneAt) {
        this.doneAt = doneAt;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AgentUser getAgent() {
        return agent;
    }

    public void setAgent(AgentUser agent) {
        this.agent = agent;
    }

    public ManagerUser getManager() {
        return manager;
    }

    public void setManager(ManagerUser manager) {
        this.manager = manager;
    }

    public Collection<CleanTask> getCleanTasks() {
        return cleanTasks;
    }

    public void setCleanTasks(Collection<CleanTask> cleanTasks) {
        this.cleanTasks = cleanTasks;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
        if (!(object instanceof CleanRequest)) {
            return false;
        }
        CleanRequest other = (CleanRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinooxe.nettoyage.model.DemandeNettoyage[ id=" + id + " ]";
    }

}
