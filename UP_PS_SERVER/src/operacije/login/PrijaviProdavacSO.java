/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.login;

import domen.Prodavac;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class PrijaviProdavacSO extends ApstraktnaGenerickaOperacija{
    Prodavac prodavac;

    public Prodavac getProdavac() {
        return prodavac;
    }
    @Override
    protected void preduslovi(Object objekat) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<Prodavac> sviProdavci = broker.getAll((Prodavac) param, null);
        
        System.out.println("KLASA PrijaviProdavacSO "+sviProdavci);
        
        for (Prodavac p : sviProdavci) {
            if(p.equals((Prodavac)param)){
                prodavac = p;
                return;
            }
        }
        
        prodavac=null;
    }
    
}
