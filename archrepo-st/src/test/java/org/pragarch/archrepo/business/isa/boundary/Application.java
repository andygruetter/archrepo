/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.boundary;

import java.util.Set;

/**
 *
 * @author ag
 */
public class Application extends BuildingBlock {

    private Set<Interface> providedInterfaces;

    public Application() {
    }

    public Application(String shortName) {
        super(shortName);
    }

    public Set<Interface> getProvidedInterfaces() {
        return providedInterfaces;
    }

    public void setProvidedInterfaces(Set<Interface> providedInterfaces) {
        this.providedInterfaces = providedInterfaces;
    }

}
