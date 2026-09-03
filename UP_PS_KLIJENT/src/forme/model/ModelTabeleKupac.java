/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Kupac;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puaca
 */
public class ModelTabeleKupac extends AbstractTableModel{
    private List<Kupac> lista = new ArrayList<>();
    private String[] kolone = {"id","ime","prezime","email","telefon","grad"};

    public ModelTabeleKupac() {
    }
    
    public ModelTabeleKupac(List<Kupac> lista) {
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
        Kupac k = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return k.getIdKupac();
            case 1:
                return k.getIme();   
            case 2:
                return k.getPrezime();
            case 3:
                return k.getEmail();
            case 4:
                return k.getTelefon();
            case 5:
                return k.getGrad().getNaziv();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Kupac> getLista() {
        return lista;
    }
    
}
