/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.kupac;

import domen.Kupac;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class ObrisiKupacSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Kupac)){
            throw new Exception("Sistem ne moze da nadje kupca po zadatim kriterijumima");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.delete((Kupac)objekat);
    }
    
}
