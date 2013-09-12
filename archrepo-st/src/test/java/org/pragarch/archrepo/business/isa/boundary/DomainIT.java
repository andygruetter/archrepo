/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.boundary;

import java.util.List;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.pragarch.archrepo.RESTSupport;

/**
 *
 * @author ag
 */
public class DomainIT extends RESTSupport{
    private String URI="http://localhost:8080/archrepo/resources/isa/domains";

    @Before
    @Override
    public void init() {
        super.init(URI);
    }
    
    
    @Test
    public void crudScriptDomain() {
        final String originId = "do1";
        
        Domain origin = new Domain(originId);

        //PUT
        Response response = super.mainTarget.request().put(entity(origin, MediaType.APPLICATION_XML));
        assertThat(response.getStatus(), is(Response.Status.CREATED.getStatusCode()));
        String location = (String) response.getHeaders().getFirst("Location");
        assertTrue(location.endsWith(originId));

        //GET
        Domain fetched = super.client.target(location).request(MediaType.APPLICATION_XML).get(Domain.class);
        assertThat(fetched.getShortName(), is(origin.getShortName()));

        //GET (ALL)
        GenericType<List<Domain>> list = new GenericType<List<Domain>>() {
        };
        List<Domain> result = super.mainTarget.request(MediaType.APPLICATION_XML).get(list);
        assertFalse(result.isEmpty());

        //DELETE
        response = super.mainTarget.path(originId).request().delete();
        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        //GET
        Response notExistingEntity = this.client.target(location).request(MediaType.APPLICATION_XML).get();
        assertThat(notExistingEntity.getStatus(), is(Response.Status.NO_CONTENT.getStatusCode()));
    }
    
    
    
    
}
