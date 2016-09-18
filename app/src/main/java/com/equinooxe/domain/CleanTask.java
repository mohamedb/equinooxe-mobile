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


/**
 *
 * @author mohamed
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class CleanTask implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    private String name;

    private String description;

    private boolean done;

    private CleanRequest cleanRequest;
    
    private TaskDefinition taskDefinition;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public CleanRequest getCleanRequest() {
        return cleanRequest;
    }

    public void setCleanRequest(CleanRequest cleanRequest) {
        this.cleanRequest = cleanRequest;
    }

    public TaskDefinition getTaskDefinition() {
        return taskDefinition;
    }

    public void setTaskDefinition(TaskDefinition taskDefinition) {
        this.taskDefinition = taskDefinition;
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
        if (!(object instanceof CleanTask)) {
            return false;
        }
        CleanTask other = (CleanTask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinooxe.nettoyage.model.Tache[ id=" + id + " ]";
    }

}
