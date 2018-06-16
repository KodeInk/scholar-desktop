/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.students.admissions.response;

 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.Terms.response.TermResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.response.ClassResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.classes.streams.response.StreamResponse;
import main.java.com.scholar.desktop.engine.caller.api.v1.profile.response.ProfileResponse;

/**
 *
 * @author mover 12/30/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentAdmissionResponse {

  
    private Integer id;   
    private String admission_no;
    private Long date_of_admission;
    private String external_id;
    private TermResponse admissionTerm;
    private ClassResponse admissionClass;
    private StreamResponse admissionStream;
    private String status;
    private Long date_created;
    private String author;
    private ProfileResponse student;

    public StudentAdmissionResponse() {
    }

    public StudentAdmissionResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public String getAdmission_no() {
        return admission_no;
    }

    public void setAdmission_no(String admission_no) {
        this.admission_no = admission_no;
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

    public TermResponse getAdmissionTerm() {
        return admissionTerm;
    }

    public void setAdmissionTerm(TermResponse admissionTerm) {
        this.admissionTerm = admissionTerm;
    }

    public ClassResponse getAdmissionClass() {
        return admissionClass;
    }

    public void setAdmissionClass(ClassResponse admissionClass) {
        this.admissionClass = admissionClass;
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

    public ProfileResponse getStudent() {
        return student;
    }

    public void setStudent(ProfileResponse student) {
        this.student = student;
    }

    public StreamResponse getAdmissionStream() {
        return admissionStream;
    }

    public void setAdmissionStream(StreamResponse admissionStream) {
        this.admissionStream = admissionStream;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
       
        hash = 89 * hash + Objects.hashCode(this.admission_no);
        hash = 89 * hash + Objects.hashCode(this.date_of_admission);
        hash = 89 * hash + Objects.hashCode(this.external_id);
        hash = 89 * hash + Objects.hashCode(this.admissionTerm);
        hash = 89 * hash + Objects.hashCode(this.admissionClass);
        hash = 89 * hash + Objects.hashCode(this.status);
        hash = 89 * hash + Objects.hashCode(this.date_created);
        hash = 89 * hash + Objects.hashCode(this.author);
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
        final StudentAdmissionResponse other = (StudentAdmissionResponse) obj;
        if (!Objects.equals(this.admission_no, other.admission_no)) {
            return false;
        }
        if (!Objects.equals(this.external_id, other.external_id)) {
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
       
        if (!Objects.equals(this.date_of_admission, other.date_of_admission)) {
            return false;
        }
        if (!Objects.equals(this.admissionTerm, other.admissionTerm)) {
            return false;
        }
        if (!Objects.equals(this.admissionClass, other.admissionClass)) {
            return false;
        }
        return Objects.equals(this.date_created, other.date_created);
    }

    @Override
    public String toString() {
        return "StudentAdmissionResponse{"
                + "id=" + id              
                + ", admission_number=" + admission_no
                + ", date_of_admission=" + date_of_admission
                + ", external_id=" + external_id
                + ", term_response=" + admissionTerm
                + ", class_response=" + admissionClass
                + ", status=" + status
                + ", date_created=" + date_created
                + ", author=" + author
                + "}";
    }

}
