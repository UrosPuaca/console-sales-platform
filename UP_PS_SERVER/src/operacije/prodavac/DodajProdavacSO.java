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
public class DodajProdavacSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Prodavac)){
            throw new Exception("Sistem ne moze da nadje prodavca po zadatim kriterijumima");
        }
        
        Prodavac p = (Prodavac) objekat;
        if(p.getIme()==null || p.getIme().isEmpty()){
            throw new Exception("Ime ne sme biti prazno");
        }
        if(p.getPrezime()==null || p.getPrezime().isEmpty()){
            throw new Exception("Prezime ne sme biti prazno");
        }
        if(p.getKorisnickoIme()==null || p.getKorisnickoIme().isEmpty()){
            throw new Exception("Korisnicko ime ne sme biti prazno");
        }
        if(p.getSifra()==null || p.getSifra().isEmpty() || p.getSifra().length()<4){
            throw new Exception("Sifra mora imati bar 4 karaktera");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.add((Prodavac)objekat);
    }
    
}
