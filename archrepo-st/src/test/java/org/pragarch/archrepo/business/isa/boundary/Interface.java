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
class Interface extends BuildingBlock {

    private Set<Application> consumerApplications;

    public Interface() {
    }

    public Interface(String shortName) {
        super(shortName);
    }

    public Set<Application> getConsumers() {
        return consumerApplications;
    }

    public void setConsumers(Set<Application> consumers) {
        this.consumerApplications = consumers;
    }

}
