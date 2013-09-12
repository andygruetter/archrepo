/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pragarch.archrepo.business.isa.entity.Application;
import org.pragarch.archrepo.business.isa.entity.Domain;

/**
 *
 * @author ag
 */
@Stateless
public class ISAManager {

    @PersistenceContext
    EntityManager em;

    public List domains() {
        return this.em.createNamedQuery(Domain.findAll).getResultList();
    }

    public Domain getDomain(String shortName) {
        return this.em.find(Domain.class, shortName);
    }

    public Domain saveDomain(Domain domain) {
        return this.em.merge(domain);
    }

    public void deleteDomain(String shortName) {
        Domain d = this.em.getReference(Domain.class, shortName);
        this.em.remove(d);
    }

    public List applications() {
        return this.em.createNamedQuery(Application.findAll).getResultList();
    }

    public Application getApplication(String shortName) {
        return this.em.find(Application.class, shortName);
    }

    public Application saveApplication(Application application) {
        return this.em.merge(application);
    }

    void deleteApplication(String shortName) {
        Application a = this.em.getReference(Application.class, shortName);
        this.em.remove(a);
    }

}
