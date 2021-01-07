/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author asus
 */
public class koneksi {
    static Connection con;
    
    public static Connection connection(){
        if (con==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("sekolah");
            data.setUser("root");
            data.setPassword("");
            try{
                con = data.getConnection();
                System.out.println("koneksi berhasil");
            } catch (SQLException e) {
                System.out.println ("gagal konek");
            }
                    
            
        }
        return con;
    }

    
    
}
