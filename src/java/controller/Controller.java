/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ValgfagResultat;
import entity.FørsteRunde;
import entity.Puljer;
import entity.Student;
import entity.Valgfag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultListModel;

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

    public void gemPuljerIdb(Object[] puljeA, Object[] puljeB)
    {
        sletFraTabel("puljer");
        gemFagIPuljer("a", puljeA);
        gemFagIPuljer("b", puljeB);
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
    public List beregnTilfredshed(Object[] puljeA, Object[] puljeB){
        
        UtilfredahedsBeregner utb = new UtilfredahedsBeregner();
        return utb.beregnTilfredshed(puljeA, puljeB);
       
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
    
}
