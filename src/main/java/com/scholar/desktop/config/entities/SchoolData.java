/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.config.entities;

import java.util.Objects;

/**
 *
 * @author mover 2/9/2018
 */
public class SchoolData {

    private String authentication;
    private String schoolname;


    public SchoolData() {
    }

    /**
     *
     * @return
     */
    public String getAuthentication() {
        return authentication;
    }

    /**
     *
     * @param authentication
     */
    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    /**
     *
     * @return
     */
    public String getSchoolname() {
        return schoolname;
    }

    /**
     *
     * @param schoolname
     */
    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.authentication);
        hash = 71 * hash + Objects.hashCode(this.schoolname);
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
        final SchoolData other = (SchoolData) obj;
        if (!Objects.equals(this.authentication, other.authentication)) {
            return false;
        }
        return Objects.equals(this.schoolname, other.schoolname);
    }

    @Override
    public String toString() {
        return "SchoolData{"
                + "authentication=" + authentication
                + ", schoolname=" + schoolname
                + '}';
    }



}
