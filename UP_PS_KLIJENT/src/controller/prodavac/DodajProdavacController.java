/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.prodavac;

import domen.Prodavac;
import forme.prodavac.DodajProdavacForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class DodajProdavacController {
    private final DodajProdavacForma dpf;

    public DodajProdavacController(DodajProdavacForma dpf) {
        this.dpf = dpf;
        addActionListener();
    }
    
    private void addActionListener() {
        dpf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String ime = dpf.getjTextFieldIme().getText().trim();
                String prezime = dpf.getjTextFieldPrezime().getText().trim();
                String korisnickoIme = dpf.getjTextFieldKorisnickoIme().getText().trim();
                String sifra = String.valueOf(dpf.getjPasswordField().getPassword()).trim();
                
                Prodavac p = new Prodavac(-1,ime,prezime,korisnickoIme,sifra);
                
                
                try{
                    Komunikacija.getInstance().dodajProdavca(p);
                    JOptionPane.showMessageDialog(dpf, "Sistem je dodao prodavca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    dpf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dpf, "Sistem ne moze da doda prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                }        
                   
            }
        });
    }

    public void otvoriFormu(){
        dpf.setVisible(true);
    }
    
}
