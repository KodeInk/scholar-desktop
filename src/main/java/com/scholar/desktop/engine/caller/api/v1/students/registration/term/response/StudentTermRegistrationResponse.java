/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.students.registration.term.response;

import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.response.TermResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.streams.response.StreamResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.response.StudentAdmissionResponse;

/**
 *
 * @author mover 6/16/2018
 */
public class StudentTermRegistrationResponse {

    private Integer id;
    private StudentAdmissionResponse admission;
    private TermResponse studentTerm;
    private ClassResponse studentClass;
    private StreamResponse studentStream;
    private Long date_created;
    private Long date_registered;
    private String status;
    private String author;

    public StudentTermRegistrationResponse() {
    }

    public StudentTermRegistrationResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentAdmissionResponse getAdmission() {
        return admission;
    }

    public void setAdmission(StudentAdmissionResponse admission) {
        this.admission = admission;
    }

    public TermResponse getStudentTerm() {
        return studentTerm;
    }

    public void setStudentTerm(TermResponse studentTerm) {
        this.studentTerm = studentTerm;
    }

    public ClassResponse getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(ClassResponse studentClass) {
        this.studentClass = studentClass;
    }

    public StreamResponse getStudentStream() {
        return studentStream;
    }

    public void setStudentStream(StreamResponse studentStream) {
        this.studentStream = studentStream;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getDate_created() {
        return date_created;
    }

    public void setDate_created(Long date_created) {
        this.date_created = date_created;
    }

    public Long getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(Long date_registered) {
        this.date_registered = date_registered;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.admission);
        hash = 41 * hash + Objects.hashCode(this.studentTerm);
        hash = 41 * hash + Objects.hashCode(this.studentClass);
        hash = 41 * hash + Objects.hashCode(this.studentStream);
        hash = 41 * hash + Objects.hashCode(this.date_created);
        hash = 41 * hash + Objects.hashCode(this.date_registered);
        hash = 41 * hash + Objects.hashCode(this.status);
        hash = 41 * hash + Objects.hashCode(this.author);
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
        final StudentTermRegistrationResponse other = (StudentTermRegistrationResponse) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.admission, other.admission)) {
            return false;
        }
        if (!Objects.equals(this.studentTerm, other.studentTerm)) {
            return false;
        }
        if (!Objects.equals(this.studentClass, other.studentClass)) {
            return false;
        }
        if (!Objects.equals(this.studentStream, other.studentStream)) {
            return false;
        }
        if (!Objects.equals(this.date_created, other.date_created)) {
            return false;
        }
        return Objects.equals(this.date_registered, other.date_registered);
    }

    @Override
    public String toString() {
        return "StudentTermRegistrationResponse{"
                + "id=" + id
                + ", admission=" + admission
                + ", studentTerm=" + studentTerm
                + ", studentClass=" + studentClass
                + ", studentStream=" + studentStream
                + ", date_created=" + date_created
                + ", date_registered=" + date_registered
                + ", status=" + status
                + ", author=" + author
                + '}';
    }

}
