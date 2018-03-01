/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.config.entities;

import java.util.Objects;

/**
 *
 * @author mover 2/16/2018
 */
public class Engine {

    private String url;
    private String port;
    private String protocol;

    public Engine() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.url);
        hash = 53 * hash + Objects.hashCode(this.port);
        hash = 53 * hash + Objects.hashCode(this.protocol);
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
        final Engine other = (Engine) obj;
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.port, other.port)) {
            return false;
        }
        return Objects.equals(this.protocol, other.protocol);
    }

    @Override
    public String toString() {
        return "Engine{"
                + "url=" + url
                + ", port=" + port
                + ", protocol=" + protocol
                + "}";
    }

}
