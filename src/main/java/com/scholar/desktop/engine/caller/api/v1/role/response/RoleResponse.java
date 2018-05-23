/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.role.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Arrays;
import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.permissions.response.PermissionsResponse;

/**
 *
 * @author Mover 11/22/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.code);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + (this.isSystem ? 1 : 0);
        hash = 97 * hash + Arrays.deepHashCode(this.permissions);
        hash = 97 * hash + Objects.hashCode(this.dateCreated);
        hash = 97 * hash + Objects.hashCode(this.author);
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
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Arrays.deepEquals(this.permissions, other.permissions)) {
            return false;
        }
        return Objects.equals(this.dateCreated, other.dateCreated);
    }

    @Override
    public String toString() {
        return "RoleResponse{"
                + "id=" + id 
                + ", name=" + name
                + ", code=" + code 
                + ", description=" + description
                + ", isSystem=" + isSystem 
                + ", permissions=" + permissions
                + ", dateCreated=" + dateCreated 
                + ", author=" + author 
                + '}';
    }
    
     
}
