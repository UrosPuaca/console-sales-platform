/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.strSprema;

import domen.StrSprema;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author puaca
 */
public class AzurirajStrSpremaSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat == null || !(objekat instanceof StrSprema)){
            throw new Exception("Sistem ne moze da azurira strucnu spremu");
        }
        StrSprema s = (StrSprema) objekat;
        if(s.getNaziv()==null || s.getNaziv().isEmpty()){
            throw new Exception("Naziv strucne spreme ne sme biti prazan");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.edit((StrSprema)objekat);
    }
    
}
