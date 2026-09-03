/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puaca
 */
public class ModelTabeleStavkaRacuna extends AbstractTableModel{
    private List<StavkaRacuna> lista = new ArrayList<>();
    private String[] kolone = {"rb","prodajna cena","kolicina","iznos","proizvod"};

    public ModelTabeleStavkaRacuna() {
    }
    
    public ModelTabeleStavkaRacuna(List<StavkaRacuna> lista) {
        this.lista=lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna s = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return s.getRb();
            case 1:
                return s.getProdajnaCena();
            case 2:
                return s.getKolicina();
            case 3:
                return s.getIznos();
            case 4:
                return s.getKonzola();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<StavkaRacuna> getLista() {
        return lista;
    }

    public void setLista(List<StavkaRacuna> lista) {
        this.lista = lista;
    }

    public void osveziPodatke() {
        fireTableDataChanged();
    }
    
    
    
}
