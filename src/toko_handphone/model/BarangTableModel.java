/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toko_handphone.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import toko_handphone.entity.Barang;
/**
 *
 * @author Asus VivoBook
 */
public class BarangTableModel extends AbstractTableModel{
    private List<Barang> rows;
    
    public BarangTableModel(List<Barang>list){
        rows = list;
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
       return 4; //jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Barang perkiraan = rows.get(rowIndex);
        switch(columnIndex){
            case 0:
                return perkiraan.getImei();
            case 1:
                return perkiraan.getMerk_hp();
            case 2:
                return perkiraan.getStorage();
            case 3:
                return perkiraan.getHarga();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Imei";
            case 1:
                return "Merk_hp";
            case 2:
                return "Storage";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            default:
                return super.getColumnClass(columnIndex);
        }
    }
    
    public void setRows(List<Barang> list){
        rows = list;
    }
    
    public List<Barang> getrows(){
        return rows;
    }
}
