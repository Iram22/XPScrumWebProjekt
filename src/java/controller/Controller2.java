/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

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
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        em.clear();
        return valgfag;
    }

    public void persist(Object object)
    {
        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
         * <persistence-context-ref>
         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
         * <persistence-unit-name>XPScrumWebProjektPU</persistence-unit-name>
         * </persistence-context-ref>
         * <resource-ref>
         * <res-ref-name>UserTransaction</res-ref-name>
         * <res-type>javax.transaction.UserTransaction</res-type>
         * <res-auth>Container</res-auth>
         * </resource-ref> */
        try
        {
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            em.joinTransaction();
            em.persist(object);
            utx.commit();
        } catch (Exception e)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}
