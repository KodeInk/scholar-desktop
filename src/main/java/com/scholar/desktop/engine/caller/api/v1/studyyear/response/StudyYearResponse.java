/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response;

/**
 *
 * @author mover 12/20/2017
 */
public class StudyYearResponse {

    private Integer id;
    private String theme;
    private Long start_date;
    private Long end_date;
    private String status;
    private String author;
    private Long date_created;

    public StudyYearResponse() {
    }

    public StudyYearResponse(Integer id) {
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

    public Long getStart_date() {
        return start_date;
    }

    public void setStart_date(Long start_date) {
        this.start_date = start_date;
    }

    public Long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Long end_date) {
        this.end_date = end_date;
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

    @Override
    public String toString() {
        return "StudyYearResponse{"
                + "id=" + id
                + ", theme=" + theme
                + ", start_date=" + start_date
                + ", end_date=" + end_date
                + ", status=" + status
                + ", author_id=" + author
                + ", date_created=" + date_created
                + "}";
    }

}
