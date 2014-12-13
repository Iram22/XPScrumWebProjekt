/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Valgfag;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Chris
 */
public class Controller99 {
    
     private EntityManager em;

    public Controller99()
    {
        em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
    }
    
    public void gemForslag(int id,String titel, String underviser, String beskrivelse){

        Valgfag v = new Valgfag(id, titel, underviser, beskrivelse);
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
        

    }
    
}