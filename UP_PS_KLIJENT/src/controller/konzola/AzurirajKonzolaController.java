/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.konzola;

import cordinator.Cordinator;
import domen.Konzola;
import forme.konzola.AzurirajKonzolaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class AzurirajKonzolaController {
    private final AzurirajKonzolaForma akf;

    public AzurirajKonzolaController(AzurirajKonzolaForma akf) {
        this.akf = akf;
        addActionListener();
    }
    
    
    private void addActionListener() {
        akf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                int id = Integer.parseInt(akf.getjTextFieldId().getText().trim());
                
                String naziv = akf.getjTextFieldNaziv().getText().trim();
                
                double cena;
                
                try {
                    cena = Double.parseDouble(akf.getjTextFieldCena().getText().trim());
                } catch (NumberFormatException ex) {
                    System.out.println("Greska, cena mora da bude broj");
                    JOptionPane.showMessageDialog(akf, "Sistem ne moze da sacuva konzolu", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String opis = akf.getjTextAreaOpis().getText().trim();
                
                Konzola k = new Konzola(id,naziv,cena,opis);
                try{
                    Komunikacija.getInstance().azurirajKonzolu(k);
                    JOptionPane.showMessageDialog(akf, "Sistem je sacuvao konzolu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    akf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(akf, "Sistem ne moze da sacuva konzolu", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    
    
    
    
    
    
    
    
    public void otvoriFormu() {
        pripremiFormu();
        akf.setVisible(true);
    }

    private void pripremiFormu() {
        Konzola k = (Konzola) Cordinator.getInstance().vratiParametar("konzola");
        akf.getjTextFieldId().setText(k.getIdKonzola()+"");
        akf.getjTextFieldId().setEnabled(false);
        akf.getjTextFieldNaziv().setText(k.getNaziv());
        akf.getjTextFieldCena().setText(k.getCena()+"");
        akf.getjTextAreaOpis().setText(k.getOpis());
    }
    
}
