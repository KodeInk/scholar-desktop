/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.request;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.request.Profile;

/**
 *
 * @author mover 12/30/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class _StudentAdmission {

    private Integer id;
    private String admission_number;
    private Long date_of_admission;
    private String external_id;
    private Integer term_id;
    private Integer stream_id;
    private Integer class_id;
    private StatusEnum status;
    private Long date_created;
    private Integer author_id;
    private Profile profile;

    public _StudentAdmission() {
    }

    public _StudentAdmission(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmission_number() {
        return admission_number;
    }

    public void setAdmission_number(String admission_number) {
        this.admission_number = admission_number;
    }

    public Long getDate_of_admission() {
        return date_of_admission;
    }

    public void setDate_of_admission(Long date_of_admission) {
        this.date_of_admission = date_of_admission;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public Integer getTerm_id() {
        return term_id;
    }

    public void setTerm_id(Integer term_id) {
        this.term_id = term_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Integer getStream_id() {
        return stream_id;
    }

    public void setStream_id(Integer stream_id) {
        this.stream_id = stream_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.admission_number);
        hash = 59 * hash + Objects.hashCode(this.date_of_admission);
        hash = 59 * hash + Objects.hashCode(this.external_id);
        hash = 59 * hash + Objects.hashCode(this.term_id);
        hash = 59 * hash + Objects.hashCode(this.stream_id);
        hash = 59 * hash + Objects.hashCode(this.class_id);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.date_created);
        hash = 59 * hash + Objects.hashCode(this.author_id);
        hash = 59 * hash + Objects.hashCode(this.profile);
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
        final _StudentAdmission other = (_StudentAdmission) obj;
        if (!Objects.equals(this.admission_number, other.admission_number)) {
            return false;
        }
        if (!Objects.equals(this.external_id, other.external_id)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        if (!Objects.equals(this.date_of_admission, other.date_of_admission)) {
            return false;
        }
        if (!Objects.equals(this.term_id, other.term_id)) {
            return false;
        }
        if (!Objects.equals(this.stream_id, other.stream_id)) {
            return false;
        }
        if (!Objects.equals(this.class_id, other.class_id)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.date_created, other.date_created)) {
            return false;
        }
        if (!Objects.equals(this.author_id, other.author_id)) {
            return false;
        }
        if (!Objects.equals(this.profile, other.profile)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_StudentAdmission{"
                + "id=" + id
                + ", admission_number=" + admission_number
                + ", date_of_admission=" + date_of_admission
                + ", external_id=" + external_id
                + ", term_id=" + term_id
                + ", stream_id=" + stream_id
                + ", class_id=" + class_id
                + ", status=" + status
                + ", date_created=" + date_created
                + ", author_id=" + author_id
                + ", profile=" + profile
                + "}";
    }

}
