/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.kupac;

import cordinator.Cordinator;
import domen.Grad;
import domen.Kupac;
import forme.kupac.AzurirajKupacForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class AzurirajKupacController {
    private final AzurirajKupacForma akf;
    private Kupac k;
    
    public AzurirajKupacController(AzurirajKupacForma akf) {
        this.akf = akf;
        addActionListener();
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        akf.setVisible(true);
        akf.getjButtonObrisi().setVisible(false);
    }
    
    private void pripremiFormu() {
        
        List<Grad> gradovi = komunikacija.Komunikacija.getInstance().ucitajGradove();
        
        for (Grad g : gradovi) {
            akf.getjComboBoxGrad().addItem(g);
        }
        
        k = (Kupac) Cordinator.getInstance().vratiParametar("kupac");
        akf.getjTextFieldId().setText(k.getIdKupac()+"");
        akf.getjTextFieldId().setEnabled(false);
        akf.getjTextFieldIme().setText(k.getIme());
        akf.getjTextFieldPrezime().setText(k.getPrezime());
        akf.getjTextFieldEmail().setText(k.getEmail());
        akf.getjTextFieldTelefon().setText(k.getTelefon());
        akf.getjComboBoxGrad().setSelectedItem(k.getGrad());
        
    }

    private void addActionListener() {
        akf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                int id = Integer.parseInt(akf.getjTextFieldId().getText().trim());
                String ime = akf.getjTextFieldIme().getText().trim();
                String prezime = akf.getjTextFieldPrezime().getText().trim();
                String email = akf.getjTextFieldEmail().getText().trim();
                String telefon = akf.getjTextFieldTelefon().getText().trim();
                Grad grad = (Grad) akf.getjComboBoxGrad().getSelectedItem();
                
                Kupac k = new Kupac(id,ime,prezime,email,telefon,grad);
                try{
                    Komunikacija.getInstance().azurirajKupca(k);
                    JOptionPane.showMessageDialog(akf, "Sistem je zapamtio kupca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    akf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(akf, "Sistem ne moze da zapamti kupca", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        akf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    komunikacija.Komunikacija.getInstance().obrisiKupca(k);
                    JOptionPane.showMessageDialog(akf, "Sistem je obrisao kupca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    akf.dispose();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(akf, "Sistem ne moze da obrise kupca", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                 
            }
        });
        
        
    }
    
    public void otvoriFormuZaPrikaz() {
        pripremiFormu();
        akf.setVisible(true);
        
        akf.getjTextFieldIme().setEnabled(false);
        akf.getjTextFieldPrezime().setEnabled(false);
        akf.getjTextFieldEmail().setEnabled(false);
        akf.getjTextFieldTelefon().setEnabled(false);
        akf.getjComboBoxGrad().setEnabled(false);
        akf.getjButtonAzuriraj().setVisible(false);
        
    }
    
}
