/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.konzola;

import domen.Konzola;
import domen.StrSprema;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class UcitajKonzolaSO extends ApstraktnaGenerickaOperacija{
    List<Konzola> konzole;
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        if(kljuc==null){
            konzole = broker.getAll(new Konzola(), null);
        }
        else if(kljuc.equals("naziv")){
            String naziv = (String) objekat;
            konzole = broker.getAll(new Konzola(), " WHERE naziv='"+naziv+"'");
        }
    }

    public List<Konzola> getKonzole() {
        return konzole;
    }
    
    
    
    
}
