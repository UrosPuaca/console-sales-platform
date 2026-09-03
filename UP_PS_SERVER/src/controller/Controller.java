/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Grad;
import domen.Konzola;
import domen.Kupac;
import domen.Prodavac;
import domen.Racun;
import domen.StrSprema;
import java.util.List;
import operacije.grad.AzurirajGradSO;
import operacije.grad.DodajGradSO;
import operacije.grad.ObrisiGradSO;
import operacije.grad.UcitajGradSO;
import operacije.konzola.AzurirajKonzoluSO;
import operacije.konzola.DodajKonzoluSO;
import operacije.konzola.ObrisiKonzoluSO;
import operacije.konzola.UcitajKonzolaSO;
import operacije.kupac.AzurirajKupcaSO;
import operacije.kupac.DodajKupacSO;
import operacije.kupac.ObrisiKupacSO;
import operacije.kupac.UcitajKupacSO;
import operacije.login.PrijaviProdavacSO;
import operacije.prodavac.AzurirajProdavcaSO;
import operacije.prodavac.DodajProdavacSO;
import operacije.prodavac.ObrisiProdavacSO;
import operacije.prodavac.UcitajProdavacSO;
import operacije.racun.DodajRacunSO;
import operacije.racun.UcitajRacun;
import operacije.racun.UcitajRacunSO;
import operacije.strSprema.AzurirajStrSpremaSO;
import operacije.strSprema.ObrisiStrSpremaSO;
import operacije.strSprema.UbaciStrSpremaSO;
import operacije.strSprema.UcitajStrSpremaSO;

/**
 *
 * @author puaca
 */
public class Controller {
    private static Controller instance;

    private Controller() {
        
    }

    public static Controller getInstance() {
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }

    public Prodavac login(Prodavac p) throws Exception {
        PrijaviProdavacSO operacija = new PrijaviProdavacSO();
        operacija.izvrsi(p, null);
        System.out.println("KLASA Controller: "+operacija.getProdavac());
        return operacija.getProdavac();
    }

    public List<Grad> ucitajGradove() throws Exception {
        UcitajGradSO operacija = new UcitajGradSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA Controller:"+operacija.getGradovi());
        return operacija.getGradovi();
    }

    public List<StrSprema> ucitajStrSpreme() throws Exception {
        UcitajStrSpremaSO operacija = new UcitajStrSpremaSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA Controller:"+operacija.getSpreme());
        return operacija.getSpreme();
    }

    public List<Konzola> ucitajKonzole() throws Exception {
        UcitajKonzolaSO operacija = new UcitajKonzolaSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA Controller:"+operacija.getKonzole());
        return operacija.getKonzole();
    }

    public List<Kupac> ucitajKupce() throws Exception {
        UcitajKupacSO operacija = new UcitajKupacSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA Controller:"+operacija.getKupci());
        return operacija.getKupci();
    }

    public List<Prodavac> ucitajProdavce() throws Exception {
        UcitajProdavacSO operacija = new UcitajProdavacSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA Controller:"+operacija.getProdavci());
        return operacija.getProdavci();
    }

    public void obrisiKonzolu(Konzola k1) throws Exception {
        ObrisiKonzoluSO operacija = new ObrisiKonzoluSO();
        operacija.izvrsi(k1, null);
    }

    public void obrisiStrSprema(StrSprema ss) throws Exception {
        ObrisiStrSpremaSO operacija = new ObrisiStrSpremaSO();
        operacija.izvrsi(ss, null);
    }

    public void obrisiKupac(Kupac k) throws Exception {
        ObrisiKupacSO operacija = new ObrisiKupacSO();
        operacija.izvrsi(k, null);
    }

    public void obrisiGrad(Grad g1) throws Exception {
        ObrisiGradSO operacija = new ObrisiGradSO();
        operacija.izvrsi(g1, null);
    }

    public void obrisiProdavca(Prodavac p1) throws Exception {
        ObrisiProdavacSO operacija = new ObrisiProdavacSO();
        operacija.izvrsi(p1, null);
    }

    public void dodajGrad(Grad g) throws Exception {
        DodajGradSO operacija = new DodajGradSO();
        operacija.izvrsi(g, null);
    }

    public void dodajProdavca(Prodavac p2) throws Exception {
        DodajProdavacSO operacija = new DodajProdavacSO();
        operacija.izvrsi(p2, null);
    }

    public void dodajKonzolu(Konzola k) throws Exception {
        DodajKonzoluSO operacija = new DodajKonzoluSO();
        operacija.izvrsi(k, null);
    }

