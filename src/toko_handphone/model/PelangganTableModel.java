package toko_handphone.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import toko_handphone.entity.Pelanggan;

/**
 * Table model untuk entitas pelanggan
 */
public class PelangganTableModel extends AbstractTableModel {
    private List<Pelanggan> rows;

    public PelangganTableModel(List<Pelanggan> list) {
        this.rows = list;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // jumlah kolom
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pelanggan pelanggan = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pelanggan.getKode();
            case 1:
                return pelanggan.getNama();
            case 2:
                return pelanggan.getAlamat();
            case 3:
                return pelanggan.getTelepon();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
            case 3:
                return "Telepon";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class; // semua kolom bertipe String
    }

    public void setRows(List<Pelanggan> list) {
        this.rows = list;
        fireTableDataChanged(); // beri tahu tabel bahwa data telah berubah
    }

    public List<Pelanggan> getRows() {
        return rows;
    }
}
