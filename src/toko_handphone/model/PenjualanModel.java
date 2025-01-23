/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import toko_handphone.entity.Penjualan;

/**
 *
 * @author Haykal Aditya
 */
public class PenjualanModel {
    private Connection connection;
    
    public PenjualanModel(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Penjualan penjualan) throws SQLException{
        String sql = "INSERT INTO tr_penjualan (nomor,tanggal,total,pelanggan) VALUES (?,?,?,?)";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, penjualan.getNomor());
        statemen.setDate(2, new java.sql.Date(penjualan.getTanggal().getTime()));
        statemen.setInt(3, penjualan.getTotal());
        statemen.setString(4, penjualan.getPelaggan().getKode());
        statemen.executeUpdate();
        statemen.close();
    }
}
