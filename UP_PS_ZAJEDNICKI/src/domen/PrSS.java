/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author puaca
 */
public class PrSS implements Serializable, ApstraktniDomenskiObjekat{
    private Prodavac prodavac;
    private StrSprema strSprema;
    private Date datum;

    public PrSS() {
    }

    public PrSS(Prodavac prodavac, StrSprema strSprema, Date datum) {
        this.prodavac = prodavac;
        this.strSprema = strSprema;
        this.datum = datum;
    }

    

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public StrSprema getStrSprema() {
        return strSprema;
    }

    public void setStrSprema(StrSprema strSprema) {
        this.strSprema = strSprema;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String vratiNazivTabele() {
        return "prss";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "prodavac,strsprema,datum";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return prodavac.getIdProdavac()+","+strSprema.getIdStrSprema()+",'"+datum+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "prss.prodavac="+prodavac.getIdProdavac()+" AND prss.strSprema="+strSprema.getIdStrSprema()+" AND prss.datum="+datum;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "prodavac="+prodavac.getIdProdavac()+",strSprema="+strSprema.getIdStrSprema()+",datum='"+datum+"'";
    }
}