    public void ubaciStrSpremu(StrSprema s) throws Exception {
        UbaciStrSpremaSO operacija = new UbaciStrSpremaSO();
        operacija.izvrsi(s, null);
    }

    public void dodajKupca(Kupac k) throws Exception {
        DodajKupacSO operacija = new DodajKupacSO();
        operacija.izvrsi(k, null);
    }

    public void azurirajKonzolu(Konzola k2) throws Exception {
        AzurirajKonzoluSO operacija = new AzurirajKonzoluSO();
        operacija.izvrsi(k2, null);
    }

    public void azurirajGrad(Grad g2) throws Exception {
        AzurirajGradSO operacija = new AzurirajGradSO();
        operacija.izvrsi(g2, null);
    }

    public void azurirajStrSprema(StrSprema s2) throws Exception {
        AzurirajStrSpremaSO operacija = new AzurirajStrSpremaSO();
        operacija.izvrsi(s2, null);
    }

    public void azurirajProdavca(Prodavac p2) throws Exception {
        AzurirajProdavcaSO operacija = new AzurirajProdavcaSO();
        operacija.izvrsi(p2, null);
    }

    public void azurirajKupca(Kupac k2) throws Exception {
        AzurirajKupcaSO operacija = new AzurirajKupcaSO();
        operacija.izvrsi(k2, null);
    }

    public List<Grad> ucitajGradove(String naziv) throws Exception {
        UcitajGradSO operacija = new UcitajGradSO();
        operacija.izvrsi(naziv, "naziv");
        System.out.println("KLASA Controller:"+operacija.getGradovi());
        return operacija.getGradovi();
    }

    public List<StrSprema> ucitajStrSpreme(String naziv2) throws Exception {
        UcitajStrSpremaSO operacija = new UcitajStrSpremaSO();
        operacija.izvrsi(naziv2, "naziv");
        System.out.println("KLASA Controller:"+operacija.getSpreme());
        return operacija.getSpreme();
    }

    public List<Prodavac> ucitajProdavce(Prodavac prodavac) throws Exception {
        UcitajProdavacSO operacija = new UcitajProdavacSO();
        operacija.izvrsi(prodavac, "prezime");
        System.out.println("KLASA Controller: "+operacija.getProdavci());
        return operacija.getProdavci();
    }

    public List<Kupac> ucitajKupce(Kupac kupac) throws Exception {
        UcitajKupacSO operacija = new UcitajKupacSO();
        operacija.izvrsi(kupac, "prezime");
        System.out.println("KLASA Controller:"+operacija.getKupci());
        return operacija.getKupci();
    }

    public List<Konzola> ucitajKonzole(String naziv1) throws Exception {
        UcitajKonzolaSO operacija = new UcitajKonzolaSO();
        operacija.izvrsi(naziv1, "naziv");
        System.out.println("KLASA Controller:"+operacija.getKonzole());
        return operacija.getKonzole();
    }

    public List<Racun> ucitajRacune() throws Exception {
        UcitajRacunSO operacija = new UcitajRacunSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA Controller:"+operacija.getRacuni());
        return operacija.getRacuni();
    }

    public void dodajRacun(Racun r) throws Exception {
        DodajRacunSO operacija = new DodajRacunSO();
        operacija.izvrsi(r, null);
    }

    public Racun vratiRacun(Racun r) throws Exception {
        UcitajRacun operacija = new UcitajRacun();
        operacija.izvrsi(r, null);
        System.out.println("KLASA Controller:"+operacija.getR());
        return operacija.getR();
    }

    public List<Racun> ucitajRacune(Prodavac p4) throws Exception {
        UcitajRacunSO operacija = new UcitajRacunSO();
        operacija.izvrsi(p4, "prodavci");
        System.out.println("KLASA Controller:"+operacija.getRacuni());
        return operacija.getRacuni();
    }

    public List<Racun> ucitajRacune(Kupac k4) throws Exception {
        UcitajRacunSO operacija = new UcitajRacunSO();
        operacija.izvrsi(k4, "kupci");
        System.out.println("KLASA Controller:"+operacija.getRacuni());
        return operacija.getRacuni();
    }

    public List<Kupac> ucitajKupce(Grad g) throws Exception {
        UcitajKupacSO operacija = new UcitajKupacSO();
        operacija.izvrsi(g, "grad");
        System.out.println("KLASA Controller:"+operacija.getKupci());
        return operacija.getKupci();
    }
}
