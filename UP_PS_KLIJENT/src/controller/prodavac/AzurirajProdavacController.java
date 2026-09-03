/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.prodavac;

import cordinator.Cordinator;
import domen.Prodavac;
import forme.prodavac.AzurirajProdavacForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class AzurirajProdavacController {
    private final AzurirajProdavacForma apf;

    public AzurirajProdavacController(AzurirajProdavacForma apf) {
        this.apf = apf;
        addActionListener();
    }

    private void addActionListener() {
        apf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                int id = Integer.parseInt(apf.getjTextFieldId().getText().trim());
                String ime = apf.getjTextFieldIme().getText().trim();
                String prezime = apf.getjTextFieldPrezime().getText().trim();
                String korisnickoIme = apf.getjTextFieldKorisnickoIme().getText().trim();
                String sifra = String.valueOf(apf.getjPasswordField().getPassword()).trim();
                
                Prodavac p = new Prodavac(id,ime,prezime,korisnickoIme,sifra);
                try{
                    Komunikacija.getInstance().azurirajProdavca(p);
                    JOptionPane.showMessageDialog(apf, "Sistem je azurirao prodavca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    apf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(apf, "Sistem ne moze da azurira prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        apf.setVisible(true);
    }
    
    public void pripremiFormu() {
        Prodavac p = (Prodavac) Cordinator.getInstance().vratiParametar("prodavac");
        apf.getjTextFieldId().setText(p.getIdProdavac()+"");
        apf.getjTextFieldId().setEnabled(false);
        apf.getjTextFieldIme().setText(p.getIme());
        apf.getjTextFieldPrezime().setText(p.getPrezime());
        apf.getjTextFieldKorisnickoIme().setText(p.getKorisnickoIme());
        apf.getjPasswordField().setText(p.getSifra());
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
}
