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
public class DodajKupacSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Kupac)){
            throw new Exception("Sistem ne moze da nadje kupca po zadatim kriterijumima");
        }
        
        Kupac k = (Kupac) objekat;
        if(k.getIme()==null || k.getIme().isEmpty()){
            throw new Exception("Ime ne sme biti prazno");
        }
        if(k.getPrezime()==null || k.getPrezime().isEmpty()){
            throw new Exception("Prezime ne sme biti prazno");
        }
        if(k.getEmail()==null || k.getEmail().isEmpty()){
            throw new Exception("Email ne sme biti prazan");
        }
        if(k.getTelefon()==null || k.getTelefon().isEmpty()){
            throw new Exception("Telefon ne sme biti prazan");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.add((Kupac)objekat);
    }
    
}
