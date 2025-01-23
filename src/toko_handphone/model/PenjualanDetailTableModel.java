/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import toko_handphone.entity.PenjualanDetail;
/**
 *
 * @author Haykal Aditya
 */
public class PenjualanDetailTableModel extends AbstractTableModel {
    private List<PenjualanDetail> rows;

    public PenjualanDetailTableModel(List<PenjualanDetail> entities) {
        this.rows = entities;
    }

    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {
        return 6; // jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PenjualanDetail penjualanDetail = this.rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return penjualanDetail.getBarang().getImei();
            case 1:
                return penjualanDetail.getBarang().getMerk_hp();
            case 2:
                return penjualanDetail.getBarang().getStorage();
            case 3:
                return penjualanDetail.getKuantiti();
            case 4:
                return penjualanDetail.getHarga();
            case 5:
                return penjualanDetail.getKuantiti() * penjualanDetail.getHarga();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "imei";
            case 1:
                return "merk_hp";
            case 2:
                return "storage";
            case 3:
                return "kuantiti";
            case 4:
                return "harga";
            case 5:
                return "jumlah";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return Integer.class;
            default:
                return super.getColumnClass(columnIndex);
        }
    }

    public List<PenjualanDetail> getRows() {
        return rows;
    }

    public void setRows(List<PenjualanDetail> rows) {
        this.rows = rows;
    }
}