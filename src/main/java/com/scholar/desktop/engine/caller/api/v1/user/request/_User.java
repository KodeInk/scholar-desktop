/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user.request;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author MOver 11/19/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class _User {

    private Integer id;
    private String username;
    private String password;
    private String emailaddress;
    private StatusEnum status;
    private String externalid;
    private String date_created;
    private String[] roles;

    public _User() {
    }

    public _User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getExternalid() {
        return externalid;
    }

    public void setExternalid(String externalid) {
        this.externalid = externalid;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.emailaddress);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.externalid);
        hash = 59 * hash + Objects.hashCode(this.date_created);
        hash = 59 * hash + Arrays.deepHashCode(this.roles);
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
        final _User other = (_User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.emailaddress, other.emailaddress)) {
            return false;
        }
        if (!Objects.equals(this.externalid, other.externalid)) {
            return false;
        }
        if (!Objects.equals(this.date_created, other.date_created)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return Arrays.deepEquals(this.roles, other.roles);
    }

    @Override
    public String toString() {
        return "_User{"
                + "id=" + id
                + ", username=" + username
                + ", password=" + password
                + ", emailaddress=" + emailaddress
                + ", status=" + status
                + ", externalid=" + externalid
                + ", date_created=" + date_created
                + ", roles=" + Arrays.asList(roles)
                + "}";
    }

}
