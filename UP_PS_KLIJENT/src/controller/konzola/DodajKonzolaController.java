/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.konzola;

import domen.Konzola;
import forme.konzola.DodajKonzolaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class DodajKonzolaController {
    private final DodajKonzolaForma dkf;

    public DodajKonzolaController(DodajKonzolaForma dkf) {
        this.dkf = dkf;
        addActionListener();
    }

    

    private void addActionListener() {
        dkf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = dkf.getjTextFieldNaziv().getText().trim();
                double cena;
                try {
                    cena = Double.parseDouble(dkf.getjTextFieldCena().getText().trim());
                } catch (NumberFormatException ex) {
                    System.out.println("Greska, cena mora da bude broj");
                    JOptionPane.showMessageDialog(dkf, "Sistem ne moze da doda konzolu", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                String opis = dkf.getjTextAreaOpis().getText().trim();
                
                Konzola k = new Konzola(-1,naziv,cena,opis);
                
                try{
                    Komunikacija.getInstance().dodajKonzolu(k);
                    JOptionPane.showMessageDialog(dkf, "Sistem je dodao konzolu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    dkf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dkf, "Sistem ne moze da doda konzolu", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    
    public void otvoriFormu(){
        dkf.setVisible(true);
    }
}
