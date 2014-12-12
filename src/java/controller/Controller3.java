/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Valgfag;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Chris
 */
public class Controller3 {
    
     private EntityManager em;

    public Controller3()
    {
        em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
    }
    
    public void gemForslag(String titel, String underviser, String beskrivelse){
        
        
        
    }
    
}
