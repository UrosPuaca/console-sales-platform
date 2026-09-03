/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.grad;

import domen.Grad;
import forme.grad.DodajGradForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class DodajGradController {
    private final DodajGradForma dgf;

    public DodajGradController(DodajGradForma dgf) {
        this.dgf = dgf;
        addActionListener();
    }
    

    private void addActionListener() {
        dgf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String naziv = dgf.getjTextFieldIme().getText().trim();
                
                Grad g = new Grad(-1,naziv);
                
                
                try{
                    Komunikacija.getInstance().dodajGrad(g);
                    JOptionPane.showMessageDialog(dgf, "Sistem je dodao grad", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    
                    dgf.dispose();
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dgf, "Sistem ne moze da doda grad", "Greska", JOptionPane.WARNING_MESSAGE);
                }        
                   
            }
        });
    }
    
    public void otvoriFormu(){
        dgf.setVisible(true);
    }
}
