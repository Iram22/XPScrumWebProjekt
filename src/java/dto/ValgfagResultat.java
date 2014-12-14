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
    int prioritet1;
    int prioritet2;

    public ValgfagResultat(Valgfag fag, int priotet1, int priotet2) {
        this.fag = fag;
        this.prioritet1 = priotet1;
        this.prioritet2 = priotet2;
    }

    public Valgfag getFag() {
        return fag;
    }

    public void setFagnavn(Valgfag fag) {
        this.fag = fag;
    }

    public int getPrioritet1() {
        return prioritet1;
    }

    public void setPrioritet1(int prioritet1) {
        this.prioritet1 = prioritet1;
    }

    public int getPrioritet2() {
        return prioritet2;
    }

    public void setPrioritet2(int prioritet2) {
        this.prioritet2 = prioritet2;
    }

    @Override
    public String toString() {
        return fag.getFag() + ", " + prioritet1 + ", " + prioritet2;
    }
    
    
    
}
