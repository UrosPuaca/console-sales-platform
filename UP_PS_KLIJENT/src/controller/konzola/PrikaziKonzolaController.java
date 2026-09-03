/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.konzola;

import domen.Konzola;
import forme.konzola.PrikaziKonzolaForma;
import forme.model.ModelTabeleKonzola;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author puaca
 */
public class PrikaziKonzolaController {
    private final PrikaziKonzolaForma pkf;

    public PrikaziKonzolaController(PrikaziKonzolaForma pkf) {
        this.pkf = pkf;
        addActionListeners();
    }

    private void addActionListeners() {
        pkf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pkf.getjTableKonzole().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovani konzolu");
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise konzolu", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleKonzola mtk = (ModelTabeleKonzola) pkf.getjTableKonzole().getModel();
                    Konzola k = mtk.getLista().get(red);
                try{
                        komunikacija.Komunikacija.getInstance().obrisiKonzolu(k);
                        JOptionPane.showMessageDialog(pkf, "Sistem je obrisao konzolu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(pkf, "Sistem ne moze da obrise konzolu", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
            }
        });
        
        pkf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pkf.getjTableKonzole().getSelectedRow();
                if(red==-1){
                    System.out.println("Niste selektovali konzolu");
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje konzolu", "Greska", JOptionPane.WARNING_MESSAGE);
                }else{
                    ModelTabeleKonzola mtk = (ModelTabeleKonzola) pkf.getjTableKonzole().getModel();
                    Konzola k = mtk.getLista().get(red);
                    JOptionPane.showMessageDialog(pkf, "Sistem je nasao konzolu", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().dodajParam("konzola", k);
                    cordinator.Cordinator.getInstance().otvoriAzurirajKonzoluFormu();
                }
            }
        });
        
        pkf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = pkf.getjTextFieldNaziv().getText().trim().toLowerCase();
                
                try{
                    List<Konzola> konzole = komunikacija.Komunikacija.getInstance().ucitajKonzole(naziv);
                    if(konzole.size()>0){
                        JOptionPane.showMessageDialog(pkf, "Sistem je pronasao konzolu po zadatim kriterijumima", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                        ModelTabeleKonzola mtk = new ModelTabeleKonzola(konzole);
                        pkf.getjTableKonzole().setModel(mtk);
                    }
                    else{
                        JOptionPane.showMessageDialog(pkf, "Sistem ne moze da pronadje konzolu po zadatim kriterijumima", "Greska", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da pronadje konzolu po zadatim kriterijumima", "Greska", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        pkf.addBtnRefreshActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziFormu();
            }
        });
        
        pkf.getjTableKonzole().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = pkf.getjTableKonzole().rowAtPoint(evt.getPoint());
                int col = pkf.getjTableKonzole().columnAtPoint(evt.getPoint());

                // Proveri da li je kliknuto na validno polje
                if (row >= 0 && col >= 0) {
                    Object vrednost = pkf.getjTableKonzole().getValueAt(row, col);

                    // Ako želiš da reaguješ samo na određenu kolonu, recimo kolona 2:
                    if (col == 3) {
                        JOptionPane.showMessageDialog(
                                null,
                                vrednost,
                                "Opis Konzole",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });
    
    }
    
    public void otvoriFormu(){
        pripremiFormu();
        pkf.setVisible(true);
    }

    private void pripremiFormu() {
        List<Konzola> konzole = komunikacija.Komunikacija.getInstance().ucitajKonzole();
        ModelTabeleKonzola mtk = new ModelTabeleKonzola(konzole);
        pkf.getjTableKonzole().setModel(mtk);
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
    
}
