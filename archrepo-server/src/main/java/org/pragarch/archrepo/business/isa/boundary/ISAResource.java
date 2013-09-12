/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pragarch.archrepo.business.isa.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import org.pragarch.archrepo.business.isa.entity.Application;
import org.pragarch.archrepo.business.isa.entity.Domain;

/**
 *
 * @author U114792
 */
@Stateless
@Path("isa")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class ISAResource {

    @Inject
    ISAManager isaManager;

    @POST
    @Path("domains")
    public Response createDomain(Domain domain, @Context UriInfo info) {
        Domain createdDomain = isaManager.saveDomain(domain);
        UriBuilder path = info.getRequestUriBuilder().path(String.valueOf(createdDomain.getShortName()));
        return Response.created(path.build((Object) null)).build();
    }

    @PUT
    @Path("domains")
    public Response saveDomain(Domain domain, @Context UriInfo info) {
        Domain createdDomain = isaManager.saveDomain(domain);
        UriBuilder path = info.getRequestUriBuilder().path(String.valueOf(createdDomain.getShortName()));
        return Response.created(path.build((Object) null)).build();
    }

    @DELETE
    @Path("domains/{shortName}")
    public Response deleteDomain(@PathParam("shortName") String shortName) {
        isaManager.deleteDomain(shortName);
        return Response.ok().build();
    }

    @GET
    @Path("domains/{shortName}")
    public Domain getDomain(@PathParam("shortName") String shortName) {
        return isaManager.getDomain(shortName);
    }

    @GET
    @Path("domains")
    public List<Domain> domains() {
        return isaManager.domains();
    }

    @POST
    @Path("applications")
    public Response createApplication(Application application, @Context UriInfo info) {
        Application createdApplication = isaManager.saveApplication(application);
        UriBuilder path = info.getRequestUriBuilder().path(String.valueOf(createdApplication.getShortName()));
        return Response.created(path.build((Object) null)).build();
    }

    @PUT
    @Path("applications")
    public Response saveApplication(Application application, @Context UriInfo info) {
        Application createdApplication = isaManager.saveApplication(application);
        UriBuilder path = info.getRequestUriBuilder().path(String.valueOf(createdApplication.getShortName()));
        return Response.created(path.build((Object) null)).build();
    }

    @DELETE
    @Path("applications/{shortName}")
    public Response deleteApplication(@PathParam("shortName") String shortName) {
        isaManager.deleteApplication(shortName);
        return Response.ok().build();
    }

    @GET
    @Path("applications")
    public List<Application> applications() {
        return isaManager.applications();
    }

    @GET
    @Path("applications/{shortName}")
    public Application getApplication(@PathParam("shortName") String shortName) {
        return isaManager.getApplication(shortName);
    }
}
