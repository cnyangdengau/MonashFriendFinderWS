/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST.service;

import TEST.Friendship;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Date;

/**
 *
 * @author Yang-Deng
 */
@Stateless
@Path("test.friendship")
public class FriendshipFacadeREST extends AbstractFacade<Friendship> {

    @PersistenceContext(unitName = "TESTFOR5046ASSPU")
    private EntityManager em;

    public FriendshipFacadeREST() {
        super(Friendship.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Friendship entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Friendship entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Friendship find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friendship> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //FIND by friendshipId
    @GET
    @Path("findByFriendshipId/{friendshipId}")
    @Produces({"application/json"})
    public List<Friendship> findByFriendshipId(@PathParam("friendshipId") Integer friendshipId){
        Query query = em.createNamedQuery("Friendship.findByFriendshipId");
        query.setParameter("friendshipId", friendshipId);
        return query.getResultList();
    }
    
    //FIND by FriendshipStartDate
    @GET
    @Path("findByFriendshipStartDate/{friendshipStartDate}")
    @Produces({"application/json"})
    public List<Friendship> findByFriendshipStartDate(@PathParam("friendshipStartDate") Date friendshipStartDate){
        Query query = em.createNamedQuery("Friendship.findByFriendshipStartDate");
        query.setParameter("friendshipStartDate", friendshipStartDate);
        return query.getResultList();
    }
    
    //FIND by FriendshipEndDate
    @GET
    @Path("findByFriendshipEndDate/{friendshipEndDate}")
    @Produces({"application/json"})
    public List<Friendship> findByFriendshipEndDate(@PathParam("friendshipEndDate") Date friendshipEndDate){
        Query query = em.createNamedQuery("Friendship.findByFriendshipEndDate");
        query.setParameter("friendshipEndDate", friendshipEndDate);
        return query.getResultList();
    }
    
    //findByStudentNumber1
    @GET
    @Path("findByStudentNumber1/{studentNumber1}")
    @Produces({"application/json"})
    public List<Friendship> findByStudentNumber1(@PathParam("studentNumber1") Integer studentNumber1){
        Query query = em.createNamedQuery("Friendship.findByStudentNumber1");
        query.setParameter("studentNumber1", studentNumber1);
        return query.getResultList();
    }
    
    //findByStudentNumber2
    @GET
    @Path("findByStudentNumber2/{studentNumber2}")
    @Produces({"application/json"})
    public List<Friendship> findByStudentNumber2(@PathParam("studentNumber2") Integer studentNumber2){
        Query query = em.createNamedQuery("Friendship.findByStudentNumber2");
        query.setParameter("studentNumber2", studentNumber2);
        return query.getResultList();
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
