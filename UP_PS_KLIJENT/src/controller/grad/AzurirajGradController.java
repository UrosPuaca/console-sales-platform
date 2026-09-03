/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.grad;

import cordinator.Cordinator;
import domen.Grad;
import forme.grad.AzurirajGradForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class AzurirajGradController {
    private final AzurirajGradForma agf;

    public AzurirajGradController(AzurirajGradForma agf) {
        this.agf = agf;
        addActionListener();
    }
    
    public void otvoriFormu(){
        pripremiFOrmu();
        agf.setVisible(true);
    }
    
    private void pripremiFOrmu() {
        Grad g = (Grad) Cordinator.getInstance().vratiParametar("grad");
        agf.getjTextFieldId().setText(g.getIdGrad()+"");
        agf.getjTextFieldId().setEnabled(false);
        agf.getjTextFieldIme().setText(g.getNaziv());
    }

    private void addActionListener() {
        agf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                int id = Integer.parseInt(agf.getjTextFieldId().getText().trim());
                String naziv = agf.getjTextFieldIme().getText().trim();
                
                Grad g = new Grad(id,naziv);
                try{
                    Komunikacija.getInstance().azurirajGrad(g);
                    JOptionPane.showMessageDialog(agf, "Sistem je sacuvao grad", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    agf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(agf, "Sistem ne moze da sacuva grad", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    
    
    
}
