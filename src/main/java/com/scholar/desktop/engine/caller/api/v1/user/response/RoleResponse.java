/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user.response;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Mover 11/22/2017
 */
public class RoleResponse {

    private Integer id;
    private String name;
    private String code;
    private String description;
    private boolean isSystem;
    private PermissionsResponse[] permissions;
    private Long dateCreated;
    private String author;

    public RoleResponse() {
    }

    public RoleResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public boolean isIsSystem() {
        return isSystem;
    }

    public void setIsSystem(boolean isSystem) {
        this.isSystem = isSystem;
    }

    public PermissionsResponse[] getPermissions() {
        return permissions;
    }

    public void setPermissions(PermissionsResponse[] permissions) {
        this.permissions = permissions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.code);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + (this.isSystem ? 1 : 0);
        hash = 37 * hash + Arrays.deepHashCode(this.permissions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoleResponse other = (RoleResponse) obj;
        if (this.isSystem != other.isSystem) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Arrays.deepEquals(this.permissions, other.permissions);
    }

    @Override
    public String toString() {
        return "RoleResponse{"
                + "id=" + id
                + ", name=" + name
                + ", description=" + description
                + ", isSystem=" + isSystem
                + ", permissions=" + Arrays.asList(permissions)
                + ", code=" + code
                + "}";
    }

}
