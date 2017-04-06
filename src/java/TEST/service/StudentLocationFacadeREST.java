/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST.service;

import TEST.StudentProfile;
import TEST.StudentLocation;
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
import java.sql.Timestamp;
import java.sql.*;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;



/**
 *
 * @author Yang-Deng
 */
@Stateless
@Path("test.studentlocation")
public class StudentLocationFacadeREST extends AbstractFacade<StudentLocation> {

    @PersistenceContext(unitName = "TESTFOR5046ASSPU")
    private EntityManager em;

    public StudentLocationFacadeREST() {
        super(StudentLocation.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StudentLocation entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, StudentLocation entity) {
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
    public StudentLocation find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentLocation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentLocation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //FIND by STUDENT LocationID
    @GET
    @Path("findbyLocationId/{locationId}")
    @Produces({"application/json"})
    public List<StudentLocation> findByLocationId(@PathParam("locationId") Integer locationId){
        Query query = em.createNamedQuery("StudentLocation.findByLocationId");
        query.setParameter("locationId", locationId);
        return query.getResultList();
    }
      
    //FIND by TimeStamp
    @GET
    @Path("findbyTimeStamp/{timeStamp}")
    @Produces({"application/json"})
    public List<StudentLocation> findByTimeStamp(@PathParam("timeStamp") Timestamp timeStamp){
        Query query = em.createNamedQuery("StudentLocation.findByTimeStamp");
        query.setParameter("timeStamp", timeStamp);
        return query.getResultList();
    }
    
    //FIND by Latitude
    @GET
    @Path("findbyLatitude/{latitude}")
    @Produces({"application/json"})
    public List<StudentLocation> findByLatitude(@PathParam("latitude") String latitude){
        Query query = em.createNamedQuery("StudentLocation.findByLatitude");
        query.setParameter("latitude", latitude);
        return query.getResultList();
    }
    
    //FIND by Longitude
    @GET
    @Path("findbyLongitude/{longitude}")
    @Produces({"application/json"})
    public List<StudentLocation> findByLongitude(@PathParam("longitude") String longitude){
        Query query = em.createNamedQuery("StudentLocation.findByLongitude");
        query.setParameter("longitude", longitude);
        return query.getResultList();
    }

    //FIND by LocationName
    @GET
    @Path("findbyLocationName/{locationName}")
    @Produces({"application/json"})
    public List<StudentLocation> findByLocationName(@PathParam("locationName") String locationName){
        Query query = em.createNamedQuery("StudentLocation.findByLocationName");
        query.setParameter("locationName", locationName);
        return query.getResultList();
    }
    
    //FIND by StudentNumber
    @GET
    @Path("findbyStudentNumber/{studentNumber}")
    @Produces({"application/json"})
    public List<StudentLocation> findByStudentNumber(@PathParam("studentNumber") Integer studentNumber){
        Query query = em.createNamedQuery("StudentLocation.findByStudentNumber");
        query.setParameter("studentNumber", studentNumber);
        return query.getResultList();
    }
    
    //Report Web Service A task3
    @GET
    @Path("ReportWSa/{startingdate}/{endingdate}/{studentnumber}")
    @Produces({"application/json"})
    public List<DisplayListForWSa> ReportWSa(@PathParam("startingdate") Date StartDate, @PathParam("endingdate") Date EndDate, @PathParam("studentnumber") Integer StuNumber) {
        // query to get studentlocation whose time between startingdate and endingdate
        TypedQuery<StudentLocation> q = em.createQuery("SELECT S FROM StudentLocation S WHERE S.studentNumber.studentNumber =:studentnumber AND S.timeStamp Between :startingdate AND :endingdate", StudentLocation.class);
        q.setParameter("startingdate", StartDate);
        q.setParameter("endingdate", EndDate);
        q.setParameter("studentnumber", StuNumber);
        List<StudentLocation> StudentLocationList = q.getResultList();
        // add the name of location stored in the List to a new location name list
        List<String> LocationNameList = new ArrayList<>();
        StudentLocationList.forEach((SL) -> {
            LocationNameList.add(SL.getLocationName());
        });
        // Create a HashMap to store location name and their frenquence
        Map<String,Integer> LocationNameCounter = new HashMap<>();
        
        LocationNameList.forEach((Lname) -> {
            Integer i = LocationNameCounter.get(Lname);
            if(i == null) LocationNameCounter.put(Lname, 1);
            else LocationNameCounter.put(Lname, i + 1);
        }); 
        
        //Create a Display List to output location name and frequence to the console
        List<DisplayListForWSa> dplist;
        dplist = new ArrayList();
        Iterator MapIterator = LocationNameCounter.keySet().iterator(); 
        while (MapIterator.hasNext()) { 
            String key = MapIterator.next().toString(); 
            Integer val = LocationNameCounter.get(key); 
            DisplayListForWSa dplistsample;
            dplistsample = new DisplayListForWSa(key,val);
            dplist.add(dplistsample);
        } 
        return dplist;
    }
    
    //Report Web Service B task3
    @GET
    @Path("ReportWSb/{latitude}/{longitude}/{studentnumber}")
    @Produces({"application/json"})
    public List<DisplayListForWSb> ReportWSb(@PathParam("latitude") String Latitude, @PathParam("longitude") String Longitude, @PathParam("studentnumber") Integer StuNumber) {
        //Firstly, get all the student except the one with studentnumber inputed
        TypedQuery<StudentProfile> ALL = em.createQuery("SELECT S FROM StudentProfile S WHERE S.studentNumber != :studentnumber", StudentProfile.class);
        ALL.setParameter("studentnumber", StuNumber);
        List<StudentProfile> Allstudents = ALL.getResultList();
        
        //Create a list stores all the locations wanted of student got above.
        List<StudentLocation> Alllocations = new ArrayList<StudentLocation>();
        for(StudentProfile single : Allstudents)
        {
            //iterate student stored in the list 
            // get his student number
            Integer studentnumber = single.getStudentNumber();
            // get his latest location by sort list and pop the first item.
            TypedQuery<StudentLocation> alllocations = em.createQuery("SELECT S FROM StudentLocation S WHERE S.studentNumber.studentNumber = :studentnumber ORDER BY S.timeStamp DESC", StudentLocation.class);
            alllocations.setParameter("studentnumber", studentnumber);
            StudentLocation latest = alllocations.getResultList().get(0);
            Alllocations.add(latest);
        }
        // get the target latitude and longitude
        Double TargetLatitude = Double.parseDouble(Latitude);
        Double TargetLongitude = Double.parseDouble(Longitude);
        
        // get the distance between Target location and others then store them to a HashMap
        HashMap<StudentLocation,Double> LocationCounter = new HashMap<StudentLocation,Double>();
        for(StudentLocation SL : Alllocations)
        {
            Double nonTargetLatitude = Double.parseDouble(SL.getLatitude());
            Double nonTargetLongitude = Double.parseDouble(SL.getLongitude());
            Double Distance = CalculateDistance.CalculateDistance(TargetLatitude, TargetLongitude, nonTargetLatitude, nonTargetLongitude);
            LocationCounter.put(SL, Distance);
        }
        
        // Sort the HashMap
        sortHashMapByValues use = new sortHashMapByValues();
        LinkedHashMap<StudentLocation, Double> SortedHashMap = use.sortHashMapByValues(LocationCounter);
        List<StudentLocation> LinkedHashMapKeys = new ArrayList<>(SortedHashMap.keySet());
        
        //Create a display list
        List<DisplayListForWSb> dplistb;
        dplistb = new ArrayList();
        
        int counter;
        // if the size exceed 10, just get the top 10 data and store them to the display list
        if(LinkedHashMapKeys.size()<11)
            counter = LinkedHashMapKeys.size();
        else
            counter = 10;
        
        for(int i = 0;i<counter;i++)
        {
            StudentLocation samplelocation = LinkedHashMapKeys.get(i);
            Double distance = SortedHashMap.get(samplelocation);
            String firstname = samplelocation.getStudentNumber().getFirstName();
            String lastname = samplelocation.getStudentNumber().getLastName();
            Double latitude = Double.parseDouble(samplelocation.getLatitude());
            Double longitude = Double.parseDouble(samplelocation.getLongitude());
            DisplayListForWSb dplistsampleb;
            dplistsampleb = new DisplayListForWSb(firstname,lastname,latitude,longitude,distance);
            dplistb.add(dplistsampleb);
        }
        return dplistb;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
