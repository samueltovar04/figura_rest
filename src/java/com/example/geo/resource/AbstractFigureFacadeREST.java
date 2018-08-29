/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.geo.resource;

import com.example.geo.model.FigureModel;
import com.example.geo.service.FigureFactory;
import com.example.geo.service.FigureService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author stovar
 */
@Stateless
@Path("/figuras")
public class AbstractFigureFacadeREST {

    //@PersistenceContext(unitName = "figurarestapiPU")
   @EJB
   FigureService figure;
    //private EntityManager em;

    public AbstractFigureFacadeREST() {
    }

    @POST
    @Path("{tipo}/{valor}")
      @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(@PathParam("tipo") String tipo,@PathParam("valor") String valor,FigureModel entity) {
        try{
        FigureModel entities =  (FigureModel) FigureFactory.getFigure(Integer.parseInt(tipo), Double.parseDouble(valor));
        entities.setArea(entities.calculateArea());
        if(figure.create(entities)){
            return Response.status(Response.Status.OK.getStatusCode()).entity(entities).type(MediaType.APPLICATION_JSON).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(entities).type(MediaType.APPLICATION_JSON).build();
        }
        //response.setStatus(Response.Status.OK.getStatusCode());
      }catch(Exception ex){
          return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(ex.getMessage()).type(MediaType.APPLICATION_JSON).build();
          //response.setStatus(Response.Status..getStatusCode());
      }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, FigureModel entity) {
        figure.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        figure.remove(figure.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        return Response.status(Response.Status.OK.getStatusCode()).entity(figure.find(id)).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<FigureModel> findAll() {
        return figure.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FigureModel> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return figure.findRange(new int[]{from, to});
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(figure.count());
    }
    
}
