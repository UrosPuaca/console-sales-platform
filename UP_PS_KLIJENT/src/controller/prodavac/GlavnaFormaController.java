/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.prodavac;

import domen.Prodavac;
import forme.prodavac.GlavnaForma;

/**
 *
 * @author puaca
 */
public class GlavnaFormaController {
    private final GlavnaForma gf;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    private void addActionListeners() {
        
    }

    public void otvoriFormu() {
        Prodavac ulogovani = cordinator.Cordinator.getInstance().getUlogovani();
        String imePrezime = ulogovani.getIme()+" "+ulogovani.getPrezime();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText("Prodavac: " +imePrezime);
    }
    
}
