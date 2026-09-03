/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.strSprema;

import domen.StrSprema;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class UcitajStrSpremaSO extends ApstraktnaGenerickaOperacija{
    List<StrSprema> spreme;

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        if(kljuc==null){
            spreme = broker.getAll(new StrSprema(), null);
        }
        else if(kljuc.equals("naziv")){
            String naziv = (String) objekat;
            spreme = broker.getAll(new StrSprema(), " WHERE naziv='"+naziv+"'");
        }
    }
    
    
    public List<StrSprema> getSpreme() {
        return spreme;
    }
    
}
