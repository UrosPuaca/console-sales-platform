/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puaca
 */
public class StrSprema implements Serializable, ApstraktniDomenskiObjekat{
    private int idStrSprema;
    private String naziv;

    public StrSprema() {
    }

    public StrSprema(int idStrSprema, String naziv) {
        this.idStrSprema = idStrSprema;
        this.naziv = naziv;
    }

    public int getIdStrSprema() {
        return idStrSprema;
    }

    public void setIdStrSprema(int idStrSprema) {
        this.idStrSprema = idStrSprema;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "StrucnaSprema{" + "idStrSprema=" + idStrSprema + ", naziv=" + naziv + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "strsprema";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idStrSprema = rs.getInt("idStrSprema");
            String naziv = rs.getString("naziv");
            StrSprema ss = new StrSprema(idStrSprema, naziv);
            lista.add(ss);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idStrSprema="+idStrSprema;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "naziv='"+naziv+"'";
    }
    
}
