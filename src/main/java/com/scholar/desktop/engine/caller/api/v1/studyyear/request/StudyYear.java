/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.request;

import com.codemovers.scholar.engine.helper.enums.StatusEnum;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mover 12/20/2017
 */
public class StudyYear {

    private Integer id;
    private String theme;
    private Date start_date;
    private Date end_date;
    private StatusEnum status;
    private Integer author_id;
    private Date date_created;

    public StudyYear() {
    }

    public StudyYear(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.theme);
        hash = 73 * hash + Objects.hashCode(this.start_date);
        hash = 73 * hash + Objects.hashCode(this.end_date);
        hash = 73 * hash + Objects.hashCode(this.status);
        hash = 73 * hash + Objects.hashCode(this.author_id);
        hash = 73 * hash + Objects.hashCode(this.date_created);
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
        final StudyYear other = (StudyYear) obj;
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.start_date, other.start_date)) {
            return false;
        }
        if (!Objects.equals(this.end_date, other.end_date)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.author_id, other.author_id)) {
            return false;
        }
        return Objects.equals(this.date_created, other.date_created);
    }

    @Override
    public String toString() {
        return "_StudyYear{"
                + "id=" + id
                + ", theme=" + theme
                + ", start_date=" + start_date
                + ", end_date=" + end_date
                + ", status=" + status
                + ", author_id=" + author_id
                + ", date_created=" + date_created
                + "}";
    }

}
