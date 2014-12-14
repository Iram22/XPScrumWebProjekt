/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.AndenRunde;
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
}
