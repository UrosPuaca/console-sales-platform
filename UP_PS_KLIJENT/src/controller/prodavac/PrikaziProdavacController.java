/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.prodavac;

import com.sun.java.accessibility.util.AWTEventMonitor;
import domen.Prodavac;
import forme.model.ModelTabeleProdavac;
import forme.prodavac.PrikaziProdavacForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author puaca
 */
public class PrikaziProdavacController {
    private final PrikaziProdavacForma ppf;

    public PrikaziProdavacController(PrikaziProdavacForma ppf) {
        this.ppf = ppf;
        addActionListeners();
    }

    private void addActionListeners() {
        ppf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTableProdavci().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovani prodavca");
                    JOptionPane.showMessageDialog(ppf, "Sistem ne moze da obrise prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleProdavac mtp = (ModelTabeleProdavac) ppf.getjTableProdavci().getModel();
                    Prodavac p = mtp.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiProdavca(p);
                        JOptionPane.showMessageDialog(ppf, "Sistem je obrisao prodavca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(ppf, "Sistem ne moze da obrise prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
            }
        });
        
        
        ppf.addBtnAzurirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTableProdavci().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(ppf, "Sistem ne moze da nadje prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleProdavac mtp = (ModelTabeleProdavac) ppf.getjTableProdavci().getModel();
                    Prodavac p = mtp.getLista().get(red);
                    JOptionPane.showMessageDialog(ppf, "Sistem je nasao prodavca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("prodavac", p);
                    cordinator.Cordinator.getInstance().otvoriAzurirajProdavcaFormu();
                }
            }
        });
        
        ppf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prezime = ppf.getjTextFieldPrezime().getText().trim().toLowerCase();
                if (!prezime.matches("[a-zA-ZčćžšđČĆŽŠĐ]+")) {
                    JOptionPane.showMessageDialog(ppf, "Sistem ne moze da pronadje prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try{
                    List<Prodavac> prodavci = komunikacija.Komunikacija.getInstance().ucitajProdavce(prezime);
                    if(prodavci.size()>0){
                        JOptionPane.showMessageDialog(ppf, "Sistem je pronasao prodavca", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleProdavac mtp = new ModelTabeleProdavac(prodavci);
                        ppf.getjTableProdavci().setModel(mtp);
                    }
                    else{
                        JOptionPane.showMessageDialog(ppf, "Sistem ne moze da pronadje prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(ppf, "Sistem ne moze da pronadje prodavca", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        ppf.addBtnRefreshActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziFormu();
            }
        });
    }
    
    
    public void otvoriFormu() {
        pripremiFormu();
        ppf.setVisible(true);
    }

    private void pripremiFormu() {
        List<Prodavac> prodavci = komunikacija.Komunikacija.getInstance().ucitajProdavce();
        ModelTabeleProdavac mtp = new ModelTabeleProdavac(prodavci);
        ppf.getjTableProdavci().setModel(mtp);
    }

    public void osveziFormu() {
        pripremiFormu();
    }
   
    
    
}
