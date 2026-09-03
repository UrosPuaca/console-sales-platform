/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.prodavac;

import domen.Prodavac;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class ObrisiProdavacSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Prodavac)){
            throw new Exception("Sistem ne moze da nadje prodavca po zadatim kriterijumima");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.delete((Prodavac)objekat);
    }
    
}
