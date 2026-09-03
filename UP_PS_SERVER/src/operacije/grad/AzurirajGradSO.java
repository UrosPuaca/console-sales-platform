/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.grad;

import domen.Grad;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class AzurirajGradSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat == null || !(objekat instanceof Grad)){
            throw new Exception("Sistem ne moze da azurira grad");
        }
        Grad g = (Grad) objekat;
        if(g.getNaziv()==null || g.getNaziv().isEmpty()){
            throw new Exception("Naziv grada ne sme biti prazan");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.edit((Grad)objekat);
    }
    
}
