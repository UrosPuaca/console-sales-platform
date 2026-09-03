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
public class Konzola implements Serializable, ApstraktniDomenskiObjekat{
    private int idKonzola;
    private String naziv;
    private double cena;
    private String opis;

    public Konzola() {
    }

    public Konzola(int idKonzola, String naziv, double cena, String opis) {
        this.idKonzola = idKonzola;
        this.naziv = naziv;
        this.cena = cena;
        this.opis = opis;
    }

    public int getIdKonzola() {
        return idKonzola;
    }

    public void setIdKonzola(int idKonzola) {
        this.idKonzola = idKonzola;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "konzola";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idKonzola = rs.getInt("konzola.idKonzola");
            String naziv = rs.getString("konzola.naziv");
            double cena = rs.getDouble("konzola.cena");
            String opis = rs.getString("konzola.opis");
            Konzola l = new Konzola(idKonzola, naziv, cena, opis);
            lista.add(l);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,cena,opis";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"',"+cena+",'"+opis+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "konzola.idKonzola="+idKonzola;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        String safeOpis = opis.replace("'", "''");
        return "naziv='"+naziv+"',cena="+cena+",opis='"+safeOpis+"'";
    }
    
    
    
    
}
