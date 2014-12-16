/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ValgfagResultat;
import entity.AndenRunde;
import entity.FørsteRunde;
import entity.Puljer;
import entity.Student;
import entity.Udvalgtefag1runde;
import entity.Valgfag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Controller {

    private EntityManager em;

    public Controller()
    {
        em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
    }

    public void gemPuljerIdb(String[] puljeA, String[] puljeB)
    {
        sletFraTabel("puljer");
        
        gemFagIPuljer("a", TilValfagResultat(puljeA));
        gemFagIPuljer("b", TilValfagResultat(puljeB));
    }

    
    //----------------------Gem/slet Metoder ----------------------------------------------------------//
    
    public void gemForslag(String titel, String underviser, String beskrivelse) throws Exception{

        Valgfag v = new Valgfag(titel, underviser, beskrivelse);
        Query query = em.createNamedQuery("Valgfag.findByFag");
        
        query.setParameter("fag", v.getFag());
       if(query.getResultList() == null)
        {
            System.out.println("    i was null");
        }
       
       else
       {
           System.out.println("yuhoo i ws not");
        }
            System.out.println("I began");
              em.getTransaction().begin();
        try
        {
          em.persist(v);
        
          em.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally
        {
            em.close();
        }
        
        
        //else
        {
            //throw new Exception();
        }
        
       
        

    }
    
    
     public void gemPrioriteterIDB(String navn, Collection fag)
    {
        Query studentQuery = em.createNamedQuery("Student.findByNavn");
        studentQuery.setParameter("navn", navn);
        List<Student> student = studentQuery.getResultList();
        Query valgfagQuery = em.createNamedQuery("Valgfag.findByPrioriteter");
        valgfagQuery.setParameter("fag", fag);
        List<Valgfag> valgfag = valgfagQuery.getResultList();     
        persist(new FørsteRunde(student.get(0).getId(),valgfag.get(0),valgfag.get(1),valgfag.get(2),valgfag.get(3)));       
    }
     
     
    private void gemFagIPuljer(String puljenavn, Object[] pulje)
    {
        
        for (int i = 0; i < pulje.length; i++)
        {
            persist(new Puljer(((ValgfagResultat)pulje[i]).getFag().getId(), puljenavn));
        }
       
    }
     
      public void gemValgAndenRunde(AndenRunde andenRunde) {
        // begin transaction 
        em.getTransaction().begin();
        if (!em.contains(andenRunde)) {
            // persist object - add to entity manager
            em.persist(andenRunde);
            // flush em - save to DB
            em.flush();
        }
        // commit transaction at all
        em.getTransaction().commit();
        
    }
    
    private void sletFraTabel(String tabel){
        
         em.getTransaction().begin();
        try
        {
           Query q = em.createQuery("DELETE from "+tabel);
        int sletet = q.executeUpdate();
        
          em.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally
        {
            em.close();
        }
    }
    
    //---------------------------Hent/Vis Metoder --------------------------------------//
    
     public int getTotalAntalStudenter(){
        
       Query q = em.createNamedQuery("Student.findAll");
       return q.getResultList().size();
       
    }
     
      public Collection hentUdvalgteFagTilFørsteRunde(){
        Query q = em.createNamedQuery("Udvalgtefag1runde.findAll");
        Collection<Udvalgtefag1runde> valgfagsId = q.getResultList();
        Collection<Valgfag> valgfag = new ArrayList<>();
        for(Udvalgtefag1runde id : valgfagsId){
            valgfag.add(id.getValgfag());
            System.out.println(id.getValgfag().getFag());
        }
        return valgfag;
    }
      
      public Valgfag hentFagViaID(int id) {

        Query query = em.createNamedQuery("Valgfag.findById");
        query.setParameter("id", id);
        Collection<Valgfag> fag = query.getResultList();

        ArrayList<Valgfag> valgfag = new ArrayList();

        for (Valgfag v : fag) {
            valgfag.add(v);
        }
        return valgfag.get(0);
    }
      
        public int hentStudentIdViaNavn(String navn) {

        Query query = em.createNamedQuery("Student.findByNavn");
        query.setParameter("navn", navn);
        Collection<Student> navnResultat = query.getResultList();

        ArrayList<Student> student = new ArrayList();
        for (Student n : navnResultat) {
            student.add(n);
        }

        
        return student.get(0).getId();
    }
      
      public ArrayList<Valgfag> visPuljeA() {

        Query query = em.createNamedQuery("Puljer.findByPulje");
        query.setParameter("pulje", "a");
        Collection<Puljer> puljer = query.getResultList();

        ArrayList<Valgfag> resultat = new ArrayList();

        for (Puljer p : puljer) {
            resultat.add(p.getValgfag());

        }
        return resultat;
    }

    public ArrayList<Valgfag> visPuljeB() {

        Query query = em.createNamedQuery("Puljer.findByPulje");
        query.setParameter("pulje", "b");
        Collection<Puljer> puljer = query.getResultList();

        ArrayList<Valgfag> resultat = new ArrayList();

        for (Puljer p : puljer) {
            resultat.add(p.getValgfag());

        }
        return resultat;
    }
      
    //------------------------- Hjælpe Metoder ------------------------------------//
      
      public Object[] TilValfagResultat(String[] pulje)
     {       
         ArrayList<ValgfagResultat> valgfagResultat = new ArrayList();
         for(int i = 0 ; i < pulje.length; i++)
         {
             String[] parts = pulje[i].split("[,\\s]+");
             String fag = parts[0];
             //Hent valgfag fra db
             Query query = em.createNamedQuery("Valgfag.findByFag");
             query.setParameter("fag", fag); 
             Valgfag valgfag = (Valgfag) query.getResultList().get(0);
             int prioritet1 = Integer.parseInt(parts[1]);
             int prioritet2 = Integer.parseInt(parts[1]);
             //Lav et objekt
             ValgfagResultat resultat = new ValgfagResultat(valgfag, prioritet1, prioritet2);
             //tilføj til arraylisten
             valgfagResultat.add(resultat);
             
         }
         return valgfagResultat.toArray();   
     }  
      
      
      
    //--------------------------- Beregn Metoder -------------------------------------//
     
     
    public ArrayList<ValgfagResultat> visResultat()
    {
      
        Query query = em.createNamedQuery("Valgfag.findAll");
        Query query2 = em.createNamedQuery("FørsteRunde.findCount1");
        Query query3 = em.createNamedQuery("FørsteRunde.findCount2");
        ArrayList<ValgfagResultat> resultater = new ArrayList<>();
        Collection<Valgfag> valgfag = query.getResultList();
        
        for(Valgfag v : valgfag)
        {
            query2.setParameter("førstePrioriteta", v);
            query3.setParameter("andenPrioriteta", v);
            Collection count1 = query2.getResultList();
            Collection count2 = query3.getResultList();
            ValgfagResultat resultat = new ValgfagResultat(v, Integer.parseInt(count1.toArray()[0] + ""), Integer.parseInt(count2.toArray()[0] + ""));
            resultater.add(resultat);

        }
        return resultater;
    }

   
    
    /**
      * Beregner student tilfredshed ud fra deres valg og deres pladsering i begge puljer,
      * jo flere valg som eksistere i samme pulje jo mere utilfreds studenten er.
      * Metoden tjekker begge puljer for valgets eksistense, hvis valget eksistere i ingen af puljer
      * stiger utilfredshed også
      **/
    public List beregnTilfredshed(String[] puljeA, String[] puljeB){
        
        UtilfredahedsBeregner utb = new UtilfredahedsBeregner();
        Object[] puljeAResultat = TilValfagResultat(puljeA);
        Object[] puljeBResultat = TilValfagResultat(puljeB);
        
        return utb.beregnTilfredshed(puljeAResultat, puljeBResultat);
       
    }
 
    
    
   
    
     public void persist(Object object)
    {
        em.getTransaction().begin();
        try
        {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally
        {
            em.close();
        }
    }
     
     
}
