/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controller.grad.AzurirajGradController;
import controller.grad.DodajGradController;
import controller.grad.PrikaziGradController;
import controller.konzola.AzurirajKonzolaController;
import controller.konzola.DodajKonzolaController;
import controller.konzola.PrikaziKonzolaController;
import controller.kupac.AzurirajKupacController;
import controller.kupac.DodajKupacController;
import controller.kupac.PrikaziKupacController;
import controller.prodavac.AzurirajProdavacController;
import controller.prodavac.DodajProdavacController;
import controller.prodavac.GlavnaFormaController;
import controller.prodavac.LoginController;
import controller.prodavac.PrikaziProdavacController;
import controller.racun.AzurirajRacunController;
import controller.racun.AzurirajStavkuController;
import controller.racun.DodajRacunController;
import controller.racun.PrikazRacunController;
import controller.strSprema.AzurirajStrSpremaController;
import controller.strSprema.PrikaziStrSpremaController;
import controller.strSprema.UbaciStrSpremaController;
import domen.Prodavac;
import forme.grad.AzurirajGradForma;
import forme.grad.DodajGradForma;
import forme.grad.PrikaziGradForma;
import forme.konzola.AzurirajKonzolaForma;
import forme.konzola.DodajKonzolaForma;
import forme.konzola.PrikaziKonzolaForma;
import forme.kupac.AzurirajKupacForma;
import forme.kupac.DodajKupacForma;
import forme.kupac.PrikaziKupacForma;
import forme.prodavac.AzurirajProdavacForma;
import forme.prodavac.DodajProdavacForma;
import forme.prodavac.GlavnaForma;
import forme.prodavac.LoginForma;
import forme.prodavac.PrikaziProdavacForma;
import forme.racun.AzurirajRacunForma;
import forme.racun.AzurirajStavkuForma;
import forme.racun.DodajRacunForma;
import forme.racun.PrikazRacunForma;
import forme.strSprema.AzurirajStrSpremaForma;
import forme.strSprema.PrikaziStrSpremaForma;
import forme.strSprema.UbaciStrSpremaForma;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author puaca
 */
public class Cordinator {
    public static Cordinator instance;
    private Prodavac ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaKontroler;
    private PrikaziGradController prikaziGradController;
    private PrikaziStrSpremaController prikaziStrSpremaController;
    private PrikaziKonzolaController prikaziKonzoluController;
    private PrikaziKupacController prikaziKupceController;
    private PrikaziProdavacController prikaziProdavacController;
    private DodajGradController dodajGradController;
    private DodajProdavacController dodajProdavcaController;
    private DodajKonzolaController dodajKonzoluController;
    private UbaciStrSpremaController ubaciStrSpremaController;
    private DodajKupacController dodajKupacController;
    private AzurirajKonzolaController azurirajKonzoluController;
    private AzurirajGradController azurirajGradController;
    private AzurirajStrSpremaController azurirajStrSpremaController;
    private AzurirajProdavacController azurirajProdavcaController;
    private AzurirajKupacController azurirajKupacController;
    private PrikazRacunController prikazRacunController;
    private DodajRacunController dodajRacunController;
    private AzurirajRacunController azurirajRacunController;
    private AzurirajStavkuController azurirajStavkuController;
    private Map<String,Object> parametri;

    private Cordinator(){
        parametri = new HashMap<>();
    }
    
    public static Cordinator getInstance(){
        if(instance == null){
            instance = new Cordinator();
        }
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaKontroler = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaKontroler.otvoriFormu();
    }
        
    
    public Prodavac getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Prodavac ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriPrikaziGradFormu() {
        prikaziGradController = new PrikaziGradController(new PrikaziGradForma());
        prikaziGradController.otvoriFormu();
    }
    
    public void otvoriPrikaziStrSpremaFormu() {
        prikaziStrSpremaController = new PrikaziStrSpremaController(new PrikaziStrSpremaForma());
        prikaziStrSpremaController.otvoriFormu();
    }
    
    
    public void otvoriPrikaziKonzoleFormu() {
        prikaziKonzoluController = new PrikaziKonzolaController(new PrikaziKonzolaForma());
        prikaziKonzoluController.otvoriFormu();
    }
    
    public void otvoriPrikaziKupceFormu() {
        prikaziKupceController = new PrikaziKupacController(new PrikaziKupacForma());
        prikaziKupceController.otvoriFormu();
    }
    
