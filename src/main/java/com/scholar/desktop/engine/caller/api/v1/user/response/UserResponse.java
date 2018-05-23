/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.user.response;

import java.util.Arrays;
import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.role.response.RoleResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.staff.response.StaffResponse;

/**
 *
 * @author Mover 11/22/2017
 */
public class UserResponse {

    private Integer id;
    private String username;
    private String status;
    private RoleResponse[] Roles;
    private String accounttype;
    private String emailaddress;
    private String authentication;
    private Long dateCreated;
    private ProfileResponse profile;
    private StaffResponse staff;

    public UserResponse() {
    }

    public UserResponse(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoleResponse[] getRoles() {
        return Roles;
    }

    public void setRoles(RoleResponse[] Roles) {
        this.Roles = Roles;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ProfileResponse getProfile() {
        return profile;
    }

    public void setProfile(ProfileResponse profile) {
        this.profile = profile;
    }

    public StaffResponse getStaff() {
        return staff;
    }

    public void setStaff(StaffResponse staff) {
        this.staff = staff;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.username);
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + Arrays.deepHashCode(this.Roles);
        hash = 61 * hash + Objects.hashCode(this.accounttype);
        hash = 61 * hash + Objects.hashCode(this.emailaddress);
        hash = 61 * hash + Objects.hashCode(this.authentication);
        hash = 61 * hash + Objects.hashCode(this.dateCreated);
        hash = 61 * hash + Objects.hashCode(this.profile);
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
        final UserResponse other = (UserResponse) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.accounttype, other.accounttype)) {
            return false;
        }
        if (!Objects.equals(this.emailaddress, other.emailaddress)) {
            return false;
        }
        if (!Objects.equals(this.authentication, other.authentication)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Arrays.deepEquals(this.Roles, other.Roles)) {
            return false;
        }
        if (!Objects.equals(this.dateCreated, other.dateCreated)) {
            return false;
        }
        return Objects.equals(this.profile, other.profile);
    }

    @Override
    public String toString() {
        return "UserResponse{"
                + "id=" + id
                + ", username=" + username
                + ", status=" + status
                + ", Roles=" + Arrays.asList(Roles)
                + ", accounttype=" + accounttype
                + ", emailaddress=" + emailaddress
                + ", authentication=" + authentication
                + ", dateCreated=" + dateCreated
                + ", profile=" + profile
                + ", staff=" + staff
                + "}";
    }

}
