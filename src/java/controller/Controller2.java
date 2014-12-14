/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.FørsteRunde;
import entity.Student;
import entity.Udvalgtefag1runde;
import entity.Valgfag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ahmed
 */
public class Controller2 {
    private EntityManager em;

    public Controller2()
    {
        em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
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

    public void gemPrioriteterIDB(String navn, String a1, String a2, String b1, String b2)
    {
        Query studentQuery = em.createNamedQuery("Student.findByNavn");
        studentQuery.setParameter("navn", navn);
        List<Student> student = studentQuery.getResultList();
        Query valgfag1aQuery = em.createNamedQuery("Valgfag.findByFag");
        valgfag1aQuery.setParameter("fag", a1);
        List<Valgfag> valgfag1a = valgfag1aQuery.getResultList();
        Query valgfag1bQuery = em.createNamedQuery("Valgfag.findByFag");
        valgfag1bQuery.setParameter("fag", b1);
        List<Valgfag> valgfag1b = valgfag1bQuery.getResultList();
        Query valgfag2aQuery = em.createNamedQuery("Valgfag.findByFag");
        valgfag2aQuery.setParameter("fag", a2);
        List<Valgfag> valgfag2a = valgfag2aQuery.getResultList();
        Query valgfag2bQuery = em.createNamedQuery("Valgfag.findByFag");
        valgfag2bQuery.setParameter("fag", b2);
        List<Valgfag> valgfag2b = valgfag2bQuery.getResultList();
        System.out.println(""+student.get(0).getId() + valgfag1a.get(0) + valgfag2a.get(0) + valgfag1b.get(0) + valgfag2b.get(0) + student.get(0));
        
        persist(new FørsteRunde(student.get(0).getId(),valgfag1a.get(0),valgfag2a.get(0),valgfag1b.get(0),valgfag2b.get(0),student.get(0)));
               
        
    }

    public void persist(Object object) {
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
