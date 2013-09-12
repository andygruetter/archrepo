/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ag
 */
@Entity

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
class Interface extends BuildingBlock{
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Application> consumerApplications;
    
    public Interface() {
    }

    public Interface(String shortName) {
        super(shortName);
    }
    
    public void addConsumerApplication(Application application){
        if(this.consumerApplications==null){
           this.consumerApplications = new HashSet<>();
        }
        this.consumerApplications.add(application);
    }

    public Set<Application> getConsumers() {
        return consumerApplications;
    }

    public void setConsumers(Set<Application> consumers) {
        this.consumerApplications = consumers;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.consumerApplications);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interface other = (Interface) obj;
        if (!Objects.equals(this.consumerApplications, other.consumerApplications)) {
            return false;
        }
        return true;
    }
    
    
    
}
