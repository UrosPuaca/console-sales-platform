/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.racun;

import domen.Racun;
import domen.StavkaRacuna;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class DodajRacunSO extends ApstraktnaGenerickaOperacija{
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Racun)){
            throw new Exception("Sistem ne moze da nadje racun po zadatim kriterijumima");
        }
        
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        Racun racun = (Racun)objekat;
        
        int idRacun = broker.add(racun);
        
        
        List<StavkaRacuna> stavke = racun.getStavke();
        
        for (StavkaRacuna s : stavke) {
            s.setRacun(idRacun);
            broker.add(s);
        }
        
    }
    
}
