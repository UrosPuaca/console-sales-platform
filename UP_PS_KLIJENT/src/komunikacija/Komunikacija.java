/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Grad;
import domen.Konzola;
import domen.Kupac;
import domen.Prodavac;
import domen.Racun;
import domen.StavkaRacuna;
import domen.StrSprema;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puaca
 */
public class Komunikacija {
    private static Komunikacija instance;
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private Komunikacija() {
        
    }

    public static Komunikacija getInstance() {
        if(instance==null){
            instance=new Komunikacija();
        }
        return instance;
    }
    
    
    public void konekcija(){
        try {
            socket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            System.out.println("Server nije povezan");
        }
    }

    public Prodavac login(String korisnickoIme, String sifra) {
        Prodavac p = new Prodavac();
        p.setKorisnickoIme(korisnickoIme);
        p.setSifra(sifra);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, p);
        
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        p = (Prodavac) odg.getOdgovor();
        
        return p;
    }

    public List<Grad> ucitajGradove() {
        List<Grad> gradovi = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_GRADOVE, null);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        gradovi = (List<Grad>) odg.getOdgovor();
        return gradovi;
    }

    public List<StrSprema> ucitajStrSpreme() {
        List<StrSprema> spreme = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_STR_SPREMA, null);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        spreme = (List<StrSprema>) odg.getOdgovor();
        return spreme;
    }

    public List<Konzola> ucitajKonzole() {
        List<Konzola> konzole = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KONZOLE, null);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        konzole = (List<Konzola>) odg.getOdgovor();
        return konzole;
    }

    public List<Kupac> ucitajKupce() {
        List<Kupac> kupci = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KUPCE, null);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        kupci = (List<Kupac>) odg.getOdgovor();
        return kupci;
    }

    public List<Prodavac> ucitajProdavce() {
        List<Prodavac> prodavci = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_PRODAVCE, null);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        prodavci = (List<Prodavac>) odg.getOdgovor();
        return prodavci;
    }

    public void obrisiKonzolu(Konzola k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_KONZOLU, k);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno obrisan");
        }else{
            System.out.println("Greska pri brisanju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void obrisiStrSprema(StrSprema s) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_STR_SPREMA, s);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno obrisan");
        }else{
            Exception ex = (Exception) odg.getOdgovor();
            throw ex;
        }
    }

    public void obrisiKupca(Kupac k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_KUPAC, k);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno obrisan");
        }else{
            Exception ex = (Exception) odg.getOdgovor();
            throw ex;
        }
    }

    public void obrisiGrad(Grad g) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_GRAD, g);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno obrisan");
        }else{
            Exception ex = (Exception) odg.getOdgovor();
            throw ex;
        }
    }

    public void obrisiProdavca(Prodavac p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_PRODAVCA, p);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno obrisan");
        }else{
            System.out.println("Greska pri brisanju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void dodajGrad(Grad g) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_GRAD, g);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno dodat");
        }else{
            Exception ex = (Exception) odg.getOdgovor();
            throw ex;
        }
    }

    public void dodajProdavca(Prodavac p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_PRODAVCA, p);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno dodat");
        }else{
            System.out.println("Greska pri dodavanju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void dodajKonzolu(Konzola k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_KONZOLU, k);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno dodat");
        }else{
            System.out.println("Greska pri dodavanju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void dodajStrSpremu(StrSprema s) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.UBACI_STR_SPREMA, s);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno dodat");
        }else{
            System.out.println("Greska pri dodavanju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void dodajKupac(Kupac k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_KUPCA, k);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno dodat");
        }else{
            System.out.println("Greska pri dodavanju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void azurirajKonzolu(Konzola k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_KONZOLU, k);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno azuriran");
            cordinator.Cordinator.getInstance().osveziFormuKonzola();
        }else{
            System.out.println("Greska pri azuriranju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void azurirajGrad(Grad g) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_GRAD, g);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno azuriran");
            cordinator.Cordinator.getInstance().osveziFormuGrad();
        }else{
            System.out.println("Greska pri azuriranju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void azurirajStrSprema(StrSprema s) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_STR_SPREMA, s);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno azuriran");
            cordinator.Cordinator.getInstance().osveziFormuStrSprema();
        }else{
            System.out.println("Greska pri azuriranju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void azurirajProdavca(Prodavac p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_PRODAVCA, p);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno azuriran");
            cordinator.Cordinator.getInstance().osveziFormuProdavac();
        }else{
            System.out.println("Greska pri azuriranju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public void azurirajKupca(Kupac k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_KUPCA, k);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno azuriran");
            cordinator.Cordinator.getInstance().osveziFormuKupac();
        }else{
            System.out.println("Greska pri azuriranju");
            Exception ex = (Exception) odg.getOdgovor();
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<Grad> ucitajGradove(String naziv) {
        List<Grad> gradovi = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_GRADOVE_PO_NAZIVU, naziv);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        gradovi = (List<Grad>) odg.getOdgovor();
        return gradovi;
    }

    public List<StrSprema> ucitajStrSpreme(String naziv) {
        List<StrSprema> spreme = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_STR_SPREMA_PO_NAZIVU, naziv);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        spreme = (List<StrSprema>) odg.getOdgovor();
        return spreme;
    }

    public List<Prodavac> ucitajProdavce(String prezime) {
        List<Prodavac> prodavci = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_PRODAVCE_PO_PREZIMENU, prezime);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        prodavci = (List<Prodavac>) odg.getOdgovor();
        return prodavci;
    }

    public List<Kupac> ucitajKupce(String prezime) {
        List<Kupac> kupci = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KUPAC_PO_PREZIMENU, prezime);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        kupci = (List<Kupac>) odg.getOdgovor();
        return kupci;
    }

    public List<Konzola> ucitajKonzole(String naziv) {
        List<Konzola> konzole = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KONZOLE_PO_NAZIVU, naziv);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        konzole = (List<Konzola>) odg.getOdgovor();
        return konzole;
    }

    public List<Racun> ucitajRacune() {
        List<Racun> racuni = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_RACUN, null);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        racuni = (List<Racun>) odg.getOdgovor();
        return racuni;
    }

    public void dodajRacun(Racun r) throws Exception {
        System.out.println(r);
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_RACUN, r);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno dodat");
        }
        else{
            Exception ex = (Exception) odg.getOdgovor();
            throw ex;
        }
    }

    public Racun ucitajRacun(Racun r) {
        Zahtev zahtev = new Zahtev(Operacija.VRATI_RACUN, r);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        r = (Racun) odg.getOdgovor();
        return r;
    }

    public void azurirajRacun(Racun racun) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_RACUN, racun);
        posiljalac.posalji(zahtev);
        
        System.out.println("#####################");
        System.out.println(racun);
        for (StavkaRacuna s : racun.getStavke()) {
            System.out.println(s);
        }
        
        Odgovor odg = (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("Uspesno azuriran");
            cordinator.Cordinator.getInstance().osveziFormuRacun();
        }else{
            Exception ex = (Exception) odg.getOdgovor();
            throw ex;
        }
    }

    public List<Racun> ucitajRacune(Prodavac p) {
        List<Racun> racuni = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_RACUN_PO_PRODAVCU, p);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        racuni = (List<Racun>) odg.getOdgovor();
        return racuni;
    }

    public List<Racun> ucitajRacune(Kupac k) {
        List<Racun> racuni = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_RACUN_PO_KUPCU, k);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        racuni = (List<Racun>) odg.getOdgovor();
        return racuni;
    }

    public List<Kupac> ucitajKupce(Grad g) {
        List<Kupac> kupci = new ArrayList<>(); 
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KUPAC_PO_GRADU, g);
        posiljalac.posalji(zahtev);
        
        Odgovor odg = (Odgovor) primalac.primi();
        kupci = (List<Kupac>) odg.getOdgovor();
        return kupci;
    }
    
}