/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ag
 */
@Entity
@NamedQueries(
        @NamedQuery(name = Domain.findAll, query = "Select d from Domain d")
        )

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Domain extends BuildingBlock {

    
    public static final String PREFIX = "org.pragarch.archrepo.business.isa.entity.";
    public static final String findAll = PREFIX + "findAllDomains";
    
    public Domain() {
    }
 
    public Domain (String shortName) {
        super(shortName);
    }

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Application> applications;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Domain> subDomains;
    
    
    public void addApplication(Application application){
        if(this.applications==null){
           this.applications = new HashSet<Application>();
        }
        this.applications.add(application);
    }

    public void addSubDomain(Domain subDomain){
        if(this.subDomains==null){
           this.subDomains = new HashSet<>();
        }
        this.subDomains.add(subDomain);
    }
    
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
