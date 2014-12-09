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
    
    
    public ArrayList<ValgfagResultat> visResultat()
    {
       em = Persistence.createEntityManagerFactory("XPScrumWebProjektPU").createEntityManager();
       
       if(em == null)
       {
           System.out.println("i am null");
       }

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
          
         em = Persistence.createEntityManagerFactory("XPScrumProjektPU").createEntityManager();
          Query query = em.createNamedQuery("F\u00f8rsteRunde.findAll");
          List<FørsteRunde> students = query.getResultList();
          
//          Object[] puljeA = pulje_A.toArray();
//          
//          Object[] puljeB = pulje_B.toArray();
          
          
        final int MAX_UTILFREDSHED = 4;
        
        List utilfredseStudenter = new ArrayList();
        FørsteRunde runde1;
        for(FørsteRunde stud : students){
            runde1 = stud.getStudent().getFørsteRunde();
            int utilfredshedsGrad = 0;
            int valgIpuljeA = 0;
            int valgIpuljeB = 0;
             // prioritet 1a
            if(!erIpuljen(runde1.getFørstePrioriteta().getFag(), puljeA)) // tjek om prioritet 1a er i pulje a
            {
                
                if(!erIpuljen(runde1.getFørstePrioriteta().getFag(), puljeB)) // hvis ikke så tjek om prioritet 1a er i pulje b
                {
                    utilfredshedsGrad += 1; // hvis den ikke findes i begge puljer så stiger utilfredshed
                }else{
                valgIpuljeB +=1;
                     }
                
            }else{
                valgIpuljeA +=1;
            }
            
            
            
            // prioritet 1b
            
             if(!erIpuljen(runde1.getFørstePrioritetb().getFag(), puljeA)) // tjek om prioritet 1b er i pulje A
            {
                
                if(!erIpuljen(runde1.getFørstePrioritetb().getFag(), puljeB)) // hvis ikke så tjek om prioritet 1b er i pulje B
                {
                    utilfredshedsGrad += 1; // hvis den ikke findes i begge puljer så stiger utilfredshed
                }else{
                valgIpuljeB +=1;
                    if(valgIpuljeB == 2){ utilfredshedsGrad += 1; } // hvis begge prioritet 1a og 1b findes i pulje B
                     }
                
            }else{
                valgIpuljeA +=1;
                if(valgIpuljeA == 2){ utilfredshedsGrad += 1; } // hvis begge prioritet 1a og 1b findes i pulje A
                     }
            
             
             
              // prioritet 2a
             
              if(!erIpuljen(runde1.getAndenPrioriteta().getFag(), puljeA)) // tjek om prioritet 2a er i pulje A
            {
                
                if(!erIpuljen(runde1.getAndenPrioriteta().getFag(), puljeB)) // hvis ikke så tjek om prioritet 2a er i pulje B
                {
                    utilfredshedsGrad += 1; // hvis den ikke findes i begge puljer så stiger utilfredshed
                }else{
                valgIpuljeB +=1;
                       if(valgIpuljeB == 3){ utilfredshedsGrad += 1; } // hvis begge prioritet 1a og 1b og 2a findes i pulje B
                     } 
                     
                
            }else{
                valgIpuljeA +=1;
                       if(valgIpuljeA == 2){ utilfredshedsGrad += 1; } // hvis begge prioritet 1a og 1b og 2a findes i pulje A
            }
              
              
              
               // prioritet 2b
               if(!erIpuljen(runde1.getAndenPrioritetb().getFag(), puljeA)) // tjek om prioritet 2b er i pulje a
            {
                
                if(!erIpuljen(runde1.getAndenPrioritetb().getFag(), puljeB)) // hvis ikke så tjek om prioritet 2b er i pulje b
                {
                    utilfredshedsGrad += 1; // hvis den ikke findes i begge puljer så stiger utilfredshed
                }else{
                valgIpuljeB +=1;
                      if(valgIpuljeB == MAX_UTILFREDSHED){ utilfredshedsGrad += 1; } // hvis begge prioritet 1a og 1b og 2a og 2b findes i pulje B
                     
                     }
                
            }else{
                valgIpuljeA +=1;
                      if(valgIpuljeB == MAX_UTILFREDSHED){ utilfredshedsGrad += 1; } // hvis begge prioritet 1a og 1b og 2a og 2b findes i pulje A
            }
            
               
            if(utilfredshedsGrad > 2)
            {
                String result = utilfredshedsGrad +" "+stud.getStudent().getId() +" "+ stud.getFørstePrioriteta().getFag() +" "+ 
                                                   stud.getFørstePrioritetb().getFag() +" "+
                                                   stud.getAndenPrioriteta().getFag() +" "+
                                                   stud.getAndenPrioritetb().getFag();
                utilfredseStudenter.add(result); // List kan sorteres ved Collections.sort den og reverse
            }   
               
    
        } // end of loop
          
          return utilfredseStudenter;
          
    }
    

    
    private boolean erIpuljen(String fag, Object[] pulje){
         boolean erIpuljen = false;
        for (int i = 0; i < pulje.length; i++)
        {
            Valgfag fagIpuljen = ((ValgfagResultat)pulje[i]).getFag();
            if (pulje[i] != null && fag.compareTo(fagIpuljen.getFag()) == 0)
            {
                erIpuljen = true;
            }else{
                erIpuljen = false;
                }   
        }
        
        return erIpuljen;
    }
    
    
    public int getTotalAntalStudenter(){
        
       Query q = em.createNamedQuery("Student.findAll");
       return q.getResultList().size();
       
    }
    
     public void persist(Object object)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("XPScrumProjektPU");
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
