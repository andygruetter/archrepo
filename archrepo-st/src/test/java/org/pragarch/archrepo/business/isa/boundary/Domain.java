/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.boundary;

import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ag
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Domain extends BuildingBlock {

    public Domain() {
    }

    public Domain(String shortName) {
        super(shortName);
    }

    private Set<Application> applications;

    private Set<Domain> subDomains;

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    public Set<Domain> getSubDomains() {
        return subDomains;
    }

    public void setSubDomains(Set<Domain> subDomains) {
        this.subDomains = subDomains;
    }

     
    
    

}
