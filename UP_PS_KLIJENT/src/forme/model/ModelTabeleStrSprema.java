/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.StrSprema;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puaca
 */
public class ModelTabeleStrSprema extends AbstractTableModel{
    private List<StrSprema> lista = new ArrayList<>();
    private String[] kolone = {"id","naziv"};
    
    public ModelTabeleStrSprema() {
    }
    
    public ModelTabeleStrSprema(List<StrSprema> lista) {
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
        StrSprema s = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return s.getIdStrSprema();
            case 1:
                return s.getNaziv();
            default:
                return "N/A";
        }
    }
    
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<StrSprema> getLista() {
        return lista;
    }
    
    
    
}
