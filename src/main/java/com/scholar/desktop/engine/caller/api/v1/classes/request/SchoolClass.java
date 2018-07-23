/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.classes.request;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.streams.request.Stream;

/**
 *
 * @author mover
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolClass {

    private Integer id;
    private String name;
    private String code;
    private Integer ranking;
    private StatusEnum status;
    private Date date_created;
    private Integer author_id;
    private Stream[] streams;

    public SchoolClass() {
    }

    public SchoolClass(Integer id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Stream[] getStreams() {
        return streams;
    }

    public void setStreams(Stream[] streams) {
        this.streams = streams;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.code);
        hash = 79 * hash + Objects.hashCode(this.ranking);
        hash = 79 * hash + Objects.hashCode(this.status);
        hash = 79 * hash + Objects.hashCode(this.date_created);
        hash = 79 * hash + Objects.hashCode(this.author_id);
        hash = 79 * hash + Arrays.deepHashCode(this.streams);
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
        final SchoolClass other = (SchoolClass) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ranking, other.ranking)) {
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
        if (!Arrays.deepEquals(this.streams, other.streams)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "_Class{"
                + "id=" + id
                + ", name=" + name
                + ", code=" + code
                + ", ranking=" + ranking
                + ", streams=" + streams
                + ", status=" + status
                + ", date_created=" + date_created
                + ", author_id=" + author_id
                + "}";
    }

}
