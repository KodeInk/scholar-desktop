/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.staff.request;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mover 3/16/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Staff {

    private Integer id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String prefix;
    private Date dateofbirth;
    private String image;
    private StatusEnum status;
    private Long date_created;
    private Integer author_id;

    public Staff() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Long getDate_created() {
        return date_created;
    }

    public void setDate_created(Long date_created) {
        this.date_created = date_created;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.firstname);
        hash = 71 * hash + Objects.hashCode(this.middlename);
        hash = 71 * hash + Objects.hashCode(this.lastname);
        hash = 71 * hash + Objects.hashCode(this.prefix);
        hash = 71 * hash + Objects.hashCode(this.dateofbirth);
        hash = 71 * hash + Objects.hashCode(this.image);
        hash = 71 * hash + Objects.hashCode(this.status);
        hash = 71 * hash + Objects.hashCode(this.date_created);
        hash = 71 * hash + Objects.hashCode(this.author_id);
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
        final Staff other = (Staff) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.middlename, other.middlename)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.prefix, other.prefix)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateofbirth, other.dateofbirth)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.date_created, other.date_created)) {
            return false;
        }
        return Objects.equals(this.author_id, other.author_id);
    }


    @Override
    public String toString() {
        return "_Staff{"
                + "id=" + id
                + ", firstname=" + firstname
                + ", middlename=" + middlename
                + ", lastname=" + lastname
                + ", prefix=" + prefix
                + ", dateofbirth=" + dateofbirth
                + ", image=" + image
                + ", status=" + status
                + ", date_created=" + date_created
                + ", author_id=" + author_id
                + '}';
    }

}
