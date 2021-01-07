/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daointerface.Isiswa;
import helper.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.siswa;

/**
 *
 * @author asus
 */
public class DAOSiswa implements Isiswa{

    public DAOSiswa(){
        con=koneksi.connection();
    }
    
    @Override
    public List<siswa> getAll() {
        List<siswa> lstsiswa = null;
        try{
            lstsiswa = new ArrayList<siswa>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(read);
            while(rs.next()){
                siswa Siswa = new siswa();
                Siswa.setNis(rs.getString("nis"));
                Siswa.setNama(rs.getString("nama"));
                Siswa.setJurusan(rs.getString("jurusan"));
                Siswa.setJk(rs.getString("jk"));
                Siswa.setAlamat(rs.getString("alamat"));
                lstsiswa.add(Siswa);
            }
        }
        catch(SQLException e){
            System.out.println("error");
            
        }
        return lstsiswa;
    }
    
   

    @Override
    public void insert(siswa b) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(insert);
            statement.setString(1, b.getNis());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getJurusan());
            statement.setString(4, b.getJk());
            statement.setString(5, b.getAlamat());
            statement.execute();
        } catch(SQLException e)
        {
            System.out.println("gagal input");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal input");
            }
        }
    }
    
     

    
    @Override
    public void update(siswa b) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(update);
            
            statement.setString(1, b.getNama());
            statement.setString(2, b.getJurusan());
            statement.setString(3, b.getJk());
            statement.setString(4, b.getAlamat());
            statement.setString(5, b.getNis());
            statement.execute();
        } catch(SQLException e)
        {
            System.out.println("gagal update");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal update");
            }
        }
       
    }
    
    @Override
    public void delete(String nis) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(delete);
            statement.setString(1, nis);
            statement.execute();
        } catch(SQLException e)
        {
            System.out.println("gagal delete");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal delete");
            }
        }
    }
    
    Connection con;
    String read = "select * from siswa;";
    String insert = "insert into siswa (nis,nama,jurusan,jk,alamat) values (?,?,?,?,?);";
    String update = "update siswa set nama=?, jurusan=?, jk=?, alamat=? where nis=?;";
    String delete = "delete from siswa where nis=?;";
    

}
