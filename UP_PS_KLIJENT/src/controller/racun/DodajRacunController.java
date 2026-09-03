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
import forme.racun.DodajRacunForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class DodajRacunController {
    private final DodajRacunForma drf;
    private int rb = 0;
    private Racun racun;
    private List<StavkaRacuna> stavke = new ArrayList<>();
    private double ukupanIznos = 0;

    public DodajRacunController(DodajRacunForma drf) {
        this.drf = drf;
        addActionListeners();
        racun = new Racun();
        
        ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna(stavke);
        drf.getjTableStavke().setModel(mts);
    }
    
    
    private void addActionListeners() {
//        drf.kreirajRacunAddActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                
//                try{
//                    racun = new Racun();
//                    JOptionPane.showMessageDialog(drf, "Sistem je kreirao racun", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
//                    
//                    drf.getjSpinner().setEnabled(true);
//                    drf.getjComboBoxLaptop().setEnabled(true);
//                    drf.getjButtonDodajStavku().setEnabled(true);
//                    drf.getjButtonSacuvaj().setEnabled(true);
//                    drf.getjTableStavke().setEnabled(true);
//                    
//                }catch(Exception ex){
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(drf, "Sistem ne moze da kreira racun", "Greska", JOptionPane.WARNING_MESSAGE);
//                }        
//                   
//            }
//        });
        
        drf.dodajStavkuAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Konzola konzola = (Konzola) drf.getjComboBoxLaptop().getSelectedItem();
                int kolicina = (int) drf.getjSpinner().getValue();
                rb++;
                StavkaRacuna s = new StavkaRacuna(racun.getIdRacun(), rb, konzola.getCena(), kolicina, konzola.getCena()*kolicina, konzola);
                stavke.add(s);
                ukupanIznos += (konzola.getCena()*kolicina);
                      
                osveziTabelu();
                drf.getjLabelIznos().setText(ukupanIznos+"");
            }
        });
        
        
        drf.sacuvajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(ukupanIznos==0){
                    JOptionPane.showMessageDialog(drf, "Sistem ne moze da zapamti racun", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Prodavac p = (Prodavac) drf.getjComboBoxProdavac().getSelectedItem();
                Kupac k = (Kupac) drf.getjComboBoxKupac().getSelectedItem();
                
                Date d = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    d = sdf.parse(drf.getjTextFieldDatum().getText());
                } catch (ParseException ex) {
                    Logger.getLogger(DodajRacunController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                Racun r = new Racun(-1,d,ukupanIznos,p,k,stavke);
                
                
                
                try{
                    Komunikacija.getInstance().dodajRacun(r);
                    JOptionPane.showMessageDialog(drf, "Sistem je zapamtio racun", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    drf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(drf, "Sistem ne moze da zapamti racun", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    
    
    
    
    
    public void otvoriFormu(){
        drf.setVisible(true);
        pripremiFormu();
    }

    private void pripremiFormu() {
        List<Prodavac> prodavci = Komunikacija.getInstance().ucitajProdavce();
        for (Prodavac p : prodavci) {
            drf.getjComboBoxProdavac().addItem(p);
        }
        List<Kupac> kupci = Komunikacija.getInstance().ucitajKupce();
        for (Kupac k : kupci) {
            drf.getjComboBoxKupac().addItem(k);
        }
        
        Prodavac prodavac = Cordinator.getInstance().getUlogovani();
        drf.getjComboBoxProdavac().setSelectedItem(prodavac);
        drf.getjComboBoxProdavac().setEnabled(false);
        
        LocalDate datum = LocalDate.now();
        drf.getjTextFieldDatum().setText(datum+"");
        drf.getjTextFieldDatum().setEnabled(false);
        
        List<Konzola> konzole = Komunikacija.getInstance().ucitajKonzole();
        for (Konzola k : konzole) {
            drf.getjComboBoxLaptop().addItem(k);
        }
        
//        drf.getjSpinner().setEnabled(false);
//        drf.getjComboBoxLaptop().setEnabled(false);
//        drf.getjButtonDodajStavku().setEnabled(false);
//        drf.getjButtonSacuvaj().setEnabled(false);
//        drf.getjTableStavke().setEnabled(false);
        drf.getjButtonKreirajRacun().setVisible(false);
        
        drf.getjLabelIznos().setText(ukupanIznos+"");
        
    }
    
    

    private void osveziTabelu(){
        ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna(stavke);
        drf.getjTableStavke().setModel(mts);
    }
    
}
