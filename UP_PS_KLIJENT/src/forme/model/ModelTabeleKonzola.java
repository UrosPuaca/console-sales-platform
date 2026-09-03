/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Konzola;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puaca
 */
public class ModelTabeleKonzola extends AbstractTableModel{
    private List<Konzola> lista = new ArrayList<>();
    private String[] kolone = {"id","naziv","cena","opis"};

    public ModelTabeleKonzola() {
    }

    public ModelTabeleKonzola(List<Konzola> lista) {
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
        Konzola k = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return k.getIdKonzola();
            case 1:
                return k.getNaziv();
            case 2:
                return k.getCena();
            case 3:
                return k.getOpis();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Konzola> getLista() {
        return lista;
    }
    
    
}
