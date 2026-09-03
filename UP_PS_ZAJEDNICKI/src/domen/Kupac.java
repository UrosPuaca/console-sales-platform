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
public class Kupac implements Serializable, ApstraktniDomenskiObjekat{
    private int idKupac;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private Grad grad;

    public Kupac() {
    }

    public Kupac(int idKupac, String ime, String prezime, String email, String telefon, Grad grad) {
        this.idKupac = idKupac;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.grad = grad;
    }

    public int getIdKupac() {
        return idKupac;
    }

    public void setIdKupac(int idKupac) {
        this.idKupac = idKupac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return ime +" "+ prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Kupac other = (Kupac) obj;
        return this.idKupac == other.idKupac;
    }

    @Override
    public String vratiNazivTabele() {
        return "kupac";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while(rs.next()){
            int idKupac = rs.getInt("k.idKupac");
            String ime = rs.getString("k.ime");
            String prezime = rs.getString("k.prezime");
            String email = rs.getString("k.email");
            String telefon = rs.getString("k.telefon");
            
            int idGrad = rs.getInt("g.idGrad");
            String naziv = rs.getString("g.naziv");
            Grad g = new Grad(idGrad, naziv);
            
            Kupac k =  new Kupac(idKupac, ime, prezime, email, telefon, g);
            lista.add(k);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,email,telefon,grad";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+ime+"','"+prezime+"','"+email+"','"+telefon+"',"+grad.getIdGrad();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kupac.idKupac="+idKupac;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',email='"+email+"',telefon='"+telefon+"',grad="+grad.getIdGrad();
    }
    
}
