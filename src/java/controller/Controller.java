/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ValgfagResultat;
import entity.Puljer;
import entity.Valgfag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ahmed
 */
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

    private void gemFagIPuljer(String puljenavn, Object[] pulje)
    {
        
        for (int i = 0; i < pulje.length; i++)
        {
            persist(new Puljer(((ValgfagResultat)pulje[i]).getFag().getId(), puljenavn));
        }
       
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
    public ArrayList<ValgfagResultat> visResultat()
    {
       em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
      
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
 
    
    
    public int getTotalAntalStudenter(){
        
       Query q = em.createNamedQuery("Student.findAll");
       return q.getResultList().size();
       
    }
    
     public void persist(Object object)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("XPScrumWebProjektPU");
        EntityManager em = emf.createEntityManager();
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
     
     public Object[] TilValfagResultat(String[] pulje)
     {       
         em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
         ArrayList<ValgfagResultat> valgfagResultat = new ArrayList();
         for(int i = 0 ; i < pulje.length; i++)
         {
             String[] parts = pulje[i].split("[,\\s]+");
             String fag = parts[0];
             System.out.println("Fag: " + fag);
             //Hent valgfag fra db
             Query query = em.createNamedQuery("Valgfag.findByFag");
             query.setParameter("fag", fag); 
             System.out.println("length: " + query.getResultList().size());
             Valgfag valgfag = (Valgfag) query.getResultList().get(0);
             int prioritet1 = Integer.parseInt(parts[1]);
             int prioritet2 = Integer.parseInt(parts[1]);
             //Lav et objekt
             ValgfagResultat resultat = new ValgfagResultat(valgfag, prioritet1, prioritet2);
             //tilføj til arraylisten
             valgfagResultat.add(resultat);
             System.out.println(fag + "I am added. Yayyyyy");
             
         }
         return valgfagResultat.toArray();   
     }  
}
