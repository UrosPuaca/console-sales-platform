/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.racun;

import domen.StavkaRacuna;
import forme.racun.AzurirajStavkuForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author puaca
 */
public class AzurirajStavkuController {
    private final AzurirajStavkuForma asf;
    private StavkaRacuna s;

    public AzurirajStavkuController(AzurirajStavkuForma asf) {
        this.asf = asf;
        addActionListener();
    }
    
    public void otvoriFormu(){
        asf.setVisible(true);
        pripremiFormu();
    }

    private void addActionListener() {
        asf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kolicina;
                try{
                    kolicina = Integer.parseInt(asf.getjTextFieldKolicina().getText().trim());
                    if(kolicina<1){
                        JOptionPane.showMessageDialog(asf, "Morate uneti broj veci od nula", "Greska", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch(NumberFormatException exc){
                        JOptionPane.showMessageDialog(asf, "Morate uneti broj", "Greska", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                s.setKolicina(kolicina);
                
                asf.dispose();
                
                cordinator.Cordinator.getInstance().dodajParam("izmenjenaStavka", s);
                cordinator.Cordinator.getInstance().izmeniStavku();
            }
        });
    }
    
    public void pripremiFormu(){
        s = (StavkaRacuna) cordinator.Cordinator.getInstance().vratiParametar("stavka");
        asf.getjTextFieldKolicina().setText(s.getKolicina()+"");
    }
}