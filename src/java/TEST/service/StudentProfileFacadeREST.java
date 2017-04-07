/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST.service;

import java.util.Arrays;
import TEST.StudentProfile;
import TEST.StudentLocation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Yang-Deng
 */
@Stateless
@Path("test.studentprofile")
public class StudentProfileFacadeREST extends AbstractFacade<StudentProfile> {

    @PersistenceContext(unitName = "TESTFOR5046ASSPU")
    private EntityManager em;

    public StudentProfileFacadeREST() {
        super(StudentProfile.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StudentProfile entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, StudentProfile entity) {
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
    public StudentProfile find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StudentProfile> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //FIND by STUDENT NUMBER
    @GET
    @Path("findbyStudentNumber/{StudentNumber}")
    @Produces({"application/json"})
    public List<StudentProfile> findByStudentNumber(@PathParam("StudentNumber") Integer StudentNumber){
        Query query = em.createNamedQuery("StudentProfile.findByStudentNumber");
        query.setParameter("studentNumber", StudentNumber);
        return query.getResultList();
    }

    //Find By First Name
    @GET
    @Path("findByFirstName/{FirstName}")
    @Produces({"application/json"})
    public List<StudentProfile> findByFirstName(@PathParam("FirstName") String FirstName){
        Query query = em.createNamedQuery("StudentProfile.findByFirstName");
        query.setParameter("firstName", FirstName);
        return query.getResultList();
    }
    
    //Find By Last Name
    @GET
    @Path("findByLastName/{LastName}")
    @Produces({"application/json"})
    public List<StudentProfile> findByLastName(@PathParam("LastName") String LastName){
        Query query = em.createNamedQuery("StudentProfile.findByLastName");
        query.setParameter("lastName", LastName);
        return query.getResultList();
    }
    
    //Find By DoB
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List<StudentProfile> findByDob(@PathParam("dob") Date dob){
        Query query = em.createNamedQuery("StudentProfile.findByDob");
        query.setParameter("dob", dob);
        return query.getResultList();
    }
    
    //findByGender
    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<StudentProfile> findByGender(@PathParam("gender") String gender){
        Query query = em.createNamedQuery("StudentProfile.findByGender");
        query.setParameter("gender", gender);
        return query.getResultList();
    }
    
    //find By Address
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<StudentProfile> findByAddress(@PathParam("address") String address){
        Query query = em.createNamedQuery("StudentProfile.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    //find By Suburb
    @GET
    @Path("findBySuburb/{suburb}")
    @Produces({"application/json"})
    public List<StudentProfile> findBySuburb(@PathParam("suburb") String suburb){
        Query query = em.createNamedQuery("StudentProfile.findBySuburb");
        query.setParameter("suburb", suburb);
        return query.getResultList();
    }
    
    //find By Nationality
    @GET
    @Path("findByNationality/{nationality}")
    @Produces({"application/json"})
    public List<StudentProfile> findByNationality(@PathParam("nationality") String nationality){
        Query query = em.createNamedQuery("StudentProfile.findByNationality");
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }
    
    //find By NativeLanguage
    @GET
    @Path("findByNativeLanguage/{nativeLanguage}")
    @Produces({"application/json"})
    public List<StudentProfile> findByNativeLanguage(@PathParam("nativeLanguage") String nativeLanguage){
        Query query = em.createNamedQuery("StudentProfile.findByNativeLanguage");
        query.setParameter("nativeLanguage", nativeLanguage);
        return query.getResultList();
    }
    
    //find By Favourite Sport
    @GET
    @Path("findByFavouriteSport/{favouriteSport}")
    @Produces({"application/json"})
    public List<StudentProfile> findByFavouriteSport(@PathParam("favouriteSport") String favouriteSport){
        Query query = em.createNamedQuery("StudentProfile.findByFavouriteSport");
        query.setParameter("favouriteSport", favouriteSport);
        return query.getResultList();
    }
    
    //find By Favourite Movie
    @GET
    @Path("findByFavouriteMovie/{favouriteMovie}")
    @Produces({"application/json"})
    public List<StudentProfile> findByFavouriteMovie(@PathParam("favouriteMovie") String favouriteMovie){
        Query query = em.createNamedQuery("StudentProfile.findByFavouriteMovie");
        query.setParameter("favouriteMovie", favouriteMovie);
        return query.getResultList();
    }
    
    //find By CurrentJob
    @GET
    @Path("findByCurrentJob/{currentJob}")
    @Produces({"application/json"})
    public List<StudentProfile> findByCurrentJob(@PathParam("currentJob") String currentJob){
        Query query = em.createNamedQuery("StudentProfile.findByCurrentJob");
        query.setParameter("currentJob", currentJob);
        return query.getResultList();
    }
    
    //find By MonashEmail
    @GET
    @Path("findByMonashEmail/{monashEmail}")
    @Produces({"application/json"})
    public List<StudentProfile> findByMonashEmail(@PathParam("monashEmail") String monashEmail){
        Query query = em.createNamedQuery("StudentProfile.findByMonashEmail");
        query.setParameter("monashEmail", monashEmail);
        return query.getResultList();
    }
    
    //find By Password
    @GET
    @Path("findByPassword/{password}")
    @Produces({"application/json"})
    public List<StudentProfile> findByPassword(@PathParam("password") String password){
        Query query = em.createNamedQuery("StudentProfile.findByPassword");
        query.setParameter("password", password);
        return query.getResultList();
    }
    
    //find By Course
    @GET
    @Path("findByCourse/{course}")
    @Produces({"application/json"})
    public List<StudentProfile> findByCourse(@PathParam("course") String course){
        Query query = em.createNamedQuery("StudentProfile.findByCourse");
        query.setParameter("course", course);
        return query.getResultList();
    }
    
    //find By StudyMode
    @GET
    @Path("findByStudyMode/{studyMode}")
    @Produces({"application/json"})
    public List<StudentProfile> findByStudyMode(@PathParam("studyMode") String studyMode){
        Query query = em.createNamedQuery("StudentProfile.findByStudyMode");
        query.setParameter("studyMode", studyMode);
        return query.getResultList();
    }
    
    //find By FavouriteUnitCode
    @GET
    @Path("findByFavouriteUnitCode/{favouriteUnitCode}")
    @Produces({"application/json"})
    public List<StudentProfile> findByFavouriteUnitCode(@PathParam("favouriteUnitCode") String favouriteUnitCode){
        Query query = em.createNamedQuery("StudentProfile.findByFavouriteUnitCode");
        query.setParameter("favouriteUnitCode", favouriteUnitCode);
        return query.getResultList();
    }
    
    //find By SubsciptionData
    @GET
    @Path("findBySubsciptionData/{subsciptionData}")
    @Produces({"application/json"})
    public List<StudentProfile> findBySubsciptionData(@PathParam("subsciptionData") String subsciptionData){
        Query query = em.createNamedQuery("StudentProfile.findBySubsciptionData");
        query.setParameter("subsciptionData", subsciptionData);
        return query.getResultList();
    }
    
    //find By SubsciptionTime
    @GET
    @Path("findBySubsciptionTime/{subsciptionTime}")
    @Produces({"application/json"})
    public List<StudentProfile> findBySubsciptionTime(@PathParam("subsciptionTime") String subsciptionTime){
        Query query = em.createNamedQuery("StudentProfile.findBySubsciptionTime");
        query.setParameter("subsciptionTime", subsciptionTime);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFullName/{firstname}/{lastname}")
    @Produces({"application/json"})
    public List<StudentProfile> findByFirstLastName(@PathParam("firstname") String FirstName, @PathParam("lastname") String LastName) {
        TypedQuery<StudentProfile> q = em.createQuery("SELECT s FROM StudentProfile s WHERE UPPER(s.firstName) = UPPER(:firstname) AND UPPER(s.lastName) = UPPER(:lastname) ", StudentProfile.class);
        q.setParameter("firstname", FirstName);
        q.setParameter("lastname", LastName);
     return q.getResultList();
}

    //fing locations by full name
    @GET
    @Path("findLocationsByFullName/{firstname}/{lastname}")
    @Produces({"application/json"})
    public List<StudentLocation> findLocationsByFullName(@PathParam("firstname") String FirstName, @PathParam("lastname") String LastName) {
        TypedQuery<StudentLocation> q = em.createQuery("SELECT s FROM StudentLocation s WHERE s.studentNumber.firstName =:firstname AND s.studentNumber.lastName =:lastname ", StudentLocation.class);
        q.setParameter("firstname", FirstName);
        q.setParameter("lastname", LastName);
    return q.getResultList();
}

    //FIND ALL locations by STUDENT Number
    @GET
    @Path("findLocationsBystuNum/{studentnumber}")
    @Produces({"application/json"})
    public Collection<StudentLocation> findLocationsBystuNum(@PathParam("studentnumber") Integer studentnumber){
        Query query = em.createQuery("Select s from StudentProfile s WHERE s.studentNumber =:studentnumber",StudentProfile.class);
        query.setParameter("studentnumber", studentnumber);
        StudentProfile singleResult = (StudentProfile)query.getSingleResult();
        return singleResult.getStudentLocationCollection();
    }
    
    // Task2 question 4 ,static query using an explicit JOIN
    @GET
    @Path("findByFullNameJoin/{firstname}/{lastname}")
    @Produces({"application/json"})
    public List<StudentProfile> findByFullNameJoin(@PathParam("firstname") String FirstName, @PathParam("lastname") String LastName) {
        Query query = em.createNamedQuery("StudentProfile.findByFullNameJoin");
        query.setParameter("firstname", FirstName);
        query.setParameter("lastname", LastName);
        return query.getResultList();
    }

//    //Dynamic query using an explicit JOIN
//    @GET
//    @Path("findLocationsByFullNameJoin/{firstname}/{lastname}")
//    @Produces({"application/json"})
//    public List<StudentLocation> findLocationsByFullNameJoin(@PathParam("firstname") String FirstName, @PathParam("lastname") String LastName) {
//        TypedQuery<StudentLocation> q = em.createQuery("SELECT S FROM StudentLocation S JOIN StudentProfile C ON C.studentNumber = S.studentNumber.studentNumber WHERE s.studentNumber.firstName =:firstname AND s.studentNumber.lastName =:lastname", StudentLocation.class);
//        q.setParameter("firstname", FirstName);
//        q.setParameter("lastname", LastName);
//    return q.getResultList();
//}
    
    //Task3 c
    @GET
    @Path("ReportWSc/{studentnumber}/{keyword1}/{keyword2}/{keyword3}")
    @Produces({"application/json"})
    public List<StudentProfile> ReportWSc(@PathParam("studentnumber") Integer studentNumber,@PathParam("keyword1") String keyWord1, @PathParam("keyword2") String keyWord2, @PathParam("keyword3") String keyWord3) {
       //Get the target student by querying
       TypedQuery<StudentProfile> q = em.createQuery("SELECT s FROM StudentProfile s WHERE s.studentNumber = :studentnumber", StudentProfile.class);
       q.setParameter("studentnumber", studentNumber);
       StudentProfile Target = q.getSingleResult();
       
       //get the keyword and store them respectively
       String keyword1value = Target.getAttributesByName(keyWord1);
       String keyword2value = Target.getAttributesByName(keyWord2);
       String keyword3value = Target.getAttributesByName(keyWord3);
       
       //Splicing a new query sentence by adding query conditions
       String SQLsentence = "SELECT s FROM StudentProfile s WHERE s.studentNumber != :studentnumber AND s." + keyWord1 + " = :keyword1 AND s." + keyWord2 + " = :keyword2 AND s." + keyWord3 + " = :keyword3";
       TypedQuery<StudentProfile> f = em.createQuery(SQLsentence, StudentProfile.class);
       f.setParameter("studentnumber", studentNumber);
       f.setParameter("keyword1", keyword1value);
       f.setParameter("keyword2", keyword2value);
       f.setParameter("keyword3", keyword3value);
       // return the list contains the outcomes.
       List<StudentProfile> OutcomeList = f.getResultList();
       return OutcomeList;
    }
    
    //Task3 d
    @GET
    @Path("ReportWSd/{studentnumber}/{keywords}")
    @Produces({"application/json"})
    public List<StudentProfile> ReportWSd(@PathParam("studentnumber") Integer studentNumber,@PathParam("keywords") String keyWords) {
       // Create a keywordsArray to store all single keywords that be split by space.
       String[] keywordsArray= keyWords.split(" ");
       
       // Get a certain value by its studentnumber and assign it to the Target which type is StudentProfile
       TypedQuery<StudentProfile> q = em.createQuery("SELECT s FROM StudentProfile s WHERE s.studentNumber = :studentnumber", StudentProfile.class);
       q.setParameter("studentnumber", studentNumber);
       StudentProfile Target = q.getSingleResult();
       
       // Create a HashMap to store keyword and its value of the selected student
       HashMap<String,String> keywordsMap = new HashMap<>();
        for (String keywordsArray1 : keywordsArray) {
            String keywordsvalue = Target.getAttributesByName(keywordsArray1);
            keywordsMap.put(keywordsArray1, keywordsvalue);
        }
        
       // Splicing a query sentence by add all query conditions
       List<String> KeysArray = new ArrayList<>(keywordsMap.keySet());  
       String SQLsentence = "SELECT s FROM StudentProfile s WHERE s.studentNumber != :studentnumber";
       for(int i=0 ;i < KeysArray.size() ; i++)
       {
           int j = i+1;
           String SQLkeyword = "keyword" + Integer.toString(j);
           SQLsentence = SQLsentence + " AND s." + KeysArray.get(i) + " = :" + SQLkeyword;
       }
       
       // Excute the query sentence and set corresponding parameters
       TypedQuery<StudentProfile> f = em.createQuery(SQLsentence, StudentProfile.class);
       f.setParameter("studentnumber", studentNumber);
       for(int i=0 ;i < KeysArray.size();i++)
       {
           int j = i+1;
           String SQLkeyword2 = "keyword" + Integer.toString(j);
           String key = KeysArray.get(i);
           f.setParameter(SQLkeyword2, keywordsMap.get(key));
       }
       
       //Output the results
       List<StudentProfile> OutcomeList = f.getResultList();
       return OutcomeList;
    }
    
    //Task3 e
    @GET
    @Path("ReportWSe")
    @Produces({"application/json"})
    public List<DisplayListForWSe> findFavouriteUnits() {
        // Create a AllStudent list to store All StudentProfile
        TypedQuery<StudentProfile> q = em.createQuery("SELECT s FROM StudentProfile s", StudentProfile.class);
        List<StudentProfile> AllStudent = q.getResultList();
        // Create a favouriteUnitsList to store FavouriteUnitCode of each student
        List<String> favouriteUnitsList = new ArrayList<>();
        AllStudent.forEach((SL) -> {
            favouriteUnitsList.add(SL.getFavouriteUnitCode());
        });
        // Create a Map to store all FavouriteUnitCode of each student and their frenquence
        Map<String,Integer> FavouriteUnitsCounter = new HashMap<>();
        favouriteUnitsList.forEach((Unit) -> {
            Integer i = FavouriteUnitsCounter.get(Unit);
            if(i == null) FavouriteUnitsCounter.put(Unit, 1);
            else FavouriteUnitsCounter.put(Unit, i + 1);
        }); 
        
        // Create a List to store the results then be output to the console
        List<DisplayListForWSe> dplistFore;
        dplistFore = new ArrayList();
        // Create a Iterator to transfer data stored in the FavouriteUnitCode to my DisplayListForWSe to display
        Iterator MapIterator = FavouriteUnitsCounter.keySet().iterator(); 
        while (MapIterator.hasNext()) { 
            String key = MapIterator.next().toString(); 
            Integer val = FavouriteUnitsCounter.get(key); 
            DisplayListForWSe dplistsample;
            dplistsample = new DisplayListForWSe(key,val);
            dplistFore.add(dplistsample);
        } 
        return dplistFore;
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
