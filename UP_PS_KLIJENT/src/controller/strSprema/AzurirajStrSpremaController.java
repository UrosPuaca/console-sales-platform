/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.strSprema;

import cordinator.Cordinator;
import domen.StrSprema;
import forme.strSprema.AzurirajStrSpremaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class AzurirajStrSpremaController {
    private final AzurirajStrSpremaForma asf;

    public AzurirajStrSpremaController(AzurirajStrSpremaForma asf) {
        this.asf = asf;
        addActionListener();
    }
    
    public void otvoriFormu(){
        pripremiFOrmu();
        asf.setVisible(true);
    }

    private void pripremiFOrmu() {
        StrSprema s = (StrSprema) Cordinator.getInstance().vratiParametar("strsprema");
        asf.getjTextFieldId().setText(s.getIdStrSprema()+"");
        asf.getjTextFieldId().setEnabled(false);
        asf.getjTextFieldIme().setText(s.getNaziv());
    }

    private void addActionListener() {
        asf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                int id = Integer.parseInt(asf.getjTextFieldId().getText().trim());
                String naziv = asf.getjTextFieldIme().getText().trim();
                
                StrSprema s = new StrSprema(id,naziv);
                try{
                    Komunikacija.getInstance().azurirajStrSprema(s);
                    JOptionPane.showMessageDialog(asf, "Sistem je uspesno sacuvao strucnu spremu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    asf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(asf, "Sistem ne moze da sacuva strucnu spremu", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
