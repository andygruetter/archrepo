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
        @NamedQuery(name = Application.findAll, query = "Select a from Application a")
        )

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Application extends BuildingBlock {

    public static final String PREFIX = "org.pragarch.archrepo.business.isa.entity.";
    public static final String findAll = PREFIX + "findAllApplications";

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Interface> providedInterfaces;

    public Application() {
    }

    public Application(String shortName) {
        super(shortName);
    }
    
    

    public void addProvidedInterface(Interface providedInterface){
        if(this.providedInterfaces==null){
           this.providedInterfaces = new HashSet<Interface>();
        }
        this.providedInterfaces.add(providedInterface);
    }
    
    
    public Set<Interface> getProvidedInterfaces() {
        return providedInterfaces;
    }

    public void setProvidedInterfaces(Set<Interface> providedInterfaces) {
        this.providedInterfaces = providedInterfaces;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.providedInterfaces);
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
        final Application other = (Application) obj;
        if (!Objects.equals(this.providedInterfaces, other.providedInterfaces)) {
            return false;
        }
        return true;
    }

}
