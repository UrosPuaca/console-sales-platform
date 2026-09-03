/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.racun;

import domen.Racun;
import domen.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class UcitajRacun extends ApstraktnaGenerickaOperacija{
    List<StavkaRacuna> stavke;
    Racun r;
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        r = (Racun) objekat;
        r.setStavke(new ArrayList<>());
        
        stavke = broker.getAll(new StavkaRacuna(), " sr JOIN konzola k on sr.konzola=k.idKonzola WHERE sr.racun="+r.getIdRacun());
        
        for (StavkaRacuna s : stavke) {
            r.getStavke().add(s);
        }
    }

    public Racun getR() {
        return r;
    }
    
}
