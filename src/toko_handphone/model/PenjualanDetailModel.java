/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import toko_handphone.entity.PenjualanDetail;

/**
 *
 * @author Haykal Aditya
 */
public class PenjualanDetailModel {
    private Connection connection;
    
    public PenjualanDetailModel(Connection connection){
        this.connection = connection;
    }
    
    public void insert(PenjualanDetail penjualanDetail) throws SQLException{
        String sql = "INSERT INTO tr_penjualan_detail (kuantiti,harga,barang,penjualan) VALUES (?,?,?,?)";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setInt(1, penjualanDetail.getKuantiti());
        statemen.setInt(2, penjualanDetail.getHarga());
        statemen.setString(3, penjualanDetail.getBarang().getImei());
        statemen.setString(4, penjualanDetail.getPenjualan().getNomor());
        statemen.executeUpdate();
        statemen.close();
    }
}
