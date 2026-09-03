/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Racun;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puaca
 */
public class ModelTabeleRacun extends AbstractTableModel{
    private List<Racun> lista = new ArrayList<>();
    private String[] kolone = {"id","datum","ukupan iznos","prodavac","kupac"};

    public ModelTabeleRacun() {
    }

    public ModelTabeleRacun(List<Racun> lista) {
        this.lista = lista;
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
        Racun r = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return r.getIdRacun();
            case 1:
                return r.getDatum();
            case 2:
                return r.getUkupanIznos();
            case 3:
                return r.getProdavac();
            case 4:
                return r.getKupac();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Racun> getLista() {
        return lista;
    }
    
    
    
}
