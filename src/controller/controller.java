/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOSiswa;
import daointerface.Isiswa;
import java.util.List;
import javax.swing.JOptionPane;
import model.siswa;
import model.tabel;
import view.Form;

/**
 *
 * @author asus
 */
public class controller {
    
    public controller(Form formsiswa){
        this.formsiswa = formsiswa;
        isiswa = new DAOSiswa();
        isiswa.getAll();
        
    }
    
    public void isiTabel(){
        lstsiswa = isiswa.getAll();
        tabel tabelsiswa = new tabel(lstsiswa);
        formsiswa.getTabelData().setModel(tabelsiswa);
    }
    
    public void insert(){
        siswa b = new siswa();
        b.setNis(formsiswa.getnis().getText());
        b.setNama(formsiswa.getnama().getText());
        b.setJurusan((String) formsiswa.getjurusan().getSelectedItem());
        b.setJk((String) formsiswa.getjk().getSelectedItem());
        b.setAlamat(formsiswa.getalamat().getText());
        
        isiswa.insert(b);
        JOptionPane.showMessageDialog(null, "input berhasil");
        
    }
    
    public void reset(){
        
        if(!formsiswa.getnis().isEnabled())
            formsiswa.getnis().setEnabled(true);
        formsiswa.getnis().setText("");
        formsiswa.getnama().setText("");
        formsiswa.getjurusan().setSelectedItem("IPA");
        formsiswa.getjk().setSelectedItem("L");
        formsiswa.getalamat().setText("");
    }
    
    public void isifield(int row){
        formsiswa.getnis().setEnabled(false);
        formsiswa.getnis().setText(lstsiswa.get(row).getNis());
        formsiswa.getnama().setText(lstsiswa.get(row).getNama());
        formsiswa.getjurusan().setSelectedItem(lstsiswa.get(row).getJurusan());
        formsiswa.getjk().setSelectedItem(lstsiswa.get(row).getJk());
        formsiswa.getalamat().setText(lstsiswa.get(row).getAlamat());
    }
    
    public void update(){
        siswa b = new siswa();
        
        b.setNama(formsiswa.getnama().getText());
        b.setJurusan((String) formsiswa.getjurusan().getSelectedItem());
        b.setJk((String) formsiswa.getjk().getSelectedItem());
        b.setAlamat(formsiswa.getalamat().getText());
        b.setNis(formsiswa.getnis().getText());
        
        isiswa.update(b);
        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
        public void delete(){
        siswa b = new siswa();
       
       
        
        isiswa.delete(formsiswa.getnis().getText());
        JOptionPane.showMessageDialog(null, "delete berhasil");
    }
    
    Form formsiswa;
    Isiswa isiswa;
    List<siswa> lstsiswa;
    
}
