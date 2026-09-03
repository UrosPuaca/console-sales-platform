/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.strSprema;

import domen.StrSprema;
import forme.model.ModelTabeleStrSprema;
import forme.strSprema.PrikaziStrSpremaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author puaca
 */
public class PrikaziStrSpremaController {
    private final PrikaziStrSpremaForma psf;

    public PrikaziStrSpremaController(PrikaziStrSpremaForma psf) {
        this.psf = psf;
        addActionListeners();
    }

    private void addActionListeners() {
        psf.addBtnObrisiActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = psf.getjTableStrSprema().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovani strucnu spremu");
                    JOptionPane.showMessageDialog(psf, "Sistem ne moze da obrise strucnu spremu", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleStrSprema mts = (ModelTabeleStrSprema) psf.getjTableStrSprema().getModel();
                    StrSprema s = mts.getLista().get(red);
                    try{
                        komunikacija.Komunikacija.getInstance().obrisiStrSprema(s);
                        JOptionPane.showMessageDialog(psf, "Sistem je uspesno obrisao strucnu spremu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(psf, "Sistem ne moze da obrise strucnu spremu", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
            }
            
        });
        
        psf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = psf.getjTableStrSprema().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovali strucnu spremu");
                    JOptionPane.showMessageDialog(psf, "Sistem ne moze da nadje strucnu spremu", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleStrSprema mts = (ModelTabeleStrSprema) psf.getjTableStrSprema().getModel();
                    StrSprema s = mts.getLista().get(red);
                    JOptionPane.showMessageDialog(psf, "Sistem je nasao strusnu spremu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("strsprema", s);
                    cordinator.Cordinator.getInstance().otvoriIzmeniStrSpremaFormu();
                }
            }
        });
        
        psf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = psf.getjTextFieldNaziv().getText().trim().toLowerCase();
                if (!naziv.matches("[a-zA-ZčćžšđČĆŽŠĐ]+")) {
                    JOptionPane.showMessageDialog(psf, "Sistem ne moze da pronadje strucnu spremu", "Greska", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try{
                    List<StrSprema> sprema = komunikacija.Komunikacija.getInstance().ucitajStrSpreme(naziv);
                    if(sprema.size()>0){
                        JOptionPane.showMessageDialog(psf, "Sistem je pronasao strucnu spremu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleStrSprema mts = new ModelTabeleStrSprema(sprema);
                        psf.getjTableStrSprema().setModel(mts);
                    }
                    else{
                        JOptionPane.showMessageDialog(psf, "Sistem ne moze da pronadje strucnu spremu", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(psf, "Sistem ne moze da pronadje strucnu spremu", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        psf.addBtnRefreshActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziFormu();
            }
        });
        
        
        
        
        
    }
    
    public void otvoriFormu() {
        pripremiFormu();
        psf.setVisible(true);
    }

    private void pripremiFormu() {
        List<StrSprema> spreme = komunikacija.Komunikacija.getInstance().ucitajStrSpreme();
        ModelTabeleStrSprema mts = new ModelTabeleStrSprema(spreme);
        psf.getjTableStrSprema().setModel(mts);
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
}
