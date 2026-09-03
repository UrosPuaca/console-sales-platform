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
public class StavkaRacuna implements Serializable, ApstraktniDomenskiObjekat{
    private int racun;
    private int rb;
    private double prodajnaCena;
    private int kolicina;
    private double iznos;
    private Konzola konzola;
    private int status;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int racun, int rb, double prodajnaCena, int kolicina, double iznos, Konzola konzola) {
        this.racun = racun;
        this.rb = rb;
        this.prodajnaCena = prodajnaCena;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.konzola = konzola;
    }

    public StavkaRacuna(int racun, int rb, double prodajnaCena, int kolicina, double iznos, Konzola konzola, int status) {
        this.racun = racun;
        this.rb = rb;
        this.prodajnaCena = prodajnaCena;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.konzola = konzola;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    

    public int getRacun() {
        return racun;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getProdajnaCena() {
        return prodajnaCena;
    }

    public void setProdajnaCena(double prodajnaCena) {
        this.prodajnaCena = prodajnaCena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Konzola getKonzola() {
        return konzola;
    }

    public void setKonzola(Konzola laptop) {
        this.konzola = konzola;
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "racun=" + racun + ", rb=" + rb + ", prodajnaCena=" + prodajnaCena + ", kolicina=" + kolicina + ", iznos=" + iznos + ", konzola=" + konzola + ", status=" + status + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaRacuna other = (StavkaRacuna) obj;
        return this.rb == other.rb;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int racun = rs.getInt("sr.racun");
            int rb = rs.getInt("sr.rb");
            double prodajnaCena = rs.getDouble("sr.prodajnaCena");
            int kolicina = rs.getInt("sr.kolicina");
            double iznos = rs.getDouble("sr.iznos");
            
            int idKonzola = rs.getInt("k.idKonzola");
            String naziv = rs.getString("k.naziv");
            double cena = rs.getDouble("k.cena");
            String opis = rs.getString("k.opis");
            Konzola k = new Konzola(idKonzola, naziv, cena, opis);
            
            StavkaRacuna sr = new StavkaRacuna(racun, rb, prodajnaCena, kolicina, iznos, k);
            lista.add(sr);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "racun,rb,prodajnacena,kolicina,iznos,konzola";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return racun+","+rb+","+prodajnaCena+","+kolicina+","+iznos+","+konzola.getIdKonzola();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkaracuna.racun="+racun+" AND stavkaracuna.rb="+rb;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "racun="+racun+",rb="+rb+",prodajnaCena="+prodajnaCena+",kolicina="+kolicina+",iznos="+iznos+",konzola="+konzola.getIdKonzola();
    }
    
}
