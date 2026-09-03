/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Grad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puaca
 */
public class ModelTabeleGrad extends AbstractTableModel{
    private List<Grad> lista = new ArrayList<>();
    String[] kolone = {"id","naziv"};
    
    
    public ModelTabeleGrad() {
    }
    
    public ModelTabeleGrad(List<Grad> lista) {
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
        Grad g = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return g.getIdGrad();
            case 1:
                return g.getNaziv();
            default:
                return "N/A";
        }
    }
    

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Grad> getLista() {
        return lista;
    }
    
    
}
