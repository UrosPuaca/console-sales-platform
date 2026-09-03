/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.grad;

import domen.Grad;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class UcitajGradSO extends ApstraktnaGenerickaOperacija{
    List<Grad> gradovi;

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        String naziv = (String) objekat;
        
        if(kljuc==null){
            gradovi = broker.getAll(new Grad(), null);
        }
        else{
            gradovi = broker.getAll(new Grad(), " WHERE grad.naziv='"+naziv+"'");
        }
    }
    
    
    public List<Grad> getGradovi() {
        return gradovi;
    }
    
}
