/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.konzola;

import domen.Konzola;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class AzurirajKonzoluSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Konzola)){
            throw new Exception("Sistem ne moze da nadje laptop po zadatim kriterijumima");
        }
        Konzola k = (Konzola) objekat;
        if(k.getNaziv()==null || k.getNaziv().isEmpty()){
            throw new Exception("Naziv ne sme biti prazan");
        }
        if(k.getCena()<=0){
            throw new Exception("Cena mora biti veca od 0");
        }
        if(k.getOpis()==null || k.getOpis().isEmpty()){
            throw new Exception("Opis ne sme biti prazan");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.edit((Konzola)objekat);
    }
    
}
