/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.classes.response;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.streams.response.StreamResponse;

/**
 *
 * @author mover
 */
public class ClassResponse {

    private Integer id;
    private String name;
    private String code;
    private Integer ranking;
    private String status;
    private Long date_created;
    private String author;
    private StreamResponse[] streamResponses;

    public ClassResponse() {
    }

    public ClassResponse(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDate_created() {
        return date_created;
    }

    public void setDate_created(Long date_created) {
        this.date_created = date_created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public StreamResponse[] getStreamResponses() {
        return streamResponses;
    }

    public void setStreamResponses(StreamResponse[] streamResponses) {
        this.streamResponses = streamResponses;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.code);
        hash = 97 * hash + Objects.hashCode(this.ranking);
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.date_created);
        hash = 97 * hash + Objects.hashCode(this.author);
        hash = 97 * hash + Arrays.deepHashCode(this.streamResponses);
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
        final ClassResponse other = (ClassResponse) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
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
        return Arrays.deepEquals(this.streamResponses, other.streamResponses);
    }

    @Override
    public String toString() {
        return "ClassResponse{"
                + "id=" + id
                + ", name=" + name
                + ", code=" + code
                + ", ranking=" + ranking
                + ", stream=" + Arrays.toString(streamResponses)
                + ", status=" + status
                + ", date_created=" + date_created
                + ", author=" + author
                + "}";
    }

}
