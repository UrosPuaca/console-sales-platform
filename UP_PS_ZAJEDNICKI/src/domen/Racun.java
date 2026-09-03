/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author puaca
 */
public class Racun implements Serializable, ApstraktniDomenskiObjekat{
    private int idRacun;
    private Date datum;
    private double ukupanIznos;
    private Prodavac prodavac;
    private Kupac kupac;
    private List<StavkaRacuna> stavke;

    public Racun() {
    }

    public Racun(int idRacun, Date datum, double ukupanIznos, Prodavac prodavac, Kupac kupac, List<StavkaRacuna> stavke) {
        this.idRacun = idRacun;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.prodavac = prodavac;
        this.kupac = kupac;
        this.stavke = stavke;
    }

    public int getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(int idRacun) {
        this.idRacun = idRacun;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int idRacun = rs.getInt("r.idRacun");
            Date datum = rs.getDate("r.datum");
            double ukupanIznos = rs.getDouble("r.ukupanIznos");
            
            int idProdavac = rs.getInt("p.idProdavac");
            String imeP = rs.getString("p.ime");
            String prezimeP = rs.getString("p.prezime");
            String korisnickoIme = rs.getString("p.korisnickoIme");
            String sifra = rs.getString("p.sifra");

            Prodavac p = new Prodavac(idProdavac, imeP, prezimeP, korisnickoIme, sifra);
            
            int idKupac = rs.getInt("k.idKupac");
            String imeK = rs.getString("k.ime");
            String prezimeK = rs.getString("k.prezime");
            String email = rs.getString("k.email");
            String telefon = rs.getString("k.telefon");
            
            int idGrad = rs.getInt("g.idGrad");
            String naziv = rs.getString("g.naziv");
            Grad g = new Grad(idGrad, naziv);
            
            Kupac k =  new Kupac(idKupac, imeK, prezimeK, email, telefon, g);

            Racun r = new Racun(idRacun, datum, ukupanIznos, p, k, null);
            lista.add(r);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datum,ukupaniznos,prodavac,kupac";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+new SimpleDateFormat("yyyy-MM-dd").format(datum)+"',"+ukupanIznos+","+prodavac.getIdProdavac()+","+kupac.getIdKupac();

    }

    @Override
    public String vratiPrimarniKljuc() {
        return "racun.idRacun="+idRacun;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "datum='"+new SimpleDateFormat("yyyy-MM-dd").format(datum)+"',ukupanIznos="+ukupanIznos+",prodavac="+prodavac.getIdProdavac()+",kupac="+kupac.getIdKupac();

    }
}
