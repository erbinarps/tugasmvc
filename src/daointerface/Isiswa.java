/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daointerface;

import java.util.List;
import model.siswa;

/**
 *
 * @author asus
 */
public interface Isiswa {
    public List<siswa> getAll();
    public void insert (siswa b);
    public void update (siswa b);
    public void delete (String nis);
}
