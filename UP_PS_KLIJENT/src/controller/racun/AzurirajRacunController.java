/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.racun;

import cordinator.Cordinator;
import domen.Konzola;
import domen.Kupac;
import domen.Prodavac;
import domen.Racun;
import domen.StavkaRacuna;
import forme.model.ModelTabeleStavkaRacuna;
import forme.racun.AzurirajRacunForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class AzurirajRacunController {
    private final AzurirajRacunForma arf;
    private int rb = 0;
    private Racun racun;
    private List<StavkaRacuna> stavke = new ArrayList<>();
    private double ukupanIznos = 0;

    public AzurirajRacunController(AzurirajRacunForma arf) {
        this.arf = arf;
        addActionListeners();
    }
    
    public void otvoriFormu(){
        arf.setVisible(true);
        pripremiFormu();
    }
    
    public void pripremiFormu(){
        List<Prodavac> prodavci = Komunikacija.getInstance().ucitajProdavce();
        for (Prodavac p : prodavci) {
            arf.getjComboBoxProdavac1().addItem(p);
        }
        List<Kupac> kupci = Komunikacija.getInstance().ucitajKupce();
        for (Kupac k : kupci) {
            arf.getjComboBoxKupac().addItem(k);
        }
        List<Konzola> konzole = Komunikacija.getInstance().ucitajKonzole();
        for (Konzola k : konzole) {
            arf.getjComboBoxKonzola().addItem(k);
        }
        
        racun = (Racun) Cordinator.getInstance().vratiParametar("racun");
        
        Prodavac p = racun.getProdavac();
        arf.getjComboBoxProdavac1().setSelectedItem(p);
        arf.getjComboBoxProdavac1().setEnabled(false);
        
        Kupac k = racun.getKupac();
        arf.getjComboBoxKupac().setSelectedItem(k);
        arf.getjComboBoxKupac().setEnabled(false);
        
        arf.getjTextFieldDatum().setText(racun.getDatum()+"");
        arf.getjTextFieldDatum().setEnabled(false);
        
        arf.getjButtonKreirajRacun().setEnabled(false);
        
        Racun r = Komunikacija.getInstance().ucitajRacun(racun);
        for (StavkaRacuna sr : r.getStavke()) {
            stavke.add(sr);
        }
        ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna(stavke);
        arf.getjTableStavke().setModel(mts);
        
        arf.getjLabelIznos().setText(racun.getUkupanIznos()+"");
        ukupanIznos = racun.getUkupanIznos();
        
        StavkaRacuna zadnja = stavke.get(stavke.size()-1);
        rb = zadnja.getRb();
        
        arf.getjButtonKreirajRacun().setVisible(false);
    }

    private void addActionListeners() {
        arf.dodajStavkuAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Konzola konzola = (Konzola) arf.getjComboBoxKonzola().getSelectedItem();
                int kolicina = (int) arf.getjSpinner().getValue();
                rb++;
                StavkaRacuna s = new StavkaRacuna(racun.getIdRacun(), rb, konzola.getCena(), kolicina, konzola.getCena()*kolicina, konzola, 2);
                stavke.add(s);
                ukupanIznos += (konzola.getCena()*kolicina);
                      
                osveziTabelu();
                arf.getjLabelIznos().setText(ukupanIznos+"");
            }
        });
        
        arf.obrisiStavkuAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = arf.getjTableStavke().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovali stavku");
                    JOptionPane.showMessageDialog(arf, "Selektuj stavku koju zelis da obrises", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModelTabeleStavkaRacuna mts = (ModelTabeleStavkaRacuna) arf.getjTableStavke().getModel();
                StavkaRacuna s = mts.getLista().get(red);
                
                s.setStatus(3);
                
                osveziTabelu();
                
                ukupanIznos = 0;
                for (StavkaRacuna sr : stavke) {
                    if(sr.getStatus()!=3){
                        ukupanIznos += sr.getIznos();
                    }
                }
                arf.getjLabelIznos().setText(ukupanIznos+"");
            }
        });
        
        arf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = arf.getjTableStavke().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovali stavku");
                    JOptionPane.showMessageDialog(arf, "Selektuj stavku koju zelis da izmenis", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ModelTabeleStavkaRacuna mts = (ModelTabeleStavkaRacuna) arf.getjTableStavke().getModel();
                StavkaRacuna s = mts.getLista().get(red);
                
                cordinator.Cordinator.getInstance().dodajParam("stavka", s);
                cordinator.Cordinator.getInstance().otvoriAzurirajStavkuFormu();
            }
        });
        
        arf.sacuvajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                
                if(ukupanIznos==0){
                    JOptionPane.showMessageDialog(arf, "Sistem ne moze da zapamti racun", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                racun.setStavke(stavke);
                racun.setUkupanIznos(ukupanIznos);
                try{
                    Komunikacija.getInstance().azurirajRacun(racun);
                    JOptionPane.showMessageDialog(arf, "Sistem je zapamtio racun", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    arf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(arf, "Sistem ne moze da zapamti racun", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    public void osveziTabelu(){
        List<StavkaRacuna> stavkeZaPrikaz = new ArrayList<>();
        for (StavkaRacuna sr : stavke) {
            if(sr.getStatus()!=3){
                stavkeZaPrikaz.add(sr);
            }
        }
        ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna(stavkeZaPrikaz);
        arf.getjTableStavke().setModel(mts);
    }

    public void izmeniStavku() {
        StavkaRacuna stavkaZaIzmenu = (StavkaRacuna) cordinator.Cordinator.getInstance().vratiParametar("izmenjenaStavka");
        for (StavkaRacuna sr : stavke) {
            if(sr.getRb()==stavkaZaIzmenu.getRb()){
                sr.setKolicina(stavkaZaIzmenu.getKolicina());
                sr.setIznos(sr.getKolicina()*sr.getProdajnaCena());
                sr.setStatus(1);
                break;
            }
        }
        
        ukupanIznos = 0;
        for (StavkaRacuna sr : stavke) {
            if(sr.getStatus()!=3){
                ukupanIznos += sr.getIznos();
            }
        }
        arf.getjLabelIznos().setText(ukupanIznos+"");
        
        osveziTabelu();
    }

    public void otvoriFormuZaPrikaz() {
        arf.setVisible(true);
        pripremiFormu();
        arf.getjButtonDodajStavku().setVisible(false);
        arf.getjButtonSacuvaj().setVisible(false);
        arf.getjButtonKreirajRacun().setVisible(false);
        arf.getjButtonObrisiStavku().setVisible(false);
        arf.getjButtonIzmeniStavku().setVisible(false);
        arf.getjSpinner().setVisible(false);
        arf.getjLabelNaziv().setVisible(false);
        arf.getjLabelKolicina().setVisible(false);
        arf.getjComboBoxKonzola().setVisible(false);
    }
}