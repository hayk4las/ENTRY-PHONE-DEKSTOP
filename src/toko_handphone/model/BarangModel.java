/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import toko_handphone.entity.Barang;

/**
 *
 * @author Haykal Aditya
 */
public class BarangModel {
    private Connection connection;
    
    public BarangModel (Connection connection){
        this.connection = connection;
    }
    
    public void insert (Barang barang) throws SQLException {
        String sql = 
                "INSERT INTO"
                + " barang("
                    + " imei,"
                    + " merk_hp, "
                    + " storage, "
                    + " harga"
                + ")"
            + "VALUES ("
                + "?, "
                + "?, "
                + "?, "
                + "?"
            +")";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, barang.getImei());
        statemen.setString(2, barang.getMerk_hp());
        statemen.setString(3, barang.getStorage());
        statemen.setInt(4, barang.getHarga());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public void update(Barang barang) throws SQLException {
    String sql = 
        "UPDATE barang SET "
        + " merk_hp = ?, "
        + " storage = ?, "
        + " harga = ? "
        + " WHERE imei = ?";
    
    PreparedStatement statemen = connection.prepareStatement(sql);
    statemen.setString(1, barang.getMerk_hp());
    statemen.setString(2, barang.getStorage());
    statemen.setInt(3, barang.getHarga());
    statemen.setString(4, barang.getImei());
    statemen.executeUpdate();
    statemen.close();
    }
    
    public void delete(Barang barang) throws SQLException {
        String sql = 
                "DELETE FROM barang "  // Tambahkan 'FROM' dan spasi setelah nama tabel
                    + "WHERE imei = ?";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, barang.getImei());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public ResultSet getAllData() throws SQLException {
            String sql = "SELECT * FROM barang";
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
    }
    
    public List<Barang> search(String keyword){
         String sql = 
                 "SELECT "
                 +" imei, "
                 +" merk_hp, "
                 +" storage,"
                 +" harga "
                 +"FROM "
                    +" barang "
                 +"WHERE "
                    +" imei LIKE ? "
                 +"OR "
                    +" merk_hp LIKE ?";
         
         List<Barang> list= new ArrayList<Barang>();
         PreparedStatement statement = null;
         
         try{
             statement = connection.prepareStatement(sql);
             statement.setString(1, "%"+keyword+"%");
             statement.setString(2, "%"+keyword+"%");
             ResultSet result = statement.executeQuery();
             while (result.next()){
                 Barang entity = new Barang();
                 entity.setImei(result.getString("imei"));
                 entity.setMerk_hp(result.getString("merk_hp"));
                 entity.setStorage(result.getString("storage"));
                 entity.setHarga(result.getInt("harga"));
                 list.add(entity);
             }  
             result.close();
         }catch (SQLException ex){
             ex.printStackTrace();
         }finally{
             try{
                 statement.close();
             }catch (SQLException ex){
             ex.printStackTrace();
            } 
         }
         return list;
     }
     public List<Barang> getData(){
        String sql = 
                "SELECT "
                    + "imei, "
                    + "merk_hp, "
                    + "storage, "
                    + "harga "
                + "FROM "
                    + "barang "
                ;
        List<Barang> list = new ArrayList<Barang>();
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Barang entity = new Barang();
                entity.setImei(result.getString("imei"));
                entity.setMerk_hp(result.getString("merk_hp"));
                entity.setStorage(result.getString("storage"));
                entity.setHarga(result.getInt("harga"));
                list.add(entity);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
}
