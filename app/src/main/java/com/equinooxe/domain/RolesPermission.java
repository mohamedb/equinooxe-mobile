package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class RolesPermission implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;

    private String permission;

    private String roleName;
    
    public RolesPermission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getPermission() {
        return permission;
    }

    public String getRoleName() {
        return roleName;
    }
 

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
