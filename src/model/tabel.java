/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asus
 */
public class tabel extends AbstractTableModel{

    private final List<siswa> lstsiswa;
    
    public tabel (List<siswa> lstsiswa){
        this.lstsiswa = lstsiswa;
        
    }
            
    @Override
    public int getRowCount() {
        return this.lstsiswa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
                return "nis";
            case 1:
                return "nama";
            case 2:
                return "jurusan";
            case 3:
                return "jk";
            case 4:
                return "alamat";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return lstsiswa.get(rowIndex).getNis();
            case 1:
                return lstsiswa.get(rowIndex).getNama();
            case 2:
                return lstsiswa.get(rowIndex).getJurusan();
            case 3:
                return lstsiswa.get(rowIndex).getJk();
            case 4:
                return lstsiswa.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }
    
}
