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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    public void gemPrioriteterIDB(String navn, Collection fag)
    {
        Query studentQuery = em.createNamedQuery("Student.findByNavn");
        studentQuery.setParameter("navn", navn);
        List<Student> student = studentQuery.getResultList();
        Query valgfagQuery = em.createNamedQuery("Valgfag.findByPrioriteter");
        valgfagQuery.setParameter("fag", fag);
        List<Valgfag> valgfag = valgfagQuery.getResultList();     
        //persist(new FørsteRunde(student.get(0).getId(),valgfag.get(0),valgfag.get(1),valgfag.get(2),valgfag.get(3)));       
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
