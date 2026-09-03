/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.grad;

import domen.Grad;
import forme.grad.PrikaziGradForma;
import forme.model.ModelTabeleGrad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author puaca
 */
public class PrikaziGradController {
    private final PrikaziGradForma pgf;

    public PrikaziGradController(PrikaziGradForma pgf) {
        this.pgf = pgf;
        addActionListeners();
    }

    private void addActionListeners() {
        pgf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pgf.getjTableGrad().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovani grad");
                    JOptionPane.showMessageDialog(pgf, "Sistem ne moze da obrise grad", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleGrad mtg = (ModelTabeleGrad) pgf.getjTableGrad().getModel();
                    Grad g = mtg.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiGrad(g);
                        JOptionPane.showMessageDialog(pgf, "Sistem je uspesno obrisao grad", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(pgf, "Sistem ne moze da obrise grad", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
            }
        });
        
        pgf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pgf.getjTableGrad().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovali grad");
                    JOptionPane.showMessageDialog(pgf, "Sistem ne moze da pronadje grad", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleGrad mtg = (ModelTabeleGrad) pgf.getjTableGrad().getModel();
                    Grad g = mtg.getLista().get(red);
                    JOptionPane.showMessageDialog(pgf, "Sistem je pronasao grad", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("grad", g);
                    cordinator.Cordinator.getInstance().otvoriIzmeniGradFormu();
                }
            }
        });
        
        pgf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = pgf.getjTextFieldNaziv().getText().trim().toLowerCase();
                if (!naziv.matches("[a-zA-ZčćžšđČĆŽŠĐ]+")) {
                    JOptionPane.showMessageDialog(pgf, "Sistem ne moze da pronadje grad", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try{
                    List<Grad> gradovi = komunikacija.Komunikacija.getInstance().ucitajGradove(naziv);
                    if(gradovi.size()>0){
                        JOptionPane.showMessageDialog(pgf, "Sistem je pronasao grad", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleGrad mtg = new ModelTabeleGrad(gradovi);
                        pgf.getjTableGrad().setModel(mtg);
                    }
                    else{
                        JOptionPane.showMessageDialog(pgf, "Sistem ne moze da pronadje grad", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pgf, "Sistem ne moze da pronadje grad", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        pgf.addBtnRefreshActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziFormu();
            }
        });
        
    }

    public void otvoriFormu() {
        pripremiFormu();
        pgf.setVisible(true);
    }

    private void pripremiFormu() {
        List<Grad> gradovi = komunikacija.Komunikacija.getInstance().ucitajGradove();
        ModelTabeleGrad mtg = new ModelTabeleGrad(gradovi);
        pgf.getjTableGrad().setModel(mtg);
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
}
