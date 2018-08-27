/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.subjects.response;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.curriculum.response.CurriculumResponse;

/**
 *
 * @author mover 3/11/2018
 */
public class SubjectResponse {

    private Integer id;
    private String name;
    private String code;
    private String type;
    private String status;
    private Long date_created;
    private String author;
    private List<SubjectPaperResponse> subjectPaperResponses;
    private List<CurriculumResponse> curriculumResponses;

    public SubjectResponse() {
    }

    public SubjectResponse(Integer id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<SubjectPaperResponse> getSubjectPaperResponses() {
        return subjectPaperResponses;
    }

    public void setSubjectPaperResponses(List<SubjectPaperResponse> subjectPaperResponses) {
        this.subjectPaperResponses = subjectPaperResponses;
    }

    public List<CurriculumResponse> getCurriculumResponses() {
        return curriculumResponses;
    }

    public void setCurriculumResponses(List<CurriculumResponse> curriculumResponses) {
        this.curriculumResponses = curriculumResponses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.code);
        hash = 61 * hash + Objects.hashCode(this.type);
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + Objects.hashCode(this.date_created);
        hash = 61 * hash + Objects.hashCode(this.author);
        hash = 61 * hash + Objects.hashCode(this.subjectPaperResponses);
        hash = 61 * hash + Objects.hashCode(this.curriculumResponses);
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
        final SubjectResponse other = (SubjectResponse) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date_created, other.date_created)) {
            return false;
        }
        if (!Objects.equals(this.subjectPaperResponses, other.subjectPaperResponses)) {
            return false;
        }
        if (!Objects.equals(this.curriculumResponses, other.curriculumResponses)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SubjectResponse{"
                + "id=" + id
                + ", name=" + name
                + ", code=" + code
                + ", type=" + type
                + ", status=" + status
                + ", date_created=" + date_created
                + ", author=" + author
                + ", subjectPaperResponses=" + subjectPaperResponses
                + ", curriculumResponses=" + curriculumResponses
                + '}';
    }

}
