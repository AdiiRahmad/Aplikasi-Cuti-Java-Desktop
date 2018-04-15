/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DetailKaryawanDAO;
import entities.DetailKaryawan;
import entities.Jabatan;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Siti Khusnul Azifah
 */
public class DetailKaryawanController {
    
    DetailKaryawanDAO dkDAO = new DetailKaryawanDAO();
    
    public boolean insert(String nik, Jabatan idJabatan) {
        DetailKaryawan dk = new DetailKaryawan(nik, idJabatan);
        return dkDAO.insert(dk);
    }
     
    public boolean delete(String nik) {
        return dkDAO.delete(nik);
    }
    
    public boolean update(String nik, Jabatan idJabatan) {
        DetailKaryawan dk = new DetailKaryawan(nik, idJabatan);
        return dkDAO.update(dk);
    }
      
    public void bindingAll(JTable table, String[] header)
    {
        bindingTable(table, header, dkDAO.getAll());
    }
    
    public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTable(table, header, dkDAO.search(category, cari));        
    }  
    
    public void bindingTable(JTable table, String[] header, List<Object> datas) {       
        DefaultTableModel model = new DefaultTableModel(header,0);
        for (Object data : datas) {
            DetailKaryawan dk = (DetailKaryawan)data;
            Object[] data1 = {
                dk.getNik(),
                dk.getIdJabatan()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
}
