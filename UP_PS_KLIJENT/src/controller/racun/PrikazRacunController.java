/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.racun;

import domen.Kupac;
import domen.Prodavac;
import domen.Racun;
import forme.model.ModelTabeleRacun;
import forme.racun.PrikazRacunForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author puaca
 */
public class PrikazRacunController {
    private final PrikazRacunForma prf;

    public PrikazRacunController(PrikazRacunForma prf) {
        this.prf = prf;
        addActionListeners();
    }
    
    public void otvoriFormu(){
        prf.setVisible(true);
        pripremiFormu();
    }
    
    private void pripremiFormu() {
        List<Racun> racuni = komunikacija.Komunikacija.getInstance().ucitajRacune();
        ModelTabeleRacun mtr = new ModelTabeleRacun(racuni);
        prf.getjTableRacun().setModel(mtr);
        
//        ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna();
//        prf.getjTableStavke().setModel(mts);
        
        List<Prodavac> prodavci = Komunikacija.getInstance().ucitajProdavce();
        prf.getjComboBoxProdavac().removeAllItems();
        for (Prodavac p : prodavci) {
            prf.getjComboBoxProdavac().addItem(p);
        }
        List<Kupac> kupci = Komunikacija.getInstance().ucitajKupce();
        prf.getjComboBoxKupac().removeAllItems();
        for (Kupac k : kupci) {
            prf.getjComboBoxKupac().addItem(k);
        }
    }
    
        private void addActionListeners() {
            prf.addBtnAzurirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableRacun().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje racun", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleRacun mtr = (ModelTabeleRacun) prf.getjTableRacun().getModel();
                    Racun r = mtr.getLista().get(red);
                    JOptionPane.showMessageDialog(prf, "Sistem je nasao racun", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("racun", r);
                    cordinator.Cordinator.getInstance().otvoriAzurirajRacunFormu();
                }
            }
        });
            
            prf.addBtnPretraziPoProdavcuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prodavac p = (Prodavac) prf.getjComboBoxProdavac().getSelectedItem();
                try{
                    List<Racun> racuni = komunikacija.Komunikacija.getInstance().ucitajRacune(p);
                    ModelTabeleRacun mtr = new ModelTabeleRacun(racuni);
                    prf.getjTableRacun().setModel(mtr);
                    
//                    ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna();
//                    prf.getjTableStavke().setModel(mts);
                    
                    if(racuni.size()>0){
                        JOptionPane.showMessageDialog(prf, "Sistem je nasao racune po zadatim kriterijumima", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje racune po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                    }  
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje racune po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
            
            prf.addBtnPretraziPoKupcuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kupac k = (Kupac) prf.getjComboBoxKupac().getSelectedItem();
                try{
                    List<Racun> racuni = komunikacija.Komunikacija.getInstance().ucitajRacune(k);
                    ModelTabeleRacun mtr = new ModelTabeleRacun(racuni);
                    prf.getjTableRacun().setModel(mtr);
                    
//                    ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna();
//                    prf.getjTableStavke().setModel(mts);
                    
                    if(racuni.size()>0){
                        JOptionPane.showMessageDialog(prf, "Sistem je nasao racune po zadatim kriterijumima", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje racune po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                         
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje racune po zadatim kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
            
            
            prf.addBtnRefreshActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziFormu();
            }
        });
            
            prf.addBtnPrikaziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableRacun().getSelectedRow();
                if(red==-1){
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje racun", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleRacun mtr = (ModelTabeleRacun) prf.getjTableRacun().getModel();
                    Racun r = mtr.getLista().get(red);
                    
                    JOptionPane.showMessageDialog(prf, "Sistem je nasao racun", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("racun", r);
                    cordinator.Cordinator.getInstance().otvoriRacunZaPrikazFormu();
                    
//                    try{
//                        List<StavkaRacuna> stavke = new ArrayList<>();
//                        r = komunikacija.Komunikacija.getInstance().ucitajRacun(r);
//                        for (StavkaRacuna sr : r.getStavke()) {
//                            stavke.add(sr);
//                        }
//                        popuniTabeluStavke(stavke);
//                        JOptionPane.showMessageDialog(prf, "Sistem je nasao racun", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
//                        
//                        
//                    }catch(Exception ex){
//                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje racun", "Greska", JOptionPane.WARNING_MESSAGE);
//                    }
                }
            }
        });
        

    }
        
        
   public void osveziFormu() {
        pripremiFormu();
    }
    
    
    
}
