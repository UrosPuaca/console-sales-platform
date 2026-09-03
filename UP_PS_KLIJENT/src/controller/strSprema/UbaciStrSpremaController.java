/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.strSprema;

import domen.StrSprema;
import forme.strSprema.UbaciStrSpremaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class UbaciStrSpremaController {
    private final UbaciStrSpremaForma usf;

    public UbaciStrSpremaController(UbaciStrSpremaForma usf) {
        this.usf = usf;
        addActionListener();
    }
    
    public void otvoriFormu(){
        usf.setVisible(true);
    }

    private void addActionListener() {
        usf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String naziv = usf.getjTextFieldIme().getText().trim();
                
                StrSprema s = new StrSprema(-1,naziv);
                
                
                try{
                    Komunikacija.getInstance().dodajStrSpremu(s);
                    JOptionPane.showMessageDialog(usf, "Sistem je zapamtio strucnu spremu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    usf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(usf, "Sistem ne moze da zapamti strucnu spremu", "Greska", JOptionPane.ERROR_MESSAGE);
                }        
                   
            }
        });
    }
    
}
