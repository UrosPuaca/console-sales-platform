/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.prodavac;

import domen.Prodavac;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class UcitajProdavacSO extends ApstraktnaGenerickaOperacija{
    List<Prodavac> prodavci;
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        if(kljuc==null){
            prodavci = broker.getAll(new Prodavac(), null);
        }
        else if(kljuc.equals("prezime")){
            Prodavac p = (Prodavac) objekat;
            String prezime = p.getPrezime();
            prodavci = broker.getAll(new Prodavac(), " WHERE prodavac.prezime='"+prezime+"'");
        }
        
    }

    public List<Prodavac> getProdavci() {
        return prodavci;
    }
    
    
    
    
}
