/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Grad;
import domen.Konzola;
import domen.Kupac;
import domen.Prodavac;
import domen.Racun;
import domen.StrSprema;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author puaca
 */
public class ObradaKlijentskihZahteva extends Thread{
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket=socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }
    

    @Override
    public void run() {
        while(!kraj){
            try{
            Zahtev zahtev = (Zahtev) primalac.primi();
            Odgovor odgovor = new Odgovor();
            
            if (zahtev == null) {
                System.out.println("Klijent se diskonektovao, prekidam nit.");
                break;
            }
            
            switch (zahtev.getOperacija()){
                case LOGIN:
                    Prodavac p = (Prodavac) zahtev.getParametar();
                    p = Controller.getInstance().login(p);
                    odgovor.setOdgovor(p);
                    break;
                case UCITAJ_GRADOVE:
                    List<Grad> gradovi = Controller.getInstance().ucitajGradove();
                    odgovor.setOdgovor(gradovi);
                    break;
                case UCITAJ_STR_SPREMA:
                    List<StrSprema> spreme = Controller.getInstance().ucitajStrSpreme();
                    odgovor.setOdgovor(spreme);
                    break;
                case UCITAJ_KONZOLE:
                    List<Konzola> konzole = Controller.getInstance().ucitajKonzole();
                    odgovor.setOdgovor(konzole);
                    break;
                case UCITAJ_KUPCE:
                    List<Kupac> kupci = Controller.getInstance().ucitajKupce();
                    odgovor.setOdgovor(kupci);
                    break;
                case UCITAJ_PRODAVCE:
                    List<Prodavac> prodavci = Controller.getInstance().ucitajProdavce();
                    odgovor.setOdgovor(prodavci);
                    break;
                case OBRISI_KONZOLU:
                    try{
                        Konzola k1 = (Konzola) zahtev.getParametar();
                        Controller.getInstance().obrisiKonzolu(k1);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case OBRISI_STR_SPREMA:
                    try{
                        StrSprema ss = (StrSprema) zahtev.getParametar();
                        Controller.getInstance().obrisiStrSprema(ss);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case OBRISI_KUPAC:
                    try{
                        Kupac k = (Kupac) zahtev.getParametar();
                        Controller.getInstance().obrisiKupac(k);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case OBRISI_GRAD:
                    try{
                        Grad g1 = (Grad) zahtev.getParametar();
                        Controller.getInstance().obrisiGrad(g1);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case OBRISI_PRODAVCA:
                    try{
                        Prodavac p1 = (Prodavac) zahtev.getParametar();
                        Controller.getInstance().obrisiProdavca(p1);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case DODAJ_GRAD:
                    try{
                        Grad g = (Grad) zahtev.getParametar();
                        Controller.getInstance().dodajGrad(g);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case DODAJ_PRODAVCA:
                    try{
                        Prodavac p2 = (Prodavac) zahtev.getParametar();
                        Controller.getInstance().dodajProdavca(p2);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case DODAJ_KONZOLU:
                    try{
                        Konzola k = (Konzola) zahtev.getParametar();
                        Controller.getInstance().dodajKonzolu(k);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case UBACI_STR_SPREMA:
                    try{
                        StrSprema s = (StrSprema) zahtev.getParametar();
                        Controller.getInstance().ubaciStrSpremu(s);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case DODAJ_KUPCA:
                    try{
                        Kupac k = (Kupac) zahtev.getParametar();
                        Controller.getInstance().dodajKupca(k);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case AZURIRAJ_KONZOLU:
                    try{
                        Konzola k2 = (Konzola) zahtev.getParametar();
                        Controller.getInstance().azurirajKonzolu(k2);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case AZURIRAJ_GRAD:
                    try{
                        Grad g2 = (Grad) zahtev.getParametar();
                        Controller.getInstance().azurirajGrad(g2);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case AZURIRAJ_STR_SPREMA:
                    try{
                        StrSprema s2 = (StrSprema) zahtev.getParametar();
                        Controller.getInstance().azurirajStrSprema(s2);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case AZURIRAJ_PRODAVCA:
                    try{
                        Prodavac p2 = (Prodavac) zahtev.getParametar();
                        Controller.getInstance().azurirajProdavca(p2);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case AZURIRAJ_KUPCA:
                    try{
                        Kupac k2 = (Kupac) zahtev.getParametar();
                        Controller.getInstance().azurirajKupca(k2);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case UCITAJ_GRADOVE_PO_NAZIVU:
                    String naziv = (String) zahtev.getParametar();
                    List<Grad> gradovi1 = Controller.getInstance().ucitajGradove(naziv);
                    odgovor.setOdgovor(gradovi1);
                    break;
                case UCITAJ_STR_SPREMA_PO_NAZIVU:
                    String naziv2 = (String) zahtev.getParametar();
                    List<StrSprema> spreme1 = Controller.getInstance().ucitajStrSpreme(naziv2);
                    odgovor.setOdgovor(spreme1);
                    break;
                case UCITAJ_PRODAVCE_PO_PREZIMENU:
                    String prezime = (String) zahtev.getParametar();
                    Prodavac prodavac = new Prodavac();
                    prodavac.setPrezime(prezime);
                    List<Prodavac> prodavci1 = Controller.getInstance().ucitajProdavce(prodavac);
                    odgovor.setOdgovor(prodavci1);
                    break;
                case UCITAJ_KUPAC_PO_PREZIMENU:
                    String prezime1 = (String) zahtev.getParametar();
                    Kupac kupac = new Kupac();
                    kupac.setPrezime(prezime1);
                    List<Kupac> kupci2 = Controller.getInstance().ucitajKupce(kupac);
                    odgovor.setOdgovor(kupci2);
                    break;
                case UCITAJ_KONZOLE_PO_NAZIVU:
                    String naziv1 = (String) zahtev.getParametar();
                    List<Konzola> konzole2 = Controller.getInstance().ucitajKonzole(naziv1);
                    odgovor.setOdgovor(konzole2);
                    break;
                case UCITAJ_RACUN:
                    List<Racun> racuni = Controller.getInstance().ucitajRacune();
                    odgovor.setOdgovor(racuni);
                    break;
                case DODAJ_RACUN:
                    try{
                        Racun r = (Racun) zahtev.getParametar();
                        System.out.println(r);
                        Controller.getInstance().dodajRacun(r);
                        odgovor.setOdgovor(null);
                    }catch(Exception e){
                        odgovor.setOdgovor(e);
                    }
                    break;
                case VRATI_RACUN:
                    Racun r = (Racun) zahtev.getParametar();
                    r = Controller.getInstance().vratiRacun(r);
                    odgovor.setOdgovor(r);
                    break;
                case UCITAJ_RACUN_PO_PRODAVCU:
                    Prodavac p4 = (Prodavac) zahtev.getParametar();
                    List<Racun> racuni1 = Controller.getInstance().ucitajRacune(p4);
                    odgovor.setOdgovor(racuni1);
                    break;
                case UCITAJ_RACUN_PO_KUPCU:
                    Kupac k4 = (Kupac) zahtev.getParametar();
                    List<Racun> racuni2 = Controller.getInstance().ucitajRacune(k4);
                    odgovor.setOdgovor(racuni2);
                    break;
                case UCITAJ_KUPAC_PO_GRADU:
                    Grad g = (Grad) zahtev.getParametar();
                    List<Kupac> kupci1 = Controller.getInstance().ucitajKupce(g);
                    odgovor.setOdgovor(kupci1);
                    break;
                
                    
                
                default:
                    System.out.println("Greska operacija ne postoji");
                
            }
            
            
            
            posiljalac.posalji(odgovor);
            
            
            }catch(Exception ex){
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
    
    
    public void prekini(){
        kraj=true;
        
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        interrupt();
    }
    
    
}
