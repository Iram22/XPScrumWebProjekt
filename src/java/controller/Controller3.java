/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Puljer;
import entity.Valgfag;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Hanan
 */
public class Controller3 {

    private EntityManager em;

    public Controller3() {
        em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
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
    
    
    
   // public void gemValgAndenRunde(AndenRunde andenRunde){
    
    //}

}

