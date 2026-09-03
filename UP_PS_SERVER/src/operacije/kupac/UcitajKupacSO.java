/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.kupac;

import domen.Grad;
import domen.Kupac;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class UcitajKupacSO extends ApstraktnaGenerickaOperacija{
    List<Kupac> kupci;
    
    @Override
    protected void preduslovi(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        if(kljuc==null){
            kupci = broker.getAll(new Kupac(), " k JOIN grad g ON k.grad=g.idGrad");
            
        }else if(kljuc.equals("grad")){
            Grad g = (Grad) objekat;
            kupci = broker.getAll(new Kupac(), " k JOIN grad g ON k.grad=g.idGrad WHERE g.idGrad="+g.getIdGrad());
        }
        else if(kljuc.equals("prezime")){
            Kupac k = (Kupac) objekat;
            String prezime = k.getPrezime();
            kupci = broker.getAll(new Kupac(), " k JOIN grad g ON k.grad=g.idGrad WHERE k.prezime='"+prezime+"'");
        }
    }
    
    public List<Kupac> getKupci() {
        return kupci;
    }
    
}
