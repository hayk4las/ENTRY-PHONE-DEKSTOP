/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_handphone.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import toko_handphone.entity.Pelanggan;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PelangganModel {
    private Connection connection;
    
    public PelangganModel (Connection connection){
        this.connection = connection;
    }
    
    public void insert (Pelanggan pelanggan) throws SQLException {
        String sql = 
                "INSERT INTO"
                + " pelanggan("
                    + " kode,"
                    + " nama, "
                    + " alamat, "
                    + " telepon"
                + ")"
            + "VALUES ("
                + "?, "
                + "?, "
                + "?, "
                + "?"
            +")";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, pelanggan.getKode());
        statemen.setString(2, pelanggan.getNama());
        statemen.setString(3, pelanggan.getAlamat());
        statemen.setString(4, pelanggan.getTelepon());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public void update(Pelanggan pelanggan) throws SQLException {
    String sql = 
        "UPDATE pelanggan SET "
        + " nama = ?, "
        + " alamat = ?, "
        + " telepon = ? "
        + " WHERE kode = ?";
    
    PreparedStatement statemen = connection.prepareStatement(sql);
    statemen.setString(1, pelanggan.getNama());
    statemen.setString(2, pelanggan.getAlamat());
    statemen.setString(3, pelanggan.getTelepon());
    statemen.setString(4, pelanggan.getKode());
    statemen.executeUpdate();
    statemen.close();
}


     public void delete(Pelanggan pelanggan) throws SQLException {
        String sql = 
                "DELETE FROM pelanggan "  // Tambahkan 'FROM' dan spasi setelah nama tabel
                    + "WHERE kode = ?";
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, pelanggan.getKode());
        statemen.executeUpdate();
        statemen.close();
     }
     
     public ResultSet getAllData() throws SQLException {
            String sql = "SELECT * FROM pelanggan";
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        }
     
    
     public List<Pelanggan> search(String keyword){
         String sql = 
                 "SELECT "
                 +" kode, "
                 +" nama, "
                 +" alamat,"
                 +" telepon "
                 +"FROM "
                    +" pelanggan "
                 +"WHERE "
                    +" kode LIKE ? "
                 +"OR "
                    +" nama LIKE ?";
         
         List<Pelanggan> list= new ArrayList<Pelanggan>();
         PreparedStatement statement = null;
         
         try{
             statement = connection.prepareStatement(sql);
             statement.setString(1, "%"+keyword+"%");
             statement.setString(2, "%"+keyword+"%");
             ResultSet result = statement.executeQuery();
             while (result.next()){
                 Pelanggan entity = new Pelanggan();
                 entity.setKode(result.getString("kode"));
                 entity.setNama(result.getString("nama"));
                 entity.setAlamat(result.getString("alamat"));
                 entity.setTelepon(result.getString("telepon"));
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
     public List<Pelanggan> getData(){
        String sql = "SELECT * FROM pelanggan";
        List<Pelanggan> list  = new ArrayList<Pelanggan>();
        PreparedStatement statmen = null;
        
        try{
            statmen = connection.prepareStatement(sql);
            ResultSet result = statmen.executeQuery();
            while(result.next()){
                Pelanggan entity = new Pelanggan();
                
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setAlamat(result.getString("alamat"));
                entity.setTelepon(result.getString("telepon"));
                list.add(entity);
            }
            result.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statmen.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return list;
     }
}
