/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.kupac;

import domen.Grad;
import domen.Kupac;
import forme.kupac.DodajKupacForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class DodajKupacController {
    private final DodajKupacForma dkf;

    public DodajKupacController(DodajKupacForma dkf) {
        this.dkf = dkf;
        addActionListener();
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        dkf.setVisible(true);
    }

    private void addActionListener() {
            dkf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String ime = dkf.getjTextFieldIme().getText().trim();
                String prezime = dkf.getjTextFieldPrezime().getText().trim();
                String email = dkf.getjTextFieldEmail().getText().trim();
                String telefon = dkf.getjTextFieldTelefon().getText().trim();
                Grad grad = (Grad) dkf.getjComboBoxGrad().getSelectedItem();
                
                Kupac k = new Kupac(-1,ime,prezime,email,telefon,grad);
                
                
                try{
                    Komunikacija.getInstance().dodajKupac(k);
                    JOptionPane.showMessageDialog(dkf, "Sistem je zapamtio kupca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    dkf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dkf, "Sistem ne moze da zapamti kupca", "Greska", JOptionPane.ERROR_MESSAGE);
                }        
                   
            }
        });
    }

    private void pripremiFormu() {
        List<Grad> gradovi = komunikacija.Komunikacija.getInstance().ucitajGradove();
        for (Grad g : gradovi) {
            dkf.getjComboBoxGrad().addItem(g);
        }
    }
    
}
