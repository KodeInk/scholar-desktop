/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.config.entities;

import java.util.Objects;
import main.java.com.scholar.desktop.engine.caller.api.v1.user.response.AuthenticationResponse;

/**
 *
 * @author mover 2/9/2018
 */
public class SchoolData {

    private AuthenticationResponse authentication;
    private String schoolname;
    private Engine engine;


    public SchoolData() {
    }

    public AuthenticationResponse getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationResponse authentication) {
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

    /**
     *
     * @return
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     *
     * @param engine
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.authentication);
        hash = 31 * hash + Objects.hashCode(this.schoolname);
        hash = 31 * hash + Objects.hashCode(this.engine);
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
        if (!Objects.equals(this.schoolname, other.schoolname)) {
            return false;
        }
        return Objects.equals(this.engine, other.engine);
    }


    @Override
    public String toString() {
        return "SchoolData{"
                + "authentication=" + authentication
                + ", schoolname=" + schoolname
                + '}';
    }



}
