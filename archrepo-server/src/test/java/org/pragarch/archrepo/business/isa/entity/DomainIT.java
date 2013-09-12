/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author ag
 */
public class DomainIT {

    private static EntityManager em;
    private static EntityTransaction tx;

    @BeforeClass
    public static void initalizeEm() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IT");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Test
    public void persist() {
        Domain expected = new Domain("ver");
        Domain sd1 = new Domain("sd1");
        expected.addSubDomain(sd1);
        Application a1 = new Application("app1");
        Interface i1 = new Interface("int1");
        a1.addProvidedInterface(i1);
        expected.addApplication(a1);
        
        this.tx.begin();
        this.em.merge(expected);
        this.tx.commit();
        
        this.em.clear();
        this.tx.begin();
        Domain actual = this.em.find(Domain.class, expected.getShortName());
        assertNotNull(actual);
        assertThat(actual.getShortName(), is(expected.getShortName()));
        assertNotNull(actual.getApplications());
        assertThat(actual.getApplications().size(), is(1));
        this.tx.commit();
        
        this.em.clear();
        this.tx.begin();
        actual.setName("domain1");
        actual = this.em.merge(actual);
        assertThat(actual.getName(), is("domain1"));
        this.tx.commit();
        
        this.em.clear();
        this.tx.begin();
        this.em.remove(this.em.getReference(Domain.class,"ver"));
        this.tx.commit();
        
        this.em.clear();
        this.tx.begin();
        List<Domain> result = this.em.createNamedQuery(Domain.findAll).getResultList();
        assertThat(result.size(), is(0));
        this.tx.commit();
        
        
        
        
    }

}
