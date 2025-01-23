
package toko_handphone.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    
    private Connection koneksi;

    public UserModel(Connection connection) {
        this.koneksi = connection;
    }
    
    public boolean login (String username, String password){
        String sql = "SELECT * From user WHERE username = ? AND password = MD5(?)";
        PreparedStatement statmen = null;
        boolean status = false;
        try{
            statmen = koneksi.prepareStatement(sql);
            
            statmen.setString(1, username);
            statmen.setString(2, password);
            ResultSet result = statmen.executeQuery();
            status = result.first() ? true : false;
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
        return status;
    }
    
}