    public void otvoriPrikaziProdavacFormu(){
        prikaziProdavacController = new PrikaziProdavacController(new PrikaziProdavacForma());
        prikaziProdavacController.otvoriFormu();
    }

    public void otvoriDodajGradFormu() {
        dodajGradController = new DodajGradController(new DodajGradForma());
        dodajGradController.otvoriFormu();
    }

    public void otvoriDodajProdavcaFormu() {
        dodajProdavcaController = new DodajProdavacController(new DodajProdavacForma());
        dodajProdavcaController.otvoriFormu();
    }

    public void otvoriDodajKonzoluFormu() {
        dodajKonzoluController = new DodajKonzolaController(new DodajKonzolaForma());
        dodajKonzoluController.otvoriFormu();
    }

    public void otvoriUbaciStrSpremaFormu() {
        ubaciStrSpremaController = new UbaciStrSpremaController(new UbaciStrSpremaForma());
        ubaciStrSpremaController.otvoriFormu();
    }

    public void otvoriDodajKupacFormu() {
        dodajKupacController = new DodajKupacController(new DodajKupacForma());
        dodajKupacController.otvoriFormu();
    }
    
    public void dodajParam(String s, Object o){
        parametri.put(s, o);
    }
    
    public Object vratiParametar(String s){
        return parametri.get(s);
    }

    public void otvoriAzurirajKonzoluFormu() {
        azurirajKonzoluController = new AzurirajKonzolaController(new AzurirajKonzolaForma());
        azurirajKonzoluController.otvoriFormu();
    }

    public void osveziFormuKonzola() {
        prikaziKonzoluController.osveziFormu();
    }

    public void otvoriIzmeniGradFormu() {
        azurirajGradController = new AzurirajGradController(new AzurirajGradForma());
        azurirajGradController.otvoriFormu();
    }
    
    public void osveziFormuGrad() {
        prikaziGradController.osveziFormu();
    }

    public void otvoriIzmeniStrSpremaFormu() {
        azurirajStrSpremaController = new AzurirajStrSpremaController(new AzurirajStrSpremaForma());
        azurirajStrSpremaController.otvoriFormu();
    }

    public void osveziFormuStrSprema() {
        prikaziStrSpremaController.osveziFormu();
    }

    public void otvoriAzurirajProdavcaFormu() {
        azurirajProdavcaController = new AzurirajProdavacController(new AzurirajProdavacForma());
        azurirajProdavcaController.otvoriFormu();
    }

    public void osveziFormuProdavac() {
        prikaziProdavacController.osveziFormu();
    }

    public void osveziFormuKupac() {
        prikaziKupceController.osveziFormu();
    }

    public void otvoriAzurirajKupacFormu() {
        azurirajKupacController = new AzurirajKupacController(new AzurirajKupacForma());
        azurirajKupacController.otvoriFormu();
    }
    
    public void otvoriPrikaziRacunFormu() {
        prikazRacunController = new PrikazRacunController(new PrikazRacunForma());
        prikazRacunController.otvoriFormu();
    }
    
    public void otvoriDodajRacunFormu() {
        dodajRacunController = new DodajRacunController(new DodajRacunForma());
        dodajRacunController.otvoriFormu();
    }

    public void otvoriAzurirajRacunFormu() {
        azurirajRacunController = new AzurirajRacunController(new AzurirajRacunForma());
        azurirajRacunController.otvoriFormu();
    }

    public void otvoriRacunZaPrikazFormu() {
        azurirajRacunController = new AzurirajRacunController(new AzurirajRacunForma());
        azurirajRacunController.otvoriFormuZaPrikaz();
    }

    public void otvoriAzurirajStavkuFormu() {
        azurirajStavkuController = new AzurirajStavkuController(new AzurirajStavkuForma());
        azurirajStavkuController.otvoriFormu();
    }

    public void izmeniStavku() {
        azurirajRacunController.izmeniStavku();
    }
    
    public void osveziFormuRacun() {
        prikazRacunController.osveziFormu();
    }

    public void otvoriKupacZaPrikazFormu() {
        azurirajKupacController = new AzurirajKupacController(new AzurirajKupacForma());
        azurirajKupacController.otvoriFormuZaPrikaz();
    }
    
}