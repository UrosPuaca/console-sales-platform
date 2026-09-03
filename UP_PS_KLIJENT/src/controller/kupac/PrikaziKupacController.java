/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.kupac;

import domen.Grad;
import domen.Kupac;
import forme.kupac.PrikaziKupacForma;
import forme.model.ModelTabeleKupac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author puaca
 */
public class PrikaziKupacController {
    private final PrikaziKupacForma pkf;
    
    public PrikaziKupacController(PrikaziKupacForma pkf) {
        this.pkf = pkf;
        addActionListeners();
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        pkf.setVisible(true);
        pkf.getjButtonObrisi().setVisible(false);
    }

    private void pripremiFormu() {
        List<Kupac> kupci = komunikacija.Komunikacija.getInstance().ucitajKupce();
        ModelTabeleKupac mtk = new ModelTabeleKupac(kupci);
        pkf.getjTableKupac().setModel(mtk);
        
        List<Grad> gradovi = komunikacija.Komunikacija.getInstance().ucitajGradove();
        pkf.getjComboBoxGrad().removeAllItems();
        for (Grad g : gradovi) {
        pkf.getjComboBoxGrad().addItem(g);
        }
        
    }

    private void addActionListeners() {
        pkf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pkf.getjTableKupac().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovani kupca");
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise kupca", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleKupac mtk = (ModelTabeleKupac) pkf.getjTableKupac().getModel();
                    Kupac k = mtk.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiKupca(k);
                        JOptionPane.showMessageDialog(pkf, "Sistem je obrisao kupca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise kupca", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        pkf.addBtnAzurirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pkf.getjTableKupac().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje kupca", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleKupac mtk = (ModelTabeleKupac) pkf.getjTableKupac().getModel();
                    Kupac k = mtk.getLista().get(red);
                    JOptionPane.showMessageDialog(pkf, "Sistem je nasao kupca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("kupac", k);
                    cordinator.Cordinator.getInstance().otvoriAzurirajKupacFormu();
                }
            }
        });
        
        pkf.addBtnPrikaziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pkf.getjTableKupac().getSelectedRow();
                if(red==-1){
                JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje kupca", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleKupac mtk = (ModelTabeleKupac) pkf.getjTableKupac().getModel();
                    Kupac k = mtk.getLista().get(red);
                    JOptionPane.showMessageDialog(pkf, "Sistem je nasao kupca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("kupac", k);
                    cordinator.Cordinator.getInstance().otvoriKupacZaPrikazFormu();
                }
            }   
        });
        
        pkf.addBtnPretraziPoPrezimenuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prezime = pkf.getjTextFieldPrezime().getText().trim().toLowerCase();
                if (!prezime.matches("[a-zA-ZčćžšđČĆŽŠĐ]+")) {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje kupce po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    List<Kupac> kupci = komunikacija.Komunikacija.getInstance().ucitajKupce(prezime);
                    if(kupci.size()>0){
                        JOptionPane.showMessageDialog(pkf, "Sistem je nasao kupce po zadatim kriterijumima", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleKupac mtk = new ModelTabeleKupac(kupci);
                        pkf.getjTableKupac().setModel(mtk);
                    }
                    else{
                        JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje kupce po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje kupce po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        pkf.addBtnPretraziPoGraduActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grad g = (Grad) pkf.getjComboBoxGrad().getSelectedItem();
                try{
                    List<Kupac> kupci = komunikacija.Komunikacija.getInstance().ucitajKupce(g);
                    
                    if(kupci.size()>0){
                        ModelTabeleKupac mtk = new ModelTabeleKupac(kupci);
                        pkf.getjTableKupac().setModel(mtk);
                        JOptionPane.showMessageDialog(pkf, "Sistem je nasao kupce po zadatim kriterijumima", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje kupce po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje kupce po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        pkf.addBtnRefreshActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziFormu();
            }
        });
        
        
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
    
}
