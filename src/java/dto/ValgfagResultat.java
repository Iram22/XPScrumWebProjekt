/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import entity.Valgfag;

/**
 *
 * @author Dino Kalember
 */
public class ValgfagResultat {
    Valgfag fag;
    int priotet1;
    int priotet2;

    public ValgfagResultat(Valgfag fag, int priotet1, int priotet2) {
        this.fag = fag;
        this.priotet1 = priotet1;
        this.priotet2 = priotet2;
    }

    public Valgfag getFag() {
        return fag;
    }

    public void setFagnavn(Valgfag fag) {
        this.fag = fag;
    }

    public int getPriotet1() {
        return priotet1;
    }

    public void setPriotet1(int priotet1) {
        this.priotet1 = priotet1;
    }

    public int getPriotet2() {
        return priotet2;
    }

    public void setPriotet2(int priotet2) {
        this.priotet2 = priotet2;
    }

    @Override
    public String toString() {
        return fag.getFag() + ", " + priotet1 + ", " + priotet2;
    }
    
    
    
}
