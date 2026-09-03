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
public class ObrisiKonzoluSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat==null || !(objekat instanceof Konzola)){
            throw new Exception("Sistem ne moze da nadje Konzolu po zadatim kriterijumima");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.delete((Konzola)objekat);
    }
    
}
