/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.services.abstracts;

/**
 *
 * @author mover 2/28/2018
 */
public class AbstractService extends Offsets implements AbstractServiceInterface {

    public AbstractService() {
    }

    @Override
    public void IncreaseOffsetLimit() {
        offset = limit;
        limit = limit++;
    }

}
